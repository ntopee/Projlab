package Program;
import java.util.*;

import static Program.Main.tabber;
import static Program.Main.tabolo;

/**
 *  Tárolja a Tile-okat, amikből maga a pálya felépül.
 *  A pálya tulajdonságai is lekérdezhetőek, amelyek a pálya kirajzolásához kellenek majd.
 *  Tudja, mikor van vége a játéknak és ekkor meghívja a Game EndGame függvényét.
 *  Ismeri a mozgatható dobozok számát és csökkenteni tudja őket.
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
     * Ellenszamlalas, ha egz lada a goalon van, es melle nem is mozdithato, akkor ez novekedik egyel
     */
    private int counterweight;



    /**
     * A player objektumok referenciái.
     */
    private Set<Player> players = new HashSet<>();

    /**
     * A pályán található összes mező itt van eltárolva.
     */
    public Set<Tile> tiles = new HashSet<Tile>(); //ezeket kell inicializálni különben nullpointerexception #bende


    /**
     * Egy Tile-ra rárak egy új játékost, amit ugyanez a függvény hoz létre.
     */
    public void AddPlayer() {
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
        tabber++;
        tabolo(tabber);
        System.out.println("> RemovePlayer");
        players.remove(p);

        tabolo(tabber);
        tabber--;

        System.out.println("< RemovePlayer");
    }

    /**
     * Visszadja hogy mozdítható láda van a helyén
     * @return
     */
    public int GetNumOfMBoxes() {
        tabber++;
        tabolo(tabber);
        System.out.println("> GetNumOfMBoxes");


        tabber--;
        tabolo(tabber);
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

    public void DecreaseNumOfBoxes(){
        --num_of_movable_boxes;
    }

    /**
     * Visszaadja hogy hány láda van a helyén.
     * @return
     */
    public int GetGoalCounter() {
        tabber++;
        tabolo(tabber);
        System.out.println("> GetGoalCounter");


        tabolo(tabber);
        tabber--;
        System.out.println("< GetGoalCounter");
        return goalcounter;
    }

    /**
     * Bállítja hogy hogy hány láda van a helyén.
     * @param n
     */
    public void SetGoalCounter(int n) {
        tabber++;
        tabolo(tabber);
        System.out.println("> SetGoalCounter");
        goalcounter = n;

        tabolo(tabber);
        tabber--;
        System.out.println("< SetGoalCounter");
    }

    /**
     * Kivonja egymásból a goalcounter-t
     * és a num_of_moveable_boxes-t,
     * ha nulla végeredmény,
     * akkor meghívja az EndGame() függvényt.
     */
    public void CheckEndGame() {
        tabber++;
        tabolo(tabber);
        System.out.println("> CheckEndGame");
        if ( (players.size() == 0) || (goalcounter == (num_of_movable_boxes + counterweight)) || (num_of_movable_boxes ==0))
            Game.EndGame();

        tabolo(tabber);
        tabber--;

        System.out.println("< CheckEndGame");
    }

    public int GetCounterWeight() {
        tabber++;
        tabolo(tabber);
        System.out.println("> GetCounterWeight");

        tabolo(tabber);
        tabber--;
        System.out.println("< GetCounterWeight");

        return counterweight;
    }

    /**
     * Bállítja hogy hogy hány láda van a helyén.
     * @param n
     */
    public void SetCounterWeight(int n) {
        tabber++;
        tabolo(tabber);
        System.out.println("> SetCounterWeight");

        counterweight = n;

        tabolo(tabber);
        tabber--;
        System.out.println("< SetCounterWeight");
    }

}