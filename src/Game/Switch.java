package Game;
import java.util.*;

/**
 * 
 */
public class Switch extends Thing {

    /**
     * Default constructor
     */
    public Switch() {
    }

    /**
     *
     */
    private Set<Hole> holes;

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
    public void Activate() {
        System.out.println(">Activate");
        // TODO implement here
        System.out.println("<Activate");
    }

}