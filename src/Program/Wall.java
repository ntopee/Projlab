package Program;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

/**
 * A raktár építőeleme, nem tudunk rajta átmenni, dobozt áttolni. Ezzel ki tudjuk jelölni egy pálya határvonalát, játékteret biztosítva a játékosoknak.
 */
public class Wall extends Obstacle {
     Image image = new Image(getClass().getResourceAsStream("FxSources/wall.png"));
    /**
     * Default constructor
     */
    public Wall() {
        super();
    }

    @Override
    public String toString() {
        return "Wall ";
    }

    /**
     * Egy akadály ütközik egy dobozzal. Meghívja a Box HitBy függvényét az ellenkező irányba.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d, double Force) {
        super.HitBy(b,d, Force);
    }

    /**
     * Kirazolja a falat.
     * @param x X koordinata
     * @param y Y koordinata
     * @param canvas Ide rajzolja ki
     */

    @Override
    public void draw(int x, int y, Canvas canvas) {

        canvas.getGraphicsContext2D().drawImage(image, x, y, Game.TILE_SIZE, Game.TILE_SIZE);
    }

    /**
     * Egy akadály ütközik egy játékossal. Meghívja a Player move függvényét az ellenkező irányba.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Player p, Direction d, double Force) {
        super.HitBy(p,d, Force);
    }

}