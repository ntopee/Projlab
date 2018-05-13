package Program;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

/**
 * A karakter mozgását valósítja meg, egy paraméterként kapott irány szerint.
 * Számolja a karakter pontjait.
 */
public class Player extends Thing {

    private final double HONEY = 2.45;
    private final double OIL = (1/2.45);
    Image image = new Image(getClass().getResourceAsStream("FxSources/player.png"));
    @Override
    public String toString() {
        return "Player";
    }

    /**
     * Az atlagos player ereje
     */

    private final int avaragePlayerStrength = 50;

    /**
     * A munkas minimum ereje
     */
    private final int minimumPlayerStrength = 0;


    /**
     * A munkas maximum ereje
     */
    public static final int maximumPlayerStrength = 100;


    /**
     * Default constructor
     */
    public Player() {
        this.strength = 50;
        movable = true;
    }

    public Player(int index){
        image = new Image(getClass().getResourceAsStream("FxSources/player" + index + ".png"));
    }

    /**
     * Az adott játékos pontjait tárolja.
     */
    private int points;



    /**
     *
     * Az adott játékos erejét tárolja
     */

    private int strength;

    /**
     * Player-ként ütközik egy Box-al. Meghívja a Player Move metódusát az ellenkező irányba.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     * @param Force Az utkozes ereje
     */
    public void HitBy(Box b, Direction d, double Force) {
        Tile t = tile.GetNeighbour(d);
        
        tile.Remove(this);
        
        t.Add(this);

        for (Thing i : t.GetThings()) {
            if (!i.equals(this))
                i.PlayerPushedIntoIt(this);
        }
    }

    /**
     * Meghal az adott játékos.
     */
    public void Die() {
        tile.GetMap().getPlayersController().get(tile.GetMap().getPlayersController().indexOf(this)).SetPoints(points);
        tile.Remove(this);
        tile.GetMap().RemovePlayer(this);
    }

    /**
     * Hozzáad a játékos pontszámához egyet.
     * @param d Megadja hogy melyik irányban van a pontszerző játékos.
     */
    public void AddPoint(Direction d) {
        points++;
    }

    /**
     * Player-ként ütközik egy másik Player-rel.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     * @param Force Az utkozes ereje
     */
    public void HitBy(Player p, Direction d, double Force) {
        p.Move(Game.GetOpposite(d));
    }

    /**
     * A Player egy mezőt megy a megadott paraméter irányába.
     * @param d Mozgás iránya.
     */
    public void Move(Direction d) {

        Tile t = tile.GetNeighbour(d);

        tile.Remove(this);
        t.Add(this);

        for (Thing i : t.GetThings()){
            if (!i.equals(this))
                i.HitBy(this, d, strength);

        }
        this.tile.GetMap().CheckEndGame();
    }

    /**
     * Visszaadja a Player pontszámát.
     * @return visszaadja a játékos pontszámát
     */
    public int GetPoints() {
        return points;
    }

    /**
     * Be lehet vele állítani a Player pontszámát.
     * @param n Beállítja hogy mennyi pontja van a játékosnak.
     */
    public void SetPoints(int n) {
        points = n;
    }

    public void PlayerPushedIntoIt(Player p) {
        p.Die();
    }

    @Override
    public void draw(int x, int y, Canvas canvas) {

        canvas.getGraphicsContext2D().drawImage(image, x, y, Game.TILE_SIZE, Game.TILE_SIZE);
    }


    public int GetStregth(){
        System.out.println("< GetStrength");
        return strength;
    }

    public void Bee(){
        tile.SetHoney(HONEY);
    }

    public void USA(){
        tile.SetOil(OIL);
    }

}