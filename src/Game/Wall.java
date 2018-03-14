package Game;
import java.util.*;

/**
 * A raktár építőeleme, nem tudunk rajta átmenni, dobozt áttolni. Ezzel ki tudjuk jelölni egy pálya határvonalát, játékteret biztosítva a játékosoknak.
 */
public class Wall extends Obstacle {

    /**
     * Default constructor
     */
    public Wall() {
    }

    /**
     * Egy akadály ütközik egy dobozzal. Meghívja a Box HitBy függvényét az ellenkező irányba.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        System.out.println(">HitByBox");
        // TODO implement here
        System.out.println("<HitBy");
    }

    /**
     * Egy akadály ütközik egy játékossal. Meghívja a Player move függvényét az ellenkező irányba.
     * @param p Player referencia.
     * @param d Ütközés iránya.

     */
    public void HitBy(Player p, Direction d) {
        System.out.println(">HitByPlayer");
        // TODO implement here
        System.out.println("<HitByPlayer");
    }

}