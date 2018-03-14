package Game;
import java.util.*;

/**
 * 
 */
public class Obstacle extends Thing {

    /**
     * Default constructor
     */
    public Obstacle() {
    }

    /**
     * @param b 
     * @param d
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> Obstacle HitBy Box");
        // TODO implement here
        System.out.println("< Obstacle HitBy Box");
    }

    /**
     * @param p 
     * @param d
     */
    public void HitBy(Player p, Direction d) {
        System.out.println("> Obstacle HitBy Player");
        // TODO implement here
        System.out.println("< Obstacle HitBy Player");
    }

}