package Program;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 *A játékban található ládákat reprezentálja.
 */
public class Box extends Thing {

    @Override
    public String toString() {
        return "Box ";
    }

    Image image = new Image(getClass().getResourceAsStream("FxSources/box.png"));
    /**
     * az atlagos lada tomege
     */
    private final int avarageBoxWeight = 13;

    /**
     * minimum tomege a ladanak
     */
    private final int minimumBoxWeight = 0;

    /**
     * maximum tomege a ladanak
     */

    private final int maximumBoxWeight = 25;

    /**
     * Default constructor
     */
    public Box() {
        movable = true;
        this.weight = avarageBoxWeight;
    }


    /**
     * Parameteres konstruktor
     * @param Weight a lada sulya
     */
    public Box(int Weight){
        movable = true;

        if(!(Weight<minimumBoxWeight || Weight>maximumBoxWeight)){
            this.weight = Weight;
        }
        else {
            this.weight = avarageBoxWeight;
            System.err.println("The value is inappropriate, the box's weight is set to 13");
        }
    }


    /**
     * Megadja, hogy az adott ládával lehet-e még pontot szerezni.
     */
    private boolean valid = true;

    /**
     * Megadja, hogy az adott láda Goal-on van-e.
     */
    private boolean isOnGoal = false;


    /**
     * Megadja, hogy milyen nehez a lada
     */
    private int weight;


    /**
     * Box-ként ütközik Box-al.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     * @param Force Az utkozes ereje
     */


    public void HitBy(Box b, Direction d, double Force) {

        double tmp = Force-weight*tile.GetOil()*tile.GetHoney();
        if (!this.movable || (tmp<=0))
            b.HitBy(this,Game.GetOpposite(d), Player.maximumPlayerStrength);
        else {
            Step(d, tmp);

                movable = CheckMovable();
                if(!movable) {
                    tile.GetMap().DecreaseNumOfBoxes();
                    NeighbourMovableChecker();

                 }

            }

    }

    /**
     * Box-ként ütközik egy Player-el.
     * @param p Player referencia
     * @param d Az ütközés iránya
     * @param Force Az utkozes ereje
     */
    public void HitBy(Player p, Direction d, double Force) {

        double tmp = Force-weight*tile.GetOil()*tile.GetHoney();
        if (!this.movable || tmp <= 0){
            p.Move(Game.GetOpposite(d));
        }
        else{
            for (Thing t :
                    tile.GetThings()) {
                if (t instanceof Switch)
                    ((Switch) t).Activate();
            }
            Step(d,tmp);

            movable = CheckMovable();

            if(!movable) {
                    tile.GetMap().DecreaseNumOfBoxes();
                    NeighbourMovableChecker();
            }


            }

    }

    /**
     * Akkor hívódik meg, ha a láda leesik egy lyukon. A láda eltűnik a pályáról.
     */
    public void Die() {

        tile.Remove(this);
        this.valid = false;
        this.isOnGoal = false;
        this.movable = false;
        tile.GetMap().DecreaseNumOfBoxes();

    }

    /**
     * A függvénynek megadott irányba mozgatja a ládát egy mezővel(ha lehet).
     * @param o Obstacle referencia.
     * @param d Ütközés iránya.
     * @param Force Az utkozes ereje
     */
    public void HitBy(Obstacle o, Direction d, double Force) {

        Step(d, Force);

    }

    /**
     * Ha meghívódik ez a függvény, akkor megnézi,
     * hogy még mozgatható-e a láda valamilyen irányba.
     * Ha változik az érték, akkor annak megfelelően növeli/csökkenti a num_ofmovable_boxes-t.
     * @return
     */
    public boolean CheckMovable() {

        ArrayList<Thing> D = new ArrayList<Thing>();
        ArrayList<Thing> U = new ArrayList<Thing>();
        ArrayList<Thing> L = new ArrayList<Thing>();
        ArrayList<Thing> R = new ArrayList<Thing>();
        
        tile.AddThingsFromDirectionToList(Direction.down,D);
        tile.AddThingsFromDirectionToList(Direction.up,U);
        tile.AddThingsFromDirectionToList(Direction.left,L);
        tile.AddThingsFromDirectionToList(Direction.right,R);
        

        boolean down = true;
        boolean up = true;
        boolean left = true;
        boolean right = true;

        for (int i = 0; i<D.size(); i++)
            if(!D.get(i).getMovable()) down = false;

        for (int i = 0; i<U.size(); i++)
            if(!U.get(i).getMovable()) up = false;

        for (int i = 0; i<L.size(); i++)
            if(!L.get(i).getMovable()) left = false;

        for (int i = 0; i<R.size(); i++)
            if(!R.get(i).getMovable()) right = false;

        /*
        felulnezet:
        b = Box, O = Obstacle, x = mindegy
          |  x  |    |  x  |     |  x  |     |  x  |
          | xbb |    | xbb |     | xbO |     | xbO |
          |  b  |    |  O  |     |  b  |     |  O  |
         */

        //Ha a lenti vagy fenti neighbour es a jobboldali vagy baloldali
        // neighbour moveable-je false, akkor false erteket ad vissza a fgv.

       return !((!down || !up) && (!right  || !left));

    }

    /**
     * Lekéri az isOnGoal értékét.
     * @return
     */
    public boolean GetisOnGoal() {
        return isOnGoal;
    }

    /**
     * Beállitja az isOnGoal értékét.
     */
    public void SetisOnGoal() {

        if (isOnGoal)
            tile.GetMap().SetGoalCounter(tile.GetMap().GetGoalCounter()-1);
        else
            tile.GetMap().SetGoalCounter(tile.GetMap().GetGoalCounter()+1);

        isOnGoal = !isOnGoal;
    }

    /**
     * Átállítja a valid attribútumot a mostani érték ellenkezőjére.
     */
    public void SetValid() {
        if (valid)
            valid = false;
    }

    /**
     * Visszaadja a valid attribútum értékét.
     * @return
     */
    public boolean GetValid() {
       return valid;
    }

    /**
     * Elintézi a pontszámítást.
     * @param d
     */
    public void AddPoint(Direction d) {

        Tile t = tile.GetNeighbour(d);

        for (Thing i : t.GetThings()) {
            i.AddPoint(d);
        }

    }

    /**
     * Lépteti a dobozokat.
     * @param d Léptetés iránya.
     * @param Force Az utkozes ereje
     */
    private void Step (Direction d,double Force){


        Tile t = tile.GetNeighbour(d);
        tile.Remove(this);

        if (isOnGoal)
            this.SetisOnGoal();

        t.Add(this);

        for(Thing i : t.GetThings())
            if (!i.equals(this))
            i.HitBy(this,d,Force);
    }

    private void NeighbourMovableChecker(){

        ArrayList<Thing> AL = new ArrayList<Thing>();


        tile.AddThingsFromDirectionToList(Direction.down,AL);
        tile.AddThingsFromDirectionToList(Direction.up,AL);
        tile.AddThingsFromDirectionToList(Direction.left,AL);
        tile.AddThingsFromDirectionToList(Direction.right,AL);

        for (Thing t: AL) {
            if(t instanceof  Box)
                t.setMovable(((Box) t).CheckMovable());
        }

       
    }

    public void PlayerPushedIntoIt(Player p) {
        p.Die();
    }

    @Override
    public void draw(int x, int y, Canvas canvas) {

        canvas.getGraphicsContext2D().drawImage(image, x, y, Game.TILE_SIZE, Game.TILE_SIZE);
    }

    public void setMovable(boolean B){
        movable = B;
    }


    public int getWeight(){
        return weight;
    }
}