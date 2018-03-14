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
        // TODO implement here
    }

    /**
     * @param p 
     * @param d
     */
    public void HitBy(Player p, Direction d) {
        // TODO implement here
    }

    /**
     * @param b 
     * @param d
     */
    public void HitBy(Box b, Direction d) {
        // TODO implement here
    }

    /**
     * 
     */
    public void Die() {
        // TODO implement here
    }

    /**
     * @param d
     */
    public void AddPoint(Direction d) {
        // TODO implement here
    }

    /**
     * @param p
     */
    public void PlayerPushedIntoIt(Player p) {
        // TODO implement here
    }

}