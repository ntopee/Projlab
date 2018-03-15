package Program;

/**
 * Felelős azért, hogy a játékos ne tudjon rajta átmenni, a dobozt ne tudjuk áttolni. A saját Tile-án egyedüli objektumnak kell lennie.
 */
public class Pillar extends Obstacle {

    /**
     * Default constructor
     */
    public Pillar() {
        super();
    }

    /**
     * Egy akadály ütközik egy dobozzal.
     * Meghívja a Box HitBy függvényét az ellenkező irányba.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> Pillar HitBy Box");
        super.HitBy(b,d);
        System.out.println("< Pillar HitBy Box");
    }

    /**
     * Egy akadály ütközik egy játékossal.
     * Meghívja a Player move függvényét az ellenkező irányba.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Player p, Direction d) {
        System.out.println("> Pillar HitBy Player");
        super.HitBy(p,d);
        System.out.println("< Pillar HitBy Player");
    }

}