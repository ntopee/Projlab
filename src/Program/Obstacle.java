package Program;

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
    public void HitBy(Box b, Direction d) {  //A két hitBy felülíródik a pillrba és az wall-ba tehát vagy ide vagy oda nem kellenekkifejtve.
        System.out.println("> Obstacle HitBy Box"); //A felulirodik jelen esetben annyit jelent hogy meghivja az osenek a hitby-ait, erre alapbol semmi szukseg nem lenne, de most a tesztesetek futatasa kedveert irtam igy.

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

    public void PlayerPushedIntoIt(Player p) {
        System.out.println("> PlayerPushedIntoIt");
        p.Die();
        System.out.println("> PlayerPushedIntoIt");
    }
}