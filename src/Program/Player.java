package Program;

import javafx.scene.canvas.Canvas;

import static Program.Main.tabber;
import static Program.Main.tabolo;

/**
 * A karakter mozgását valósítja meg, egy paraméterként kapott irány szerint.
 * Számolja a karakter pontjait.
 */
public class Player extends Thing {

    private final double HONEY = 1.45;
    private final double OIL = 0.55;

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


    /**
     * Paraméteres konstruktor, így megadható a player ereje
     * @param Strength a munkás ereje
     */
    public Player(int Strength){
            movable = true;
            if(!(Strength<minimumPlayerStrength || Strength>maximumPlayerStrength)){
            this.strength = Strength;
            }
            else {
                this.strength = avaragePlayerStrength;
                System.err.println("The value is inappropriate, the player's strength is set to 50");
            }

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
        tabber++;
        tabolo(tabber);
        System.out.println("> Player HitBy Box");
        
        Tile t = tile.GetNeighbour(d);
        
        tile.Remove(this);
        
        t.Add(this);

        for (Thing i : t.GetThings()) {
            if (!i.equals(this))
                i.PlayerPushedIntoIt(this);
        }


        tabolo(tabber);
        tabber--;

        System.out.println("< Player HitBy Box");
    }

    /**
     * Meghal az adott játékos.
     */
    public void Die() {
        tabber++;
        tabolo(tabber);
        System.out.println("> Die Player");
        tile.Remove(this);
        tile.GetMap().RemovePlayer(this);
        tabolo(tabber);
        tabber--;

        System.out.println("< Die Player");
    }

    /**
     * Hozzáad a játékos pontszámához egyet.
     * @param d Megadja hogy melyik irányban van a pontszerző játékos.
     */
    public void AddPoint(Direction d) {
        tabber++;
        tabolo(tabber);
        System.out.println("> AddPoint");
        points++;

        tabolo(tabber);
        tabber--;

        System.out.println("< AddPoint");
    }

    /**
     * Player-ként ütközik egy másik Player-rel.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     * @param Force Az utkozes ereje
     */
    public void HitBy(Player p, Direction d, double Force) {
        tabber++;
        tabolo(tabber);

        System.out.println("> Player HitBy Player");
        p.Move(Game.GetOpposite(d));


        tabolo(tabber);
        tabber--;

        System.out.println("< Player HitBy Player");
    }

    /**
     * A Player egy mezőt megy a megadott paraméter irányába.
     * @param d Mozgás iránya.
     */
    public void Move(Direction d) {
        tabber++;
        tabolo(tabber);
        System.out.println("> Move");

        Tile t = tile.GetNeighbour(d);

        tile.Remove(this);
        t.Add(this);

        for (Thing i : t.GetThings()){
            if (!i.equals(this))
                i.HitBy(this, d, strength);

        }

        tabolo(tabber);
        tabber--;

        System.out.println("< Move");

    }

    /**
     * Visszaadja a Player pontszámát.
     * @return visszaadja a játékos pontszámát
     */
    public int GetPoints() {
        tabber++;
        tabolo(tabber);
        System.out.println("> GetPoints");

        tabolo(tabber);
        tabber--;

        System.out.println("< GetPoints");
        return points;
    }

    /**
     * Be lehet vele állítani a Player pontszámát.
     * @param n Beállítja hogy mennyi pontja van a játékosnak.
     */
    public void SetPoints(int n) {
        tabber++;
        tabolo(tabber);
        System.out.println("> SetPoints");
        points = n;

        tabolo(tabber);
        tabber--;


        System.out.println("< SetPoints");
    }

    public void PlayerPushedIntoIt(Player p) {
        tabber--;
        tabolo(tabber);
        System.out.println("> PlayerPushedIntoIt");

        p.Die();

        tabolo(tabber);
        tabber--;

        System.out.println("< PlayerPushedIntoIt");
    }

    @Override
    public void draw(int x, int y, Canvas canvas) {

    }


    public int GetStregth(){
        tabber++;
        tabolo(tabber);
        System.out.println("> GetStrength");

        tabolo(tabber);
        tabber--;

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