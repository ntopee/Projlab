package Program;

import static Program.Main.tabber;
import static Program.Main.tabolo;

/**
 * Olyan objektumok a pályán, amelyeken sem játékos, sem doboz nem tud átmenni.
 */
public abstract class Obstacle extends Thing {

    /**
     * Default constructor
     */
    public Obstacle() {
            movable = false;
    }

    /**
     * Egy akadály ütközik egy dobozzal. Meghívja a Box HitBy függvényét
     * az ellenkező irányba.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        tabber++;
        tabolo(tabber);
        System.out.println("> Obstacle HitBy Box");

        b.HitBy(this,Game.GetOpposite(d));

        tabolo(tabber);
        tabber--;

        System.out.println("< Obstacle HitBy Box");
    }

    /**
     * Egy akadály ütközik egy játékossal. Meghívja a Player move
     * függvényét az ellenkező irányba.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Player p, Direction d) {
        tabber++;
        tabolo(tabber);
        System.out.println("> Obstacle HitBy Player");

        p.Move(Game.GetOpposite(d));

        tabolo(tabber);
        tabber--;

        System.out.println("< Obstacle HitBy Player");
    }

    public void PlayerPushedIntoIt(Player p) {
        tabber++;
        tabolo(tabber);
        System.out.println("> PlayerPushedIntoIt");
        p.Die();

        tabolo(tabber);
        tabber--;

        System.out.println("> PlayerPushedIntoIt");
    }
}