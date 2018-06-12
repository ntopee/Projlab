package Program;

import javafx.scene.canvas.Canvas;

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
    /**
     * Kirazolja a pillart.
     * @param x X koordinata
     * @param y Y koordinata
     * @param canvas Ide rajzolja ki
     */
    @Override
    public void draw(int x, int y, Canvas canvas) {

        canvas.getGraphicsContext2D().drawImage(Images.PillarImage, x, y, Game.TILE_SIZE, Game.TILE_SIZE);
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