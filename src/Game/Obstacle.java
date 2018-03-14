package Game;
import java.util.*;

/**
 * Olyan objektumok a pályán, amelyeken sem játékos, sem doboz nem tud átmenni.
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
     * @param b 
     * @param d
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> Obstacle HitBy Box");
        // TODO implement here
        System.out.println("< Obstacle HitBy Box");
    }

    /**
     * Egy akadály ütközik egy játékossal. Meghívja a Player move
     * függvényét az ellenkező irányba.
     * @param p 
     * @param d
     */
    public void HitBy(Player p, Direction d) {
        System.out.println("> Obstacle HitBy Player");
        // TODO implement here
        System.out.println("< Obstacle HitBy Player");
    }

}