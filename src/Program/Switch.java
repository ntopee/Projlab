package Program;
import java.util.*;

/**
 * Vannak olyan lyukak, amelyek padlónak látszanak, de egy gomb lenyomására aktiválódnak.
 * Az aktiválást olyan mezők végzik, amiken van kapcsoló (Switch).
 */
public class Switch extends Thing {

    /**
     * Default constructor
     */
    public Switch() {
    }

    /**
     * Azoknak a lyukaknak a referenciáját tárolja, amelyeket az adott gomb befolyásolja.
     */
    private Set<Hole> holes;

    /**
     * Amikor egy ládát tol egy játékos a gombra, akkor a gomb aktiválásának következményeit kezeli.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> HitBy Box");

        this.Activate();

        System.out.println("< HitBy Box");
    }

    /**
     * Meghívja az összes, a switch-hez tartozó Hole SetActive() függvényét.
     */
    public void Activate() {
        System.out.println("> Activate");
        for (Hole i : holes) {
            i.SetActive();
        }
        System.out.println("< Activate");
    }

}