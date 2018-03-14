package Program;

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
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> Obstacle HitBy Box");

        b.HitBy(this,Game.GetOpposite(d));

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

        p.Move(Game.GetOpposite(d));

        System.out.println("< Obstacle HitBy Player");
    }

}