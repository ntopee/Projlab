package Program;
import java.util.*;
import java.util.Map;

import static Program.Main.tabber;
import static Program.Main.tabolo;

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
    public Tile(Program.Map m) {map = m;
    }



    /**
     * A cellán elhelyezkedő dolgok kollekciója.
     */
    private ArrayList<Thing> things = new ArrayList<Thing>();

    /**
     * Egy cella szomszédai.
     */
    private Map<Direction, Tile> neighbours = new HashMap<Direction, Tile>();

    /**
     * Új dolgok hozzáadása a cellához,
     * és ütköztetése az ott lévő dolgokkal.
     * @param t Egy Thing referencia.
     */
    public void Add(Thing t) {
        tabber++;
        tabolo(tabber);
        System.out.println("> Add " + t.toString());
        things.add(t);
        t.tile=this;


        tabolo(tabber);
        tabber--;

        System.out.println("< Add" + t.toString());
    }

    /**
     * Eltávolít egy adott dolgot a celláról.
     * @param t Eltávolítandó Thing referencia.
     */
    public void Remove(Thing t) {
        tabber++;
        tabolo(tabber);
        System.out.println("> Remove " + t.toString());
        things.remove(t);


        tabolo(tabber);
        tabber--;

        System.out.println("< Remove " + t.toString());
    }

    /**
     * Visszaadja a cellához tartozó,
     * a paraméterként kapott irányban lévő szomszédos cellát.
     * @param d Direction, ebben az irányban kérdezzük le a szomszédot.
     * @return
     */
    public Tile GetNeighbour(Direction d) {
        tabber++;
        tabolo(tabber);
        System.out.println("> GetNeighbour");

        tabolo(tabber);
        tabber--;

        System.out.println("< GetNeighbour");
        return neighbours.get(d);
    }

    /**
     * Beállítja egy adott cella szomszédját.
     * @param d Ebben az irányban lévő szomszédot változtatjuk.
     * @param t Ezt az értéket kapja meg a szomszéd.
     */
    public void SetNeighbour(Direction d, Tile t) {

        tabber++;
        tabolo(tabber);
        System.out.println("> SetNeighbour");
        neighbours.remove(d);
        neighbours.put(d, t);


        tabolo(tabber);
        tabber--;

        System.out.println("< SetNeighbour");
    }

    /**
     * Visszaadja a things kollekciót.
     * @return
     */
    public ArrayList<Thing> GetThings(){
        return things;
    }

    public Program.Map GetMap(){
        return map;
    }
}