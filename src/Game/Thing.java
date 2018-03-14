package Game;
import java.util.*;

/**
 * 
 */
public class Thing {

    /**
     * Default constructor
     */
    public Thing() {
    }

    /**
     * 
     */
    private boolean movable;

    /**
     * 
     */
    private Tile tile;

    /**
     * @param t
     */
    public void CollideWith(Thing t) {
        System.out.println(">CollideWith");
        // TODO implement here
        System.out.println("<CollideWith");
    }

    /**
     * @param p 
     * @param d
     */
    public void HitBy(Player p, Direction d) {
        System.out.println(">HitByPlayer");
        // TODO implement here
        System.out.println("<HitByPlayer");
    }

    /**
     * @param b 
     * @param d
     */
    public void HitBy(Box b, Direction d) {
        System.out.println(">HitByBox");
        // TODO implement here
        System.out.println("<HitByBox");
    }

    /**
     * 
     */
    public void Die() {
        System.out.println(">Die");
        // TODO implement here
        System.out.println("<Die");
    }

    /**
     * @param d
     */
    public void AddPoint(Direction d) {
        System.out.println(">AddPoint");
        // TODO implement here
        System.out.println("<AddPoint");
    }

    /**
     * @param p
     */
    public void PlayerPushedIntoIt(Player p) {
        System.out.println(">PlayerPushedIntoIt");
        // TODO implement here
        System.out.println(">PlayerPushedIntoIt");
    }

}