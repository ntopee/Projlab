package Game;
import java.util.*;

/**
 * 
 */
public class Tile {

    /**
     * Default constructor
     */
    public Tile() {
    }

    /**
     *
     */
    private Set<Thing> things;







    /**
     * @param t
     */
    public void Add(Thing t) {
        System.out.println(">Add");
        // TODO implement here
        System.out.println("<Add");
    }

    /**
     * @param t
     */
    public void Remove(Thing t) {
        System.out.println(">Remove");
        // TODO implement here
        System.out.println("<Remove");
    }

    /**
     * @param d 
     * @return
     */
    public Tile GetNeighbour(Direction d) {
        System.out.println(">GetNeighbour");
        // TODO implement here
        System.out.println("<GetNeighbour");
        return null;
    }

    /**
     * @param d 
     * @param t
     */
    public void SetNeighbour(Direction d, Tile t) {
        System.out.println(">SetNeighbour");
        // TODO implement here
        System.out.println("<SetNeighbour");
    }

}