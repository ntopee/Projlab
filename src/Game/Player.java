package Game;
import java.util.*;

/**
 * A karakter mozgását valósítja meg, egy paraméterként kapott irány szerint.
 * Számolja a karakter pontjait.
 */
public class Player extends Thing {

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
     * Player-ként ütközik egy dologgal.
     * @param t Thing referencia.
     */
    public void CollideWith(Thing t) {
        System.out.println(">CollideWith");
        // TODO implement here
        System.out.println("<CollideWith");
    }

    /**
     * Player-ként ütközik egy Box-al. Meghívja a Player Move metódusát az ellenkező irányba.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        System.out.println(">HitByBox");
        // TODO implement here
        System.out.println("<HitByBox");
    }

    /**
     * Meghal az adott játékos.
     */
    public void Die() {
        System.out.println(">Die");
        // TODO implement here
        System.out.println("<Die");
    }

    /**
     * Hozzáad a játékos pontszámához egyet.
     * @param d Megadja hogy melyik irányban van a pontszerző játékos.
     */
    public void AddPoint(Direction d) {
        System.out.println(">AddPoint");
        // TODO implement here
        System.out.println("<AddPoint");
    }

    /**
     * Player-ként ütközik egy másik Player-rel.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Player p, Direction d) {
        System.out.println(">HitByPlayer");
        // TODO implement here
        System.out.println("<HitByPlayer");
    }

    /**
     * A Player egy mezőt megy a megadott paraméter irányába.
     * @param d Mozgás iránya.
     */
    public void Move(Direction d) {
        System.out.println(">Move");
        // TODO implement here
        System.out.println("<Move");
    }

    /**
     * Visszaadja a Player pontszámát.
     * @return
     */
    public int GetPoints() {
        System.out.println(">GetPoints");
        // TODO implement here
        System.out.println("<GetPoints");
        return 0;
    }

    /**
     * Be lehet vele állítani a Player pontszámát.
     * @param n Beállítja hogy mennyi pontja van a játékosnak.
     */
    public void SetPoints(int n) {
        System.out.println(">SetPoints");
        // TODO implement here
        System.out.println("<SetPoints");
    }

}