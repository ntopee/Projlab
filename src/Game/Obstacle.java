package Game;
import java.util.*;

/**
 * 
 */
public class Obstacle extends Thing {

    /**
     * Default constructor
     */
    public Obstacle() {
    }

    /**
     * Egy akadály ütközik egy dobozzal. Meghívja a Box HitBy függvényét
     * az ellenkező irányba.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> Obstacle HitBy Box");
        // TODO implement here
        System.out.println("< Obstacle HitBy Box");
    }

    /**
     * Egy akadály ütközik egy játékossal. Meghívja a Player move
     * függvényét az ellenkező irányba.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Player p, Direction d) {
        System.out.println("> Obstacle HitBy Player");
        // TODO implement here
        System.out.println("< Obstacle HitBy Player");
    }

}