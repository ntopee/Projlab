package Program;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.*;
import java.util.Map;

/**
 * A pálya mezőit reprezentálja.
 * Eltárolja a Thing-eket.
 */
public class Tile {
    /**
     * Cellát tartalmazó map referenciája.
     */
    private Program.Map map;
    /**
     *
     * Egy olaj referencia, ha van a tile-on olaj.
     */
    private double oil = 1.0;


    /**
     * Egy mez referencia, ha van a tile-on mez.
     */
    private double honey = 1.0;

    /**
     * Default constructor
     */
    public Tile(Program.Map m) { map = m; }

    public Tile(){}

    /**
     * A cellán elhelyezkedő dolgok kollekciója.
     */
    private ArrayList<Thing> things = new ArrayList<Thing>();

    /**
     * Egy cella szomszédai.
     */
    private Map<Direction, Tile> neighbours = new HashMap<Direction, Tile>();

    /**
     * Új dolgok hozzáadása a cellához,
     * és ütköztetése az ott lévő dolgokkal.
     * @param t Egy Thing referencia.
     */
    public void Add(Thing t) {
        things.add(t);
        t.tile=this;
    }



    /**
     * Eltávolít egy adott dolgot a celláról.
     * @param t Eltávolítandó Thing referencia.
     */
    public void Remove(Thing t) {
        things.remove(t);
    }

    /**
     * Visszaadja a cellához tartozó,
     * a paraméterként kapott irányban lévő szomszédos cellát.
     * @param d Direction, ebben az irányban kérdezzük le a szomszédot.
     * @return
     */
    public Tile GetNeighbour(Direction d) throws NullPointerException{
        return neighbours.get(d);
    }

    /**
     * Beállítja egy adott cella szomszédját.
     * @param d Ebben az irányban lévő szomszédot változtatjuk.
     * @param t Ezt az értéket kapja meg a szomszéd.
     */
    public void SetNeighbour(Direction d, Tile t) {
        neighbours.remove(d);
        neighbours.put(d, t);
    }

    /**
     * Visszaadja a things kollekciót.
     * @return
     */
    public ArrayList<Thing> GetThings(){
        return things;
    }


    /**
     * Visszaadja a Map-ot.
     * @return Map visszateres.
     */
    public Program.Map GetMap(){
        return map;
    }

    public double GetHoney(){
        return honey;
    }

    public void SetHoney(double n){
        honey = n;
    }

    public double GetOil(){
        return oil;
    }

    public void SetOil(double n){
        oil = n;
    }

    public void AddThingsFromDirectionToList(Direction d, ArrayList<Thing> AL){
        try {
             AL.addAll(GetNeighbour(d).GetThings());
        }
            catch (NullPointerException except) {
            System.out.println("No neighbour found from the direction.");
        }
    }

    public void Draw(int x, int y, Canvas canvas){
       //TODO tile kirajzolas(huni és oil)

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GRAY);
        gc.fillRect(x, y, Game.TILE_SIZE, Game.TILE_SIZE);


        if(honey!=1) {
            Image image = new Image(getClass().getResourceAsStream("FxSources/honey.png"));
            canvas.getGraphicsContext2D().drawImage(image, x, y, 15, 15);
        }
        for (Thing t: things) {
            t.draw(x,y,canvas);
        }
    }
}