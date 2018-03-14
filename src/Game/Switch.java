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
     *Azoknak a lyukaknak a referenciáját tárolja, amelyeket az adott gomb befolyásolja.
     */
    private Set<Hole> holes;

    /**
     * Amikor egy ládát tol egy játékos a gombra, akkor a gomb aktiválásának következményeit kezeli.
     * @param b 
     * @param d
     */
    public void HitBy(Box b, Direction d) {
        System.out.println(">HitByBox");
        // TODO implement here
        System.out.println("<HitByBox");
    }

    /**
     * Meghívja az összes, a switch-hez tartozó Hole SetActive() függvényét.
     */
    public void Activate() {
        System.out.println(">Activate");
        // TODO implement here
        System.out.println("<Activate");
    }

}