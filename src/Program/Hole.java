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
    Image imageh = new Image(getClass().getResourceAsStream("FxSources/hole.png"));
    Image imageho = new Image(getClass().getResourceAsStream("FxSources/holeon.png"));
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

                    if (!i.equals(this)){

                        if (i instanceof Box){
                            if (!i.getMovable())
                                tile.GetMap().SetNumOfMBoxes(tile.GetMap().GetNumOfMBoxes()+1);
                        }

                        i.Die();
                    }

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
        if (active) {

            canvas.getGraphicsContext2D().drawImage(imageh, x, y, Game.TILE_SIZE, Game.TILE_SIZE);
        }
        else{

            canvas.getGraphicsContext2D().drawImage(imageho, x, y, Game.TILE_SIZE, Game.TILE_SIZE);
        }
    }


    private void LocalNeighbourTeller(ArrayList<Thing> AL){
        //ArrayList<Thing> AL = new ArrayList<Thing>();

/*
        tile.AddThingsFromDirectionToList(Direction.down,AL);
        tile.AddThingsFromDirectionToList(Direction.up,AL);
        tile.AddThingsFromDirectionToList(Direction.left,AL);
        tile.AddThingsFromDirectionToList(Direction.right,AL);*/

        //LocalNeighbourTeller(AL);

       /* for (int i = 0; i<AL.size(); i++)
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
            }*/

        /*for (Thing t :
                AL) {
            if (t instanceof Box) {
                boolean b = ((Box) t).CheckMovable();
                if (t.getMovable() != b){
                    t.setMovable(b);
                    if (b){
                        tile.GetMap().SetNumOfMBoxes(tile.GetMap().GetNumOfMBoxes()+1);
                    }

                    ArrayList<Thing> al = new ArrayList<>();
                    tile.AddThingsFromDirectionToList(Direction.down,al);
                    tile.AddThingsFromDirectionToList(Direction.up,al);
                    tile.AddThingsFromDirectionToList(Direction.left,al);
                    tile.AddThingsFromDirectionToList(Direction.right,al);

                    LocalNeighbourTeller(al);
                }
            }
        }*/

        for (Thing t :
                AL) {
            if (t instanceof Box){
                if (!t.getMovable()){
                    t.setMovable(true);
                    tile.GetMap().SetNumOfMBoxes(tile.GetMap().GetNumOfMBoxes()+1);

                    ArrayList<Thing> al = new ArrayList<>();
                    t.tile.AddThingsFromDirectionToList(Direction.down,al);
                    t.tile.AddThingsFromDirectionToList(Direction.up,al);
                    t.tile.AddThingsFromDirectionToList(Direction.left,al);
                    t.tile.AddThingsFromDirectionToList(Direction.right,al);
                    LocalNeighbourTeller(al);
                }
            }
        }

        for (Thing t :
                AL) {
            if (t instanceof Box){
                t.setMovable(((Box) t).CheckMovable());
            }
        }
    }


    private void NeighbourTeller(){
        ArrayList<Thing> AL = new ArrayList<Thing>();

        tile.AddThingsFromDirectionToList(Direction.down,AL);
        tile.AddThingsFromDirectionToList(Direction.up,AL);
        tile.AddThingsFromDirectionToList(Direction.left,AL);
        tile.AddThingsFromDirectionToList(Direction.right,AL);

        LocalNeighbourTeller(AL);
        System.out.println(tile.GetMap().GetNumOfMBoxes());
        System.out.println(tile.GetMap().GetGoalCounter());
    }
}