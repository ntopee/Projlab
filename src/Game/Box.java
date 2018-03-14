package Game;

/**
 *A játékban található ládákat reprezentálja.
 */
public class Box extends Thing {

    /**
     * Default constructor
     */
    public Box() {
    }

    /**
     * Megadja, hogy az adott ládával lehet-e még pontot szerezni.
     */
    private boolean valid;

    /**
     * Megadja, hogy az adott láda Goal-on van-e.
     */
    private boolean isOnGoal;

    /**
     * Box-ként ütközik Box-al.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> Box HitBy Box");
        // TODO implement here
        System.out.println("< Box HitBy Box");
    }

    /**
     * Box-ként ütközik egy Player-el.
     * @param p Player referencia
     * @param d Az ütközés iránya
     */
    public void HitBy(Player p, Direction d) {
        System.out.println("> Box HitBy Player");
        // TODO implement here
        System.out.println("< Box HitBy Player");
    }

    /**
     * Akkor hívódik meg, ha a láda leesik egy lyukon. A láda eltűnik a pályáról.
     */
    public void Die() {
        System.out.println("> Die");
        // TODO implement here
        System.out.println("< Die");
    }

    /**
     * A függvénynek megadott irányba mozgatja a ládát egy mezővel(ha lehet).
     * @param o Obstacle referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Obstacle o, Direction d) {
        System.out.println("> Box HitBy Obstacle");
        // TODO implement here
        System.out.println("< Box HitBy Obstacle");
        // TODO implement here
    }

    /**
     * Ha meghívódik ez a függvény, akkor megnézi,
     * hogy még mozgatható-e a láda valamilyen irányba.
     * Ha változik az érték, akkor annak megfelelően növeli/csökkenti a num_ofmovable_boxes-t.
     * @return
     */
    public boolean CheckMovable() {
        System.out.println("> CheckMovable");
        // TODO implement here
        System.out.println("< CheckMovable");
        return false;
    }

    /**
     * @return
     */
    public boolean GetisOnGoal() {
        System.out.println("> GetisOnGoal");
        // TODO implement here
        System.out.println("< GetisOnGoal");
        return false;
    }

    /**
     * Beállitja az isOnGoal értékét.
     */
    public void SetisOnGoal() {
        System.out.println("> SetisOnGoal");
        // TODO implement here
        System.out.println("< SetisOnGoal");
    }

    /**
     * Átállítja a valid attribútumot a mostani érték ellenkezőjére.
     */
    public void SetValid() {
        System.out.println("> SetValid");
        // TODO implement here
        System.out.println("< SetValid");
    }

    /**
     * Visszaadja a valid attribútum értékét.
     * @return
     */
    public boolean GetValid() {
        System.out.println("> GetValid");
        // TODO implement here
        System.out.print("< GetValid");
        return false;
    }

    /**
     * Elintézi a pontszámítást.
     * @param d
     */
    public void AddPoint(Direction d) {
        System.out.println("> AddPoint");
        // TODO implement here
        System.out.println("< AddPoint");
    }

}