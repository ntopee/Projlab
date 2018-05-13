package Program;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

/**
 * Olyan mezőket képvisel, amelyekre a ládákat kell tolni a pontszerzéshez.
 */
public class Goal extends Thing {

    /**
     * Default constructor
     */
    public Goal() {
        movable = true;
    }
    Image image = new Image(getClass().getResourceAsStream("FxSources/goal.png"));
    @Override
    public String toString() {
        return "Goal ";
    }

    /**
     * Ha egy doboz rámegy a mezőre, az alapján, hogy honnan jött,
     * annak a playernek ad pontot. A Box valid értékét átállítja false-ra,
     * hogy ne lehessen több pontot szerezni vele.
     * Az isOnGoal értékét is igazra állítja.
     * @param b Box referencia.
     * @param d Ütközés iránya.
     */
    public void HitBy(Box b, Direction d, double Force) {

        if(b.GetValid()) {
            b.SetValid();
            b.AddPoint(Game.GetOpposite(d));
        }
            b.SetisOnGoal();
           if(b.CheckMovable() == false)
               tile.GetMap().SetCounterWeight(
                   tile.GetMap().GetCounterWeight()+1);
            tile.GetMap().CheckEndGame();

    }

    @Override
    public void draw(int x, int y, Canvas canvas) {

        canvas.getGraphicsContext2D().drawImage(image, x, y, Game.TILE_SIZE, Game.TILE_SIZE);
    }

}