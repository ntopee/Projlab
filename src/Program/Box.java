package Program;

import static Program.Main.tabber;
import static Program.Main.tabolo;

/**
 *A játékban található ládákat reprezentálja.
 */
public class Box extends Thing {

    @Override
    public String toString() {
        return "Box";
    }


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
        tabber++;
        tabolo(tabber);

        System.out.println("> Box HitBy Box");
        double tmp = Force-weight*tile.getOil().getFriction()*tile.getHoney().getFriction();
        if (!this.movable || (tmp<=0))
            b.HitBy(this,Game.GetOpposite(d), Force);
        else {
            Step(d, Force);
            movable = CheckMovable();
        }

        tabolo(tabber);
        tabber--;

        System.out.println("< Box HitBy Box");
    }

    /**
     * Box-ként ütközik egy Player-el.
     * @param p Player referencia
     * @param d Az ütközés iránya
     * @param Force Az utkozes ereje
     */
    public void HitBy(Player p, Direction d, double Force) {
        tabber++;
        tabolo(tabber);
        System.out.println("> Box HitBy Player");
        double tmp = Force-weight*tile.getOil().getFriction()*tile.getHoney().getFriction();
        if (!this.movable || tmp <= 0){
            p.Move(Game.GetOpposite(d));
        }
        else{
            Step(d,Force);
            movable = CheckMovable();
        }
        tabolo(tabber);
        tabber--;

        System.out.println("< Box HitBy Player");
    }

    /**
     * Akkor hívódik meg, ha a láda leesik egy lyukon. A láda eltűnik a pályáról.
     */
    public void Die() {
        tabber++;
        tabolo(tabber);
        System.out.println("> Die Box");

        tile.Remove(this);
        this.valid = false;
        this.isOnGoal = false;
        this.movable = false;
        tile.GetMap().DecreaseNumOfBoxes();
        tabolo(tabber);
        tabber--;

        System.out.println("< Die Box");
    }

    /**
     * A függvénynek megadott irányba mozgatja a ládát egy mezővel(ha lehet).
     * @param o Obstacle referencia.
     * @param d Ütközés iránya.
     * @param Force Az utkozes ereje
     */
    public void HitBy(Obstacle o, Direction d, double Force) {
        tabber++;
        tabolo(tabber);
        System.out.println("> Box HitBy Obstacle");

        Step(d, Force);

        tabolo(tabber);
        tabber--;

        System.out.println("< Box HitBy Obstacle");
    }

    /**
     * Ha meghívódik ez a függvény, akkor megnézi,
     * hogy még mozgatható-e a láda valamilyen irányba.
     * Ha változik az érték, akkor annak megfelelően növeli/csökkenti a num_ofmovable_boxes-t.
     * @return
     */
    public boolean CheckMovable() {
        tabber++;
        tabolo(tabber);
        System.out.println("> CheckMovable");
        // TODO implement here -- meg kell nézni hogy két szomszédos szomszédja movable-e.
        /*
        felulnezet:
        b = Box, O = Obstacle, x = mindegy
          |  x  |    |  x  |     |  x  |     |  x  |
          | xbb |    | xbb |     | xbO |     | xbO |
          |  b  |    |  O  |     |  b  |     |  O  |
         */

        tabolo(tabber);
        tabber--;

        System.out.println("< CheckMovable");
        return false;
    }

    /**
     * Lekéri az isOnGoal értékét.
     * @return
     */
    public boolean GetisOnGoal() {
        tabber++;
        tabolo(tabber);
        System.out.println("> GetisOnGoal");


        tabolo(tabber);
        tabber--;

        System.out.println("< GetisOnGoal");
        return isOnGoal;
    }

    /**
     * Beállitja az isOnGoal értékét.
     */
    public void SetisOnGoal() {
        tabber++;
        tabolo(tabber);
        System.out.println("> SetisOnGoal");

        if (isOnGoal)
            tile.GetMap().SetGoalCounter(tile.GetMap().GetGoalCounter()-1);
        else
            tile.GetMap().SetGoalCounter(tile.GetMap().GetGoalCounter()+1);

        isOnGoal = !isOnGoal;
        tabolo(tabber);
        tabber--;

        System.out.println("< SetisOnGoal");
    }

    /**
     * Átállítja a valid attribútumot a mostani érték ellenkezőjére.
     */
    public void SetValid() {
        tabber++;
        tabolo(tabber);
        System.out.println("> SetValid");
        if (valid)
            valid = false;
        tabolo(tabber);
        tabber--;
        ;
        System.out.println("< SetValid");
    }

    /**
     * Visszaadja a valid attribútum értékét.
     * @return
     */
    public boolean GetValid() {
        tabber++;
        tabolo(tabber);
        System.out.println("> GetValid");

        tabolo(tabber);
        tabber--;

        System.out.println("< GetValid");


       return valid;
    }

    /**
     * Elintézi a pontszámítást.
     * @param d
     */
    public void AddPoint(Direction d) {
        tabber++;
        tabolo(tabber);
        System.out.println("> AddPoint");
        
        Tile t = tile.GetNeighbour(d);

        for (Thing i : t.GetThings()) {
            i.AddPoint(d);
        }

        tabolo(tabber);
        tabber--;

        System.out.println("< AddPoint");
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

    public void PlayerPushedIntoIt(Player p) {
        tabber++;
        tabolo(tabber);
        System.out.println("> PlayerPushedIntoIt");
        p.Die();

        tabolo(tabber);
        tabber--;

        System.out.println("> PlayerPushedIntoIt");
    }

    public void setMovable(boolean B){
        movable = B;
    }


    public int getWeight(){

        tabber++;
        tabolo(tabber);
        System.out.println("> GetWeight");

        tabolo(tabber);
        tabber--;

        System.out.println("< GetWeight");

        return weight;
    }
}