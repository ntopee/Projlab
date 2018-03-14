package Game;
import java.util.*;

/**
 * 
 */
public class Hole extends Thing {

    /**
     * Default constructor
     */
    public Hole() {
    }

    /**
     * 
     */
    private boolean active;

    /**
     * @param p 
     * @param d
     */
    public void HitBy(Player p, Direction d) {
        System.out.println("> Hole HitBy Player");
        // TODO implement here
        System.out.println("< Hole HitBy Player");
    }

    /**
     * @param b 
     * @param d
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> Hole HitBy Box");
        // TODO implement here
        System.out.println("< Hole HitBy Box");
    }

    /**
     * 
     */
    public void SetActive() {
        System.out.println("> SetActive");
        // TODO implement here
        System.out.println("< SetActive");
    }

    /**
     * @return
     */
    public boolean GetActive() {
        System.out.println("> GetActive");
        // TODO implement here
        System.out.println("< GetActive");
        return false;
    }

}