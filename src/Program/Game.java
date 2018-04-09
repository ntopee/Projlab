package Program;
import java.io.File;
import java.util.*;

import static Program.Direction.*;

/**
 * A játékot reprezentálja, mapeket tölt be.
 */
public class Game {

    /**
     * Default constructor
     */
    public Game() {

        //todo beolvasni a fileneveket
        //levels.add("filename");
        //Init(levels.get(0));
    }


    /**
     * Az osztály eltárolja a játékban fellelhető szinteket.
     */
   // private Set<Map> levels;   // List? #Bende

    /**
     * A jelenlegi pályának egy referenciáját tárolja el, arra jó,
     * hogy mindig tudjuk, melyik pálya van most “használatban”.
     */
   // private Map currentlevel;

    private String current;

    private ArrayList<String> levels;

    /**
     * Betölti a megfelelő pályát a játékba.
     */
    public void Init(String filename) {
        System.out.println("> Init");
        // TODO implement here

        current = filename;

        //filename.betolt

        /**
         * filename alapjan betolti a palyat
         */

        System.out.println("< Init");
    }

    /**
     * Megállítja a játékot (mivel vége van),
     * és kiírja a játékos(ok) pontszámát,
     * és ez alapján a nyertest is “kihirdeti”.
     */
    public static void EndGame() {
        System.out.println("> EndGame");
        // TODO implement here
        /**
         * kiirja a kepernyore hogy vege van, aztan kidob menube
         */


        System.out.println("< EndGame");
    }

    /**
     * Beállítja a soron következő pályát,
     * és meghívja az init() függvényt.
     */
    public void NextLevel(String Filename) {
        System.out.println("> NextLevel");
        // TODO implement here

        Init(Filename);

        /**
         * meghiv egy initet a kovi levellel
         */

        System.out.println("< NextLevel");
    }

    /**
     * Újraindítja az aktuális pályát.
     */
    public void RestartLevel() {
        System.out.println("> RestartLevel");
        // TODO implement here

        Init(current);
        /**
         * meghivja az initet ugyanazzal a filename-el
         */
        System.out.println("< RestartLevel");
    }

    /**
     * Egy adott iránynak megadja a vele ellenkező irányt.
     * @param d Direction, irány.
     * @return
     */
    static Direction GetOpposite(Direction d){
        switch (d) {
            case up:
                return down;
            case down:
                return up;
            case left:
                return right;
            case right:
                return left;
            default:
                return d;
        }
    }
}