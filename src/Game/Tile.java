package Game;
import java.util.*;
import java.util.Map;

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
     * A cellán elhelyezkedő dolgok kollekciója.
     */
    private Set<Thing> things;
    private Map<Direction, Tile> neighbours;

    /**
     * Új dolgok hozzáadása a cellához,
     * és ütköztetése az ott lévő dolgokkal.
     * @param t
     */
    public void Add(Thing t) {
        System.out.println(">Add");
        // TODO implement here
        System.out.println("<Add");
    }

    /**
     * Eltávolít egy adott dolgot a celláról.
     * @param t
     */
    public void Remove(Thing t) {
        System.out.println(">Remove");
        // TODO implement here
        System.out.println("<Remove");
    }

    /**
     * Visszaadja a cellához tartozó,
     * a paraméterként kapott irányban lévő szomszédos cellát.
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
     * Beállítja egy adott cella szomszédját.
     * @param d 
     * @param t
     */
    public void SetNeighbour(Direction d, Tile t) {
        System.out.println(">SetNeighbour");
        // TODO implement here
        System.out.println("<SetNeighbour");
    }

}