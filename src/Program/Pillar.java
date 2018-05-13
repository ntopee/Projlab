package Program;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import static Program.Main.tabber;
import static Program.Main.tabolo;

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
        tabber++;
        tabolo(tabber);
        System.out.println("> Pillar HitBy Box");
        super.HitBy(b,d, Force);

        tabolo(tabber);
        tabber--;

        System.out.println("< Pillar HitBy Box");
    }

    @Override
    public void draw(int x, int y, Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        String filePath = "file:FxSources/box.png";
        Image image = new Image(filePath);
        gc.setFill(Color.YELLOW);
        gc.fillRect(x, y, Game.TILE_SIZE, Game.TILE_SIZE);
    }

    /**
     * Egy akadály ütközik egy játékossal.
     * Meghívja a Player move függvényét az ellenkező irányba.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Player p, Direction d, double Force) {
        tabber++;
        tabolo(tabber);
        System.out.println("> Pillar HitBy Player");
        super.HitBy(p,d, Force);

        tabolo(tabber);
        tabber--;

        System.out.println("< Pillar HitBy Player");
    }

}