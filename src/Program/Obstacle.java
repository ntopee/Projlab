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

    @Override
    public String toString() {
        return "Obstacle ";
    }

    /**
     * Egy akadály ütközik egy dobozzal. Meghívja a Box HitBy függvényét
     * az ellenkező irányba.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d, double Force) {
        b.HitBy(this,Game.GetOpposite(d), Player.maximumPlayerStrength);
    }

    /**
     * Egy akadály ütközik egy játékossal. Meghívja a Player move
     * függvényét az ellenkező irányba.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Player p, Direction d, double Force) {
        p.Move(Game.GetOpposite(d));
    }

    public void PlayerPushedIntoIt(Player p) {
        p.Die();
    }
}