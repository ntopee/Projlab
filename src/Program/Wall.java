package Program;

import static Program.Main.tabber;
import static Program.Main.tabolo;

/**
 * A raktár építőeleme, nem tudunk rajta átmenni, dobozt áttolni. Ezzel ki tudjuk jelölni egy pálya határvonalát, játékteret biztosítva a játékosoknak.
 */
public class Wall extends Obstacle {

    /**
     * Default constructor
     */
    public Wall() {
        super();
    }

    /**
     * Egy akadály ütközik egy dobozzal. Meghívja a Box HitBy függvényét az ellenkező irányba.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d, double Force) {
        tabber++;
        tabolo(tabber);
        System.out.println("> HitBy Box");
        super.HitBy(b,d, Force);


        tabolo(tabber);
        tabber--;

        System.out.println("< HitBy Box");
    }

    /**
     * Egy akadály ütközik egy játékossal. Meghívja a Player move függvényét az ellenkező irányba.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Player p, Direction d, double Force) {
        tabber++;
        tabolo(tabber);
        System.out.println("> HitBy Player");
        super.HitBy(p,d, Force);


        tabolo(tabber);
        tabber--;

        System.out.println("< HitBy Player");
    }

}