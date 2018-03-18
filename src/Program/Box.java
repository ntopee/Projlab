package Program;

/**
 *A játékban található ládákat reprezentálja.
 */
public class Box extends Thing {

    @Override
    public String toString() {
        return "Box";
    }

    /**
     * Default constructor
     */
    public Box() {
    }


    /**
     * Megadja, hogy az adott ládával lehet-e még pontot szerezni.
     */
    private boolean valid;

    /**
     * Megadja, hogy az adott láda Goal-on van-e.
     */
    private boolean isOnGoal;

    /*
     * Ütközik egy dologgal.
     * @param t Thing referencia.
     * @param d Ütközés iránya.
     */
    /*public void CollideWith(Thing t, Direction d) {
        System.out.println(">CollideWith");
        t.HitBy(this, d);
        System.out.println("<CollideWith");
    }*/

    /**
     * Box-ként ütközik Box-al.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d) {
        System.out.println("> Box HitBy Box");
        if (!this.movable)
            b.HitBy(this,Game.GetOpposite(d));
        else
            Step(d);

        movable = CheckMovable();

        System.out.println("< Box HitBy Box");
    }

    /**
     * Box-ként ütközik egy Player-el.
     * @param p Player referencia
     * @param d Az ütközés iránya
     */
    public void HitBy(Player p, Direction d) {
        System.out.println("> Box HitBy Player");

        if (!this.movable){
            p.Move(Game.GetOpposite(d));
        }
        else{
            Step(d);
        movable = CheckMovable();

        }

        System.out.println("< Box HitBy Player");
        return;
    }

    /**
     * Akkor hívódik meg, ha a láda leesik egy lyukon. A láda eltűnik a pályáról.
     */
    public void Die() {
        System.out.println("> Die");
        tile.Remove(this);
        this.valid = false;
        this.isOnGoal = false;
        this.movable = false;
        tile.GetMap().DecreaseNumOfBoxes();
        System.out.println("< Die");
    }

    /**
     * A függvénynek megadott irányba mozgatja a ládát egy mezővel(ha lehet).
     * @param o Obstacle referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Obstacle o, Direction d) {
        System.out.println("> Box HitBy Obstacle");

        Step(d);

        System.out.println("< Box HitBy Obstacle");
    }

    /**
     * Ha meghívódik ez a függvény, akkor megnézi,
     * hogy még mozgatható-e a láda valamilyen irányba.
     * Ha változik az érték, akkor annak megfelelően növeli/csökkenti a num_ofmovable_boxes-t.
     * @return
     */
    public boolean CheckMovable() {
        System.out.println("> CheckMovable");
        // TODO implement here -- meg kell nézni hogy két szomszédos szomszédja movable-e.
        /*
        felulnezet:
        b = Box, O = Obstacle, x = mindegy
          |  x  |    |  x  |     |  x  |     |  x  |
          | xbb |    | xbb |     | xbO |     | xbO |
          |  b  |    |  O  |     |  b  |     |  O  |
         */

        System.out.println("< CheckMovable");
        return false;
    }

    /**
     * Lekéri az isOnGoal értékét.
     * @return
     */
    public boolean GetisOnGoal() {
        System.out.println("> GetisOnGoal");

        System.out.println("< GetisOnGoal");
        return isOnGoal;
    }

    /**
     * Beállitja az isOnGoal értékét.
     */
    public void SetisOnGoal() {
        System.out.println("> SetisOnGoal");

        if (isOnGoal)
            tile.GetMap().SetGoalCounter(tile.GetMap().GetGoalCounter()-1);
        else
            tile.GetMap().SetGoalCounter(tile.GetMap().GetGoalCounter()+1);

        isOnGoal = !isOnGoal;
        System.out.println("< SetisOnGoal");
    }

    /**
     * Átállítja a valid attribútumot a mostani érték ellenkezőjére.
     */
    public void SetValid() {
        System.out.println("> SetValid");
        if (valid)
            valid = false;
        System.out.println("< SetValid");
    }

    /**
     * Visszaadja a valid attribútum értékét.
     * @return
     */
    public boolean GetValid() {
        System.out.println("> GetValid");
        System.out.print("< GetValid");
        return valid;
    }

    /**
     * Elintézi a pontszámítást.
     * @param d
     */
    public void AddPoint(Direction d) {
        System.out.println("> AddPoint");
        
        Tile t = tile.GetNeighbour(d);

        for (Thing i : t.GetThings()) {
            i.AddPoint(d);
        }
        
        System.out.println("< AddPoint");
    }

    /**
     * Lépteti a dobozokat.
     * @param d Léptetés iránya.
     */
    private void Step (Direction d){
        Tile t =this.tile.GetNeighbour(d);
        tile.Remove(this);

        if (isOnGoal)
            this.SetisOnGoal();

        t.Add(this);

        for(Thing i : t.GetThings())
            if (!i.equals(this))
            i.HitBy(this,d);
    }

    public void PlayerPushedIntoIt(Player p) {
        System.out.println("> PlayerPushedIntoIt");
        p.Die();
        System.out.println("> PlayerPushedIntoIt");
    }
}