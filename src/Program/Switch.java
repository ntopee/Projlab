package Program;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import java.util.*;

/**
 * Vannak olyan lyukak, amelyek padlónak látszanak, de egy gomb lenyomására aktiválódnak.
 * Az aktiválást olyan mezők végzik, amiken van kapcsoló (Switch).
 */
public class Switch extends Thing {

    /**
     * Default constructor
     */
    public Switch() {

        movable = true;
    }

    public Switch(int id){ ID = id; }

    @Override
    public String toString() {
        return "Switch ";
    }

    /**
     * Azoknak a lyukaknak a referenciáját tárolja, amelyeket az adott gomb befolyásolja.
     */
    private Set<Hole> holes = new HashSet<Hole>();

    private int ID = 0;

    public void Add(Hole h){
        holes.add(h);
    }

    /**
     * Amikor egy ládát tol egy játékos a gombra, akkor a gomb aktiválásának következményeit kezeli.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d, double Force) {
        this.Activate();
    }

    @Override
    public void draw(int x, int y, Canvas canvas) {
        Image image = new Image(getClass().getResourceAsStream("FxSources/switch.png"));
        canvas.getGraphicsContext2D().drawImage(image, x, y, Game.TILE_SIZE, Game.TILE_SIZE);
    }

    /**
     * Meghívja az összes, a switch-hez tartozó Hole SetActive() függvényét.
     */
    private void Activate() {
        for (Hole i : holes) {
            i.SetActive();
        }
    }

    public int getID(){ return ID; }

}