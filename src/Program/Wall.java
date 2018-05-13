package Program;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import static Program.Main.tabber;
import static Program.Main.tabolo;

/**
 * A raktár építőeleme, nem tudunk rajta átmenni, dobozt áttolni. Ezzel ki tudjuk jelölni egy pálya határvonalát, játékteret biztosítva a játékosoknak.
 */
public class Wall extends Obstacle {

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
        tabber++;
        tabolo(tabber);
        System.out.println("> HitBy Box");
        super.HitBy(b,d, Force);


        tabolo(tabber);
        tabber--;

        System.out.println("< HitBy Box");
    }

    @Override
    public void draw(int x, int y, Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        String filePath = "file:FxSources/box.png";
        Image image = new Image(filePath);
        gc.setFill(Color.RED);
        gc.fillRect(x, y, Game.TILE_SIZE, Game.TILE_SIZE);
    }

    /**
     * Egy akadály ütközik egy játékossal. Meghívja a Player move függvényét az ellenkező irányba.
     * @param p Player referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Player p, Direction d, double Force) {
        tabber++;
        tabolo(tabber);
        System.out.println("> HitBy Player");
        super.HitBy(p,d, Force);


        tabolo(tabber);
        tabber--;

        System.out.println("< HitBy Player");
    }

}