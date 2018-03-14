package Game;
import java.util.*;

/**
 * 
 */
public class Player extends Thing {

    /**
     * Default constructor
     */
    public Player() {
    }

    /**
     * 
     */
    private int points;

    /**
     * @param t
     */
    public void CollideWith(Thing t) {
        System.out.println(">CollideWith");
        // TODO implement here
        System.out.println("<CollideWith");
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
     * @param d
     */
    public void HitBy(Player p, Direction d) {
        System.out.println(">HitByPlayer");
        // TODO implement here
        System.out.println("<HitByPlayer");
    }

    /**
     * @param d
     */
    public void Move(Direction d) {
        System.out.println(">Move");
        // TODO implement here
        System.out.println("<Move");
    }

    /**
     * @return
     */
    public int GetPoints() {
        System.out.println(">GetPoints");
        // TODO implement here
        System.out.println("<GetPoints");
        return 0;
    }

    /**
     * @param n
     */
    public void SetPoints(int n) {
        System.out.println(">SetPoints");
        // TODO implement here
        System.out.println("<SetPoints");
    }

}