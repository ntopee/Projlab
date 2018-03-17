package Program;
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
     * Az összes láda száma.
     */
    private int num_of_boxes;
    /**
     * Megadja, hogy hány láda van a helyén.
     */
    private int goalcounter;



    /**
     * A player objektumok referenciái.
     */
    private Set<Player> players; //List? #bende

    /**
     * A pályán található összes mező itt van eltárolva.
     */
    private Set<Tile> tiles;

    /**
     * Egy Tile-ra rárak egy új játékost, amit ugyanez a függvény hoz létre.
     */
    public void AddPlayer() { //WHATT? miért nincs paraméter, ez mit csinál?  //Hozzá ad egy játékos, jelenleg nincs paramétere, igazából lehetne neve, és akkor azt meg lehetne addni, vagy valamai kis azonosító amivel billentyű kiosztást kaphat. #bende
        System.out.println("> AddPlayer");
        // TODO implement here
        players.add(new Player());
        System.out.println("< AddPlayer");
    }

    /**
     * A játékos referenciát, amit megkap a függvény, kitörli a pályáról.
     * @param p Eltávolítandó Player referenciája.
     */
    public void RemovePlayer(Player p) {
        System.out.println("> RemovePlayer");
        players.remove(p);
        System.out.println("< RemovePlayer");
    }

    /**
     * Visszadja hogy, hány mozdítható láda van a helyén
     * @return
     */
    public int GetNumOfMBoxes() {
        System.out.println("> GetNumOfMBoxes");

        System.out.println("< GetNumOfMBoxes");
        return num_of_movable_boxes;
    }

    /**
     * Beállítja a num_of_movable_boxes értékét.
     * @param n Erre az értékre állítja be a num_of_movable_boxes értékét.
     */
    public void SetNumOfMBoxes(int n) {
        System.out.println("> SetNumOfMBoxes");
        num_of_movable_boxes = n;
        System.out.println("< SetNumOfMBoxes");
    }

    /**
     * Csökkenti a mozgatható dobozok számát
     */
    public void DecreaseNumOfBoxes(){
        --num_of_movable_boxes;
    }

    /**
     * Visszaadja hogy hány láda van a helyén.
     * @return
     */
    public int GetGoalCounter() {
        System.out.println("> GetGoalCounter");

        System.out.println("< GetGoalCounter");
        return goalcounter;
    }

    /**
     * Bállítja hogy hogy hány láda van a helyén.
     * @param n
     */
    public void SetGoalCounter(int n) {
        System.out.println("> SetGoalCounter");
        goalcounter = n;
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
        if ( (players.size() == 0)&&(num_of_boxes == goalcounter + num_of_movable_boxes))  // szerintem ez vagy kapcsolat #Bende
            Game.EndGame();
        System.out.println("< CheckEndGame");
    }

}