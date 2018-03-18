package Program;
import java.util.*;
import java.util.Map;

/**
 * A pálya mezőit reprezentálja.
 * Eltárolja a Thing-eket.
 */
public class Tile {
    /**
     * Cellát tartalmazó map referenciája.
     */
    private Program.Map map;

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
        System.out.println("> Add");
        things.add(t);
        System.out.println("< Add");
    }

    /**
     * Eltávolít egy adott dolgot a celláról.
     * @param t Eltávolítandó Thing referencia.
     */
    public void Remove(Thing t) {
        System.out.println("> Remove");
        things.remove(t);
        System.out.println("< Remove");
    }

    /**
     * Visszaadja a cellához tartozó,
     * a paraméterként kapott irányban lévő szomszédos cellát.
     * @param d Direction, ebben az irányban kérdezzük le a szomszédot.
     * @return
     */
    public Tile GetNeighbour(Direction d) {
        System.out.println("> GetNeighbour");

        System.out.println("< GetNeighbour");
        return neighbours.get(d);
    }

    /**
     * Beállítja egy adott cella szomszédját.
     * @param d Ebben az irányban lévő szomszédot változtatjuk.
     * @param t Ezt az értéket kapja meg a szomszéd.
     */
    public void SetNeighbour(Direction d, Tile t) {
        System.out.println("> SetNeighbour");
        neighbours.remove(d);
        neighbours.put(d, t);
        System.out.println("< SetNeighbour");
    }

    /**
     * Visszaadja a things kollekciót.
     * @return
     */
    public Set<Thing> GetThings(){
        return things;
    }

    public Program.Map GetMap(){
        return map;
    }
}