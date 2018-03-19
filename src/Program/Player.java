package Program;

import static Program.Main.tabber;
import static Program.Main.tabolo;

/**
 * A karakter mozgását valósítja meg, egy paraméterként kapott irány szerint.
 * Számolja a karakter pontjait.
 */
public class Player extends Thing {

    @Override
    public String toString() {
        return "Player";
    }

    /**
     * Default constructor
     */
    public Player() {
    }

    /**
     * Az adott játékos pontjait tárolja.
     */
    private int points;

    /**
     * Player-ként ütközik egy Box-al. Meghívja a Player Move metódusát az ellenkező irányba.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        tabber++;
        tabolo(tabber);
        System.out.println("> HitBy Box");
        
        Tile t = tile.GetNeighbour(d);
        
        tile.Remove(this);
        
        t.Add(this);

        for (Thing i : t.GetThings()) {
            if (!i.equals(this))
                i.PlayerPushedIntoIt(this);
        }


        tabolo(tabber);
        tabber--;

        System.out.println("< HitBy Box");
    }

    /**
     * Meghal az adott játékos.
     */
    public void Die() {
        tabber++;
        tabolo(tabber);
        System.out.println("> Die");
        tile.Remove(this);
        tile.GetMap().RemovePlayer(this);
        tabolo(tabber);
        tabber--;

        System.out.println("< Die");
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
     */
    public void HitBy(Player p, Direction d) {
        tabber++;
        tabolo(tabber);

        System.out.println("> HitBy Player");
        p.Move(Game.GetOpposite(d));


        tabolo(tabber);
        tabber--;

        System.out.println("< HitBy Player");
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
                i.HitBy(this, d);

        }

        tabolo(tabber);
        tabber--;

        System.out.println("< Move");

    }

    /**
     * Visszaadja a Player pontszámát.
     * @return
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
}