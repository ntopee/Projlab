package Game;
import java.util.*;

/**
 *A Thing objektumok azok az objektumok, amelyek “rajta vannak” egy Tile-on.
 * A Thing osztály felelőssége, hogy ütközés során meghívja a CollideWith metódust, ami lekezeli a különböző Thing-ek ütközését.
 */
public class Thing {

    /**
     * Default constructor
     */
    public Thing() {
    }

    /**
     * Megadja, hogy lehet-e még mozgatni az adott dolgot.
     */
    private boolean movable;

    /**
     * Azon Tile referenciája, amin a Thing található.
     */
    private Tile tile;

    /**
     *  A dolog ütközik egy másik dologgal.
     * @param t
     */
    public void CollideWith(Thing t) {
        System.out.println(">CollideWith");
        // TODO implement here
        System.out.println("<CollideWith");
    }

    /**
     * A művelet, amit akkor kell végrehajtani,
     * ha a dolognak egy játékos ütközött.
     * @param p 
     * @param d
     */
    public void HitBy(Player p, Direction d) {
        System.out.println(">HitByPlayer");
        // TODO implement here
        System.out.println("<HitByPlayer");
    }

    /**
     * A művelet, amit akkor kell végrehajtani,
     * ha a dolognak egy láda ütközött.
     * @param b 
     * @param d
     */
    public void HitBy(Box b, Direction d) {
        System.out.println(">HitByBox");
        // TODO implement here
        System.out.println("<HitByBox");
    }

    /**
     * Egy cellán elhelyezkedő dolog megsemmisítése.
     */
    public void Die() {
        System.out.println(">Die");
        // TODO implement here
        System.out.println("<Die");
    }

    /**
     * Elintézi a pontszámítást.
     * @param d
     */
    public void AddPoint(Direction d) {
        System.out.println(">AddPoint");
        // TODO implement here
        System.out.println("<AddPoint");
    }

    /**
     * Azokat az eseteket kezeli le amikor egy játékos neki lökődik valaminek.
     * @param p
     */
    public void PlayerPushedIntoIt(Player p) {
        System.out.println(">PlayerPushedIntoIt");
        // TODO implement here
        System.out.println(">PlayerPushedIntoIt");
    }

}