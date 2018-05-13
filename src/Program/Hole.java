package Program;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * Ha egy másik objektum kerül arra a mezőre, amelyiken lyuk van, akkor leesik a lyukba, és meghívja rá a Remove metódust
 */
public class Hole extends Thing {

    /**
     * Default constructor
     */
     Hole(boolean a) {
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

        //Ez nem kb ugyan az mint a player PushedintoIt? valahogy a két függvényt kéne mergelni valamilyen néven #bende
        //Full maskor hivodik meg, mivel nem tudunk instanceof-ot hasznalni, ezert nem tudjuk hogy minek hivjuk a fuggvenyeit.
        if (active)
            p.Die();

        tile.GetMap().CheckEndGame();
    }

    /**
     * Box-al ütközik lyukként.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d, double Force) {

        if (active){
            b.Die();
        }

        tile.GetMap().CheckEndGame();

    }

    /**
     * Az active attribútumot az aktuális értékének az ellentettjére állítja.
     */
    public void SetActive() {

        active = !active;
        if (active) {
            try {
                for (Thing i : tile.GetThings())
                    if (!i.equals(this))
                        i.Die();
            }catch (ConcurrentModificationException e){}
            NeighbourTeller();
        }

    }

    /**
     * Visszaadja az active attribútum aktuális értékét.
     * @return active attribútum aktuális értéke.
     */
    public boolean GetActive() {
        return active;
    }

    public void PlayerPushedIntoIt(Player p) {
        if (active)
            p.Die();

        tile.GetMap().CheckEndGame();

    }

    @Override
    public void draw(int x, int y, Canvas canvas) {
        Image image = new Image(getClass().getResourceAsStream("FxSources/hole.png"));
        canvas.getGraphicsContext2D().drawImage(image, x, y, Game.TILE_SIZE, Game.TILE_SIZE);
    }


    private void LocalNeighbourTeller(ArrayList<Thing> AL){
        //ArrayList<Thing> AL = new ArrayList<Thing>();


        tile.AddThingsFromDirectionToList(Direction.down,AL);
        tile.AddThingsFromDirectionToList(Direction.up,AL);
        tile.AddThingsFromDirectionToList(Direction.left,AL);
        tile.AddThingsFromDirectionToList(Direction.right,AL);

        //LocalNeighbourTeller(AL);

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