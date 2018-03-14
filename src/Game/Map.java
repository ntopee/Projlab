package Game;
import java.util.*;

/**
 * 
 */
public class Map {

    /**
     * Default constructor
     */
    public Map() {
    }

    /**
     * A kezdőértéke egyenlő a ládák számával,
     * majd ha egy láda mozgathatatlanná válik,
     * akkor ez a szám eggyel csökken.
     */
    private int num_of_movable_boxes;

    /**
     * Megadja, hogy hány láda van a helyén.
     */
    private int goalcounter;



    /**
     * A player objektumok referenciái.
     */
    private Set<Player> players;

    /**
     * A pályán található összes mező itt van eltárolva.
     */
    private Set<Tile> tiles;

    /**
     * Egy Tile-ra rárak egy új játékost, amit ugyanez a függvény hoz létre.
     */
    public void AddPlayer() {
        System.out.println("> AddPlayer");
        // TODO implement here
        System.out.println("< AddPlayer");
    }

    /**
     * A játékos referenciát, amit megkap a függvény, kitörli a pályáról.
     * @param p Eltávolítandó Player referenciája.
     */
    public void RemovePlayer(Player p) {
        System.out.println("> RemovePlayer");
        // TODO implement here
        System.out.println("< RemovePlayer");
    }

    /**
     * Visszadja hogy mozdítható láda van a helyén
     * @return
     */
    public int GetNumOfMBoxes() {
        System.out.println("> GetNumOfMBoxes");
        // TODO implement here
        System.out.println("< GetNumOfMBoxes");
        return 0;
    }

    /**
     * Beállítja a num_of_movable_boxes értékét.
     * @param n Erre az értékre állítja be a num_of_movable_boxes értékét.
     */
    public void SetNumOfMBoxes(int n) {
        System.out.println("> SetNumOfMBoxes");
        // TODO implement here
        System.out.println("< SetNumOfMBoxes");
    }

    /**
     * Visszaadja hogy hány láda van a helyén.
     * @return
     */
    public int GetGoalCounter() {
        System.out.println("> GetGoalCounter");
        // TODO implement here
        System.out.println("< GetGoalCounter");
        return 0;
    }

    /**
     * Bállítja hogy hogy hány láda van a helyén.
     * @param n
     */
    public void SetGoalCounter(int n) {
        System.out.println("> SetGoalCounter");
        // TODO implement here
        System.out.println("< SetGoalCounter");
    }

    /**
     * Kivonja egymásból a goalcounter-t
     * és a num_of_moveable_boxes-t,
     * ha nulla végeredmény,
     * akkor meghívja az EndGame() függvényt
     */
    public void CheckEndGame() {
        System.out.println("> CheckEndGame");
        // TODO implement here
        System.out.println("< CheckEndGame");
    }

}