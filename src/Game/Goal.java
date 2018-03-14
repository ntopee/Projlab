package Game;
import java.util.*;

/**
 * 
 */
public class Goal extends Thing {

    /**
     * Default constructor
     */
    public Goal() {
    }

    /**
     * Ha egy doboz rámegy a mezőre, az alapján, hogy honnan jött,
     * annak a playernek ad pontot. A Box valid értékét átállítja false-ra,
     * hogy ne lehessen több pontot szerezni vele.
     * Az isOnGoal értékét is igazra állítja.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> Goal HitBy Box");
        // TODO implement here
        System.out.println("< Goal HitBy Box");
    }

}