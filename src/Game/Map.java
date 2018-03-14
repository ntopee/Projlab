package Game;
import java.util.*;

/**
 *  Tárolja a Tile-okat, amikből maga a pálya felépül. A pálya tulajdonságai is lekérdezhetőek, amelyek a pálya kirajzolásához kellenek majd.
 *  Tudja, mikor van vége a játéknak és ekkor meghívja a Game EndGame függvényét. Ismeri a mozgatható dobozok számát és csökkenteni tudja őket.
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
     * @param p
     */
    public void RemovePlayer(Player p) {
        System.out.println("> RemovePlayer");
        // TODO implement here
        System.out.println("< RemovePlayer");
    }

    /**
     * @return
     */
    public int GetNumOfMBoxes() {
        System.out.println("> GetNumOfMBoxes");
        // TODO implement here
        System.out.println("< GetNumOfMBoxes");
        return 0;
    }

    /**
     * @param n
     */
    public void SetNumOfMBoxes(int n) {
        System.out.println("> SetNumOfMBoxes");
        // TODO implement here
        System.out.println("< SetNumOfMBoxes");
    }

    /**
     * @return
     */
    public int GetGoalCounter() {
        System.out.println("> GetGoalCounter");
        // TODO implement here
        System.out.println("< GetGoalCounter");
        return 0;
    }

    /**
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