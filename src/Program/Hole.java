package Program;

import javafx.scene.canvas.Canvas;

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

    public void PlayerPushedIntoIt(Player p) {
        if (active)
            p.Die();

        tile.GetMap().CheckEndGame();

    }
    /**
     * Kirazolja a holet.
     * @param x X koordinata
     * @param y Y koordinata
     * @param canvas Ide rajzolja ki
     */
    @Override
    public void draw(int x, int y, Canvas canvas) {
        if (active) {

            canvas.getGraphicsContext2D().drawImage(Images.HoleImage, x, y, Game.TILE_SIZE, Game.TILE_SIZE);
        }
        else{

            canvas.getGraphicsContext2D().drawImage(Images.HoleimageO, x, y, Game.TILE_SIZE, Game.TILE_SIZE);
        }
    }

    /**
     * Rekurziv fuggveny hivas.
     * A NeighbourTeller-t egesziti ki.
     * Lenyegeben csak vegig megy a lyuk kornyezeteben talalhato szomszedos dobozokon,
     * es meghivja a CheckMobale-t.
     * @param AL Egy Tile szomszedait tarolja.
     */
    private void LocalNeighbourTeller(ArrayList<Thing> AL){
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

    /**
     * Amikor egy lyukat bekapcsolunk,
     * akkor ez a fuggveny szol a szomszedos dobozoknak, hogy nezzek meg a mozgathatosagukat.
     */
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