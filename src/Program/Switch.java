package Program;
import java.util.*;

import static Program.Main.tabber;
import static Program.Main.tabolo;

/**
 * Vannak olyan lyukak, amelyek padlónak látszanak, de egy gomb lenyomására aktiválódnak.
 * Az aktiválást olyan mezők végzik, amiken van kapcsoló (Switch).
 */
public class Switch extends Thing {

    /**
     * Default constructor
     */
    public Switch(Hole h) {
        holes.add(h);
        movable = true;
    }

    /**
     * Azoknak a lyukaknak a referenciáját tárolja, amelyeket az adott gomb befolyásolja.
     */
    private Set<Hole> holes = new HashSet<Hole>();

    /**
     * Amikor egy ládát tol egy játékos a gombra, akkor a gomb aktiválásának következményeit kezeli.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d, double Force) {
        tabber++;
        tabolo(tabber);
        System.out.println("> Switch HitBy Box");

        this.Activate();


        tabolo(tabber);
        tabber--;

        System.out.println("< Switch HitBy Box");
    }

    /**
     * Meghívja az összes, a switch-hez tartozó Hole SetActive() függvényét.
     */
    private void Activate() {
        tabber++;
        tabolo(tabber);
        System.out.println("> Activate");
        for (Hole i : holes) {
            i.SetActive();
        }


        tabolo(tabber);
        tabber--;

        System.out.println("< Activate");
    }

}