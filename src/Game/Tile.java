package Game;
import java.util.*;
import java.util.Map;

/**
 * A pálya mezőit reprezentálja.
 * Eltárolja a Thing-eket.
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

    /**
     * Egy cella szomszédai.
     */
    private Map<Direction, Tile> neighbours;

    /**
     * Új dolgok hozzáadása a cellához,
     * és ütköztetése az ott lévő dolgokkal.
     * @param t Egy Thing referencia.
     */
    public void Add(Thing t) {
        System.out.println(">Add");
        // TODO implement here
        System.out.println("<Add");
    }

    /**
     * Eltávolít egy adott dolgot a celláról.
     * @param t Eltávolítandó Thing referencia.
     */
    public void Remove(Thing t) {
        System.out.println(">Remove");
        // TODO implement here
        System.out.println("<Remove");
    }

    /**
     * Visszaadja a cellához tartozó,
     * a paraméterként kapott irányban lévő szomszédos cellát.
     * @param d Direction, ebben az irányban kérdezzük le a szomszédot.
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
     * @param d Ebben az irányban lévő szomszédot változtatjuk.
     * @param t Ezt az értéket kapja meg a szomszéd.
     */
    public void SetNeighbour(Direction d, Tile t) {
        System.out.println(">SetNeighbour");
        // TODO implement here
        System.out.println("<SetNeighbour");
    }

}