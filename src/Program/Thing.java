package Program;

import javafx.scene.canvas.Canvas;

import static Program.Main.tabber;
import static Program.Main.tabolo;

/**
 *A Thing objektumok azok az objektumok, amelyek “rajta vannak” egy Tile-on.
 */
public abstract class Thing { //Itt szerintem minden függvény kifejtése (systemout) felesleges mivel nem lesz példányosítva thing osztály tehát sosem hívódnak meg
                                // nincs is kifejtve, alap generalo irta meg igy.
    @Override
    public String toString() {
        return "Thing";
    }

    /**
     * Default constructor
     */
    public Thing() { }

    public boolean getMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    /**
     * Megadja, hogy lehet-e még mozgatni az adott dolgot.
     */
    boolean movable;

    /**
     * Azon Tile referenciája, amin a Thing található.
     */
    protected Tile tile;

    /**
     * A művelet, amit akkor kell végrehajtani,
     * ha a dolognak egy játékos ütközött.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     * @param Force Az utkozes ereje
     */
    public void HitBy(Player p, Direction d, double Force) {
        tabber++;
        tabolo(tabber);

        System.out.println("> HitBy Player");
        // TODO implement here

        tabolo(tabber);
        tabber--;
        System.out.println("< HitBy Player");
    }

    /**
     * A művelet, amit akkor kell végrehajtani,
     * ha a dolognak egy láda ütközött.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     * @param Force Az utkozes ereje.
     */
    public void HitBy(Box b, Direction d, double Force) {
        tabber++;
        tabolo(tabber);
        System.out.println("> HitBy Box");
        // TODO implement here

        tabolo(tabber);
        tabber--;
        System.out.println("< HitBy Box");
    }

    /**
     * Egy cellán elhelyezkedő dolog megsemmisítése.
     */
    public void Die() {
        System.out.println("> Die");
        // TODO implement here
        System.out.println("< Die");
    }

    /**
     * Elintézi a pontszámítást.
     * @param d Magadja hogy melyik irányban van a pontszerző játékos.
     */
    public void AddPoint(Direction d) {
        System.out.println("> AddPoint");
        // TODO implement here
        System.out.println("< AddPoint");
    }

    /**
     * Azokat az eseteket kezeli le amikor egy játékos neki lökődik valaminek.
     * @param p Player referencia.
     */
    public void PlayerPushedIntoIt(Player p) {
        System.out.println("> PlayerPushedIntoIt");
        // TODO implement here
        System.out.println("> PlayerPushedIntoIt");
    }


    public abstract void draw(int x, int y, Canvas canvas);
}