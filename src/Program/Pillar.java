package Program;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

/**
 * Felelős azért, hogy a játékos ne tudjon rajta átmenni, a dobozt ne tudjuk áttolni. A saját Tile-án egyedüli objektumnak kell lennie.
 */
public class Pillar extends Obstacle {

    /**
     * Default constructor
     */
    public Pillar() {
        super();
    }

    @Override
    public String toString() {
        return "Pillar ";
    }

    /**
     * Egy akadály ütközik egy dobozzal.
     * Meghívja a Box HitBy függvényét az ellenkező irányba.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d, double Force) {
        super.HitBy(b,d, Force);
    }

    @Override
    public void draw(int x, int y, Canvas canvas) {
        Image image = new Image(getClass().getResourceAsStream("FxSources/pillar.png"));
        canvas.getGraphicsContext2D().drawImage(image, x, y, Game.TILE_SIZE, Game.TILE_SIZE);
    }

    /**
     * Egy akadály ütközik egy játékossal.
     * Meghívja a Player move függvényét az ellenkező irányba.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Player p, Direction d, double Force) {
        super.HitBy(p,d, Force);
    }

}