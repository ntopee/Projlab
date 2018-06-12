package Program;

import javafx.scene.image.Image;

public class Images {
    static Image BoxImage = new Image((Box.class).getResourceAsStream("FxSources/box.png"));

    static Image WallImage = new Image(Wall.class.getResourceAsStream("FxSources/wall.png"));

    static Image PillarImage = new Image(Pillar.class.getResourceAsStream("FxSources/pillar.png"));

    static Image SwitchImage = new Image(Switch.class.getResourceAsStream("FxSources/switch.png"));

    static Image HoleImage = new Image(Hole.class.getResourceAsStream("FxSources/hole.png"));
    static Image HoleimageO = new Image(Hole.class.getResourceAsStream("FxSources/holeon.png"));

    static Image GoalImage = new Image(Goal.class.getResourceAsStream("FxSources/goal.png"));


    static Image HoneyImage = new Image(Tile.class.getResourceAsStream("FxSources/honey.png"));
    static Image OilImage = new Image(Tile.class.getResourceAsStream("FxSources/oil.png"));
}
