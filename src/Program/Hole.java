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
     * Az active attribútumot az aktuális értékének az ellentetjére állítja.
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
           // NeighbourTeller();
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

    public void NeighbourTeller(){

        ArrayList<Thing> D = new ArrayList<Thing>();
        ArrayList<Thing> U = new ArrayList<Thing>();;
        ArrayList<Thing> L = new ArrayList<Thing>();;
        ArrayList<Thing> R = new ArrayList<Thing>();;

        try{
            D.addAll(tile.GetNeighbour(Direction.down).GetThings());
        }
        catch (NullPointerException except){
            System.out.println("No southern neighbour found");
        }

        try{
            U.addAll(tile.GetNeighbour(Direction.up).GetThings()) ;
        }
        catch (NullPointerException except){
            System.out.println("No Northern neighbour found");
        }

        try{
            L.addAll(tile.GetNeighbour(Direction.left).GetThings());
        }
        catch (NullPointerException except){
            System.out.println("No Western neighbour found");
        }

        try{
            R.addAll(tile.GetNeighbour(Direction.right).GetThings());
        }
        catch (NullPointerException except){
            System.out.println("No Eastern neighbour found");
        }


        for (int i = 0; i<D.size(); i++)
            if(D.get(i) instanceof Box) {


                if ((D.get(i).getMovable() == false) &&
                        (((Box) D.get(i)).GetisOnGoal() == true)) {
                    D.get(i).setMovable(((Box) D.get(i)).CheckMovable());
                    if (D.get(i).getMovable() == true) {
                        tile.GetMap().SetCounterWeight(
                                tile.GetMap().GetCounterWeight() - 1);
                        tile.GetMap().SetNumOfMBoxes(tile.GetMap().GetNumOfMBoxes() + 1);
                    }
                }
                else
                D.get(i).setMovable(((Box) D.get(i)).CheckMovable());
            }

        for (int i = 0; i<U.size(); i++)
            if(U.get(i) instanceof Box) {


                if ((U.get(i).getMovable() == false) &&
                        (((Box) U.get(i)).GetisOnGoal() == true)) {
                    U.get(i).setMovable(((Box) U.get(i)).CheckMovable());
                    if (U.get(i).getMovable() == true) {
                        tile.GetMap().SetCounterWeight(
                                tile.GetMap().GetCounterWeight() - 1);
                        tile.GetMap().SetNumOfMBoxes(tile.GetMap().GetNumOfMBoxes() + 1);
                    }
                }
                else
                U.get(i).setMovable(((Box) U.get(i)).CheckMovable());
            }

        for (int i = 0; i<L.size(); i++)
            if(L.get(i)instanceof Box) {


                if ((L.get(i).getMovable() == false) &&
                        (((Box) L.get(i)).GetisOnGoal() == true)) {
                    L.get(i).setMovable(((Box) L.get(i)).CheckMovable());
                    if (L.get(i).getMovable() == true) {
                        tile.GetMap().SetCounterWeight(
                                tile.GetMap().GetCounterWeight() - 1);
                        tile.GetMap().SetNumOfMBoxes(tile.GetMap().GetNumOfMBoxes() + 1);
                    }
                }
                else
                    L.get(i).setMovable(((Box) L.get(i)).CheckMovable());
            }

        for (int i = 0; i<R.size(); i++)
            if(R.get(i) instanceof Box) {


                if ((R.get(i).getMovable() == false) &&
                        (((Box) R.get(i)).GetisOnGoal() == true)) {
                    R.get(i).setMovable(((Box) R.get(i)).CheckMovable());
                    if (R.get(i).getMovable() == true) {
                        tile.GetMap().SetCounterWeight(
                                tile.GetMap().GetCounterWeight() - 1);
                        tile.GetMap().SetNumOfMBoxes(tile.GetMap().GetNumOfMBoxes() + 1);
                    }
                }
                else
                R.get(i).setMovable(((Box) R.get(i)).CheckMovable());
            }

    }
}