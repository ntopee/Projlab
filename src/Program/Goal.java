package Program;

import static Program.Main.tabber;
import static Program.Main.tabolo;

/**
 * Olyan mezőket képvisel, amelyekre a ládákat kell tolni a pontszerzéshez.
 */
public class Goal extends Thing {

    /**
     * Default constructor
     */
    public Goal() {
        movable = true;
    }

    /**
     * Ha egy doboz rámegy a mezőre, az alapján, hogy honnan jött,
     * annak a playernek ad pontot. A Box valid értékét átállítja false-ra,
     * hogy ne lehessen több pontot szerezni vele.
     * Az isOnGoal értékét is igazra állítja.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d, double Force) {
        tabber++;
        tabolo(tabber);
        System.out.println("> Goal HitBy Box");

        if(b.GetValid()) {
            b.SetValid();
            b.AddPoint(Game.GetOpposite(d));
        }
            b.SetisOnGoal();
           if(b.CheckMovable() == false)
               tile.GetMap().SetCounterWeight(
                   tile.GetMap().GetCounterWeight()+1);
            tile.GetMap().CheckEndGame();


        tabolo(tabber);
        tabber--;

        System.out.println("< Goal HitBy Box");
    }

}