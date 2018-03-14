package Game;
import java.util.*;

/**
 * 
 */
public class Pillar extends Obstacle {

    /**
     * Default constructor
     */
    public Pillar() {
    }

    /**
     * @param b 
     * @param d
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> Pillar HitBy Box");
        // TODO implement here
        System.out.println("< Pillar HitBy Box");
    }

    /**
     * @param p 
     * @param d
     */
    public void HitBy(Player p, Direction d) {
        System.out.println("> Pillar HitBy Player");
        // TODO implement here
        System.out.println("< Pillar HitBy Player");
    }

}