package Program;

/**
 * Ha egy másik objektum kerül arra a mezőre, amelyiken lyuk van, akkor leesik a lyukba, és meghívja rá a Remove metódust
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
        p.Die();

        tile.GetMap().CheckEndGame();

        System.out.println("< Hole HitBy Player");
    }

    /**
     * Box-al ütközik lyukként.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> Hole HitBy Box");

        b.Die();

        tile.GetMap().CheckEndGame();

        System.out.println("< Hole HitBy Box");
    }

    /**
     * Az active attribútumot az aktuális értékének az ellentetjére állítja.
     */
    public void SetActive() {
        System.out.println("> SetActive");

        active = !active;
        if (active)
            for (Thing i : tile.GetThings())
                if (!i.equals(this))
                    i.Die();

        System.out.println("< SetActive");
    }

    /**
     * Visszaadja az active attribútum aktuális értékét.
     * @return
     */
    public boolean GetActive() {
        System.out.println("> GetActive");

        System.out.println("< GetActive");
        return active;
    }

    public void PlayerPushedIntoIt(Player p) {
        System.out.println("> PlayerPushedIntoIt");
        if (active)
            p.Die();
        System.out.println("> PlayerPushedIntoIt");
    }
}