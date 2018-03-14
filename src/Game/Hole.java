package Game;
import java.util.*;

/**
 * 
 */
public class Hole extends Thing {

    /**
     * Default constructor
     */
    public Hole() {
    }

    /**
     * Azt tárolja, hogy a lyuk aktív-e (lyukként viselkedik-e).
     */
    private boolean active;

    /**
     *Player-el ütközik lyukként.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Player p, Direction d) {
        System.out.println("> Hole HitBy Player");
        // TODO implement here
        System.out.println("< Hole HitBy Player");
    }

    /**
     * Box-al ütközik lyukként.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> Hole HitBy Box");
        // TODO implement here
        System.out.println("< Hole HitBy Box");
    }

    /**
     * Az active attribútumot az aktuális értékének az ellentetjére állítja.
     */
    public void SetActive() {
        System.out.println("> SetActive");
        // TODO implement here
        System.out.println("< SetActive");
    }

    /**
     * Visszaadja az active attribútum aktuális értékét.
     * @return
     */
    public boolean GetActive() {
        System.out.println("> GetActive");
        // TODO implement here
        System.out.println("< GetActive");
        return false;
    }

}