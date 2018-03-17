package Program;

/**
 *A Thing objektumok azok az objektumok, amelyek “rajta vannak” egy Tile-on.
 */
public abstract class Thing { //Itt szerintem minden függvény kifejtése (systemout) felesleges mivel nem lesz példányosítva thing osztály tehát sosem hívódnak meg

    /**
     * Default constructor
     */
    public Thing() {
    }

    /**
     * Megadja, hogy lehet-e még mozgatni az adott dolgot.
     */
    protected boolean movable;

    /**
     * Azon Tile referenciája, amin a Thing található.
     */
    protected Tile tile;

    /**
     *  A dolog ütközik egy másik dologgal.
     * @param t Thing referencia.
     */
    /*public void CollideWith(Thing t, Direction d) {
        System.out.println(">CollideWith");
        // TODO implement here
        System.out.println("<CollideWith");
    }*/

    /**
     * A művelet, amit akkor kell végrehajtani,
     * ha a dolognak egy játékos ütközött.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Player p, Direction d) {
        System.out.println("> HitBy Player");
        // TODO implement here
        System.out.println("< HitBy Player");
    }

    /**
     * A művelet, amit akkor kell végrehajtani,
     * ha a dolognak egy láda ütközött.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> HitBy Box");
        // TODO implement here
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

}