package Program;

import java.util.ArrayList;

import static Program.Main.tabber;
import static Program.Main.tabolo;

/**
 * Ha egy másik objektum kerül arra a mezőre, amelyiken lyuk van, akkor leesik a lyukba, és meghívja rá a Remove metódust
 */
public class Hole extends Thing {

    /**
     * Default constructor
     */
    public Hole(boolean a) {
        active = a;
        movable = true;
    }

    @Override
    public String toString() {
        return (active)?"Hole ":"hole ";
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
    public void HitBy(Player p, Direction d, double Force) {
        tabber++;
        tabolo(tabber);//Ez nem kb ugyan az mint a player PushedintoIt? valahogy a két függvényt kéne mergelni valamilyen néven #bende
        System.out.println("> Hole HitBy Player");          //Full maskor hivodik meg, mivel nem tudunk instanceof-ot hasznalni, ezert nem tudjuk hogy minek hivjuk a fuggvenyeit.
        if (active)
            p.Die();

        tile.GetMap().CheckEndGame();
        tabolo(tabber);
        tabber--;

        System.out.println("< Hole HitBy Player");
    }

    /**
     * Box-al ütközik lyukként.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d, double Force) {
        tabber++;
        tabolo(tabber);
        System.out.println("> Hole HitBy Box");
        if (active){
            b.Die();

        }


        tile.GetMap().CheckEndGame();

        tabolo(tabber);
        tabber--;

        System.out.println("< Hole HitBy Box");
    }

    /**
     * Az active attribútumot az aktuális értékének az ellentettjére állítja.
     */
    public void SetActive() {
        tabber++;
        tabolo(tabber);
        System.out.println("> SetActive");

        active = !active;
        if (active) {
            for (Thing i : tile.GetThings())
                if (!i.equals(this))
                    i.Die();
            NeighbourTeller();
        }

        tabolo(tabber);
        tabber--;

        System.out.println("< SetActive");
    }

    /**
     * Visszaadja az active attribútum aktuális értékét.
     * @return
     */
    public boolean GetActive() {
        tabber++;
        tabolo(tabber);
        System.out.println("> GetActive");

        tabolo(tabber);
        tabber--;

        System.out.println("< GetActive");
        return active;
    }

    public void PlayerPushedIntoIt(Player p) {
        tabber++;
        tabolo(tabber);
        System.out.println("> PlayerPushedIntoIt");
        if (active)
            p.Die();

        tile.GetMap().CheckEndGame();

        tabolo(tabber);
        tabber--;

        System.out.println("> PlayerPushedIntoIt");
    }


    private void LocalNeighbourTeller(ArrayList<Thing> AL){

        for (int i = 0; i<AL.size(); i++)
            if(AL.get(i) instanceof Box) {


                if ((!AL.get(i).getMovable()) &&
                        (((Box) AL.get(i)).GetisOnGoal())) {
                    AL.get(i).setMovable(((Box) AL.get(i)).CheckMovable());
                    if (AL.get(i).getMovable()) {
                        tile.GetMap().SetCounterWeight(
                                tile.GetMap().GetCounterWeight() - 1);
                        tile.GetMap().SetNumOfMBoxes(tile.GetMap().GetNumOfMBoxes() + 1);
                    }
                }
                else
                    AL.get(i).setMovable(((Box) AL.get(i)).CheckMovable());
            }

    }


    private void NeighbourTeller(){

        ArrayList<Thing> AL = new ArrayList<Thing>();


        tile.AddThingsFromDirectionToList(Direction.down,AL);
        tile.AddThingsFromDirectionToList(Direction.up,AL);
        tile.AddThingsFromDirectionToList(Direction.left,AL);
        tile.AddThingsFromDirectionToList(Direction.right,AL);

        LocalNeighbourTeller(AL);

    }
}