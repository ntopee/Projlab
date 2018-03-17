package Program;
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
    }


    /**
     * Az osztály eltárolja a játékban fellelhető szinteket.
     */
    private Set<Map> levels;   // List? #Bende

    /**
     * A jelenlegi pályának egy referenciáját tárolja el, arra jó,
     * hogy mindig tudjuk, melyik pálya van most “használatban”.
     */
    private Map currentlevel;

    /**
     * Betölti a megfelelő pályát a játékba.
     */
    public void Init() {
        System.out.println("> Innit");
        // TODO implement here
        System.out.println("< Innit");
    }

    /**
     * Megállítja a játékot (mivel vége van),
     * és kiírja a játékos(ok) pontszámát,
     * és ez alapján a nyertest is “kihirdeti”.
     */
    public static void EndGame() {
        System.out.println("> EndGame");
        // TODO implement here
        System.out.println("< EndGame");
    }

    /**
     * Beállítja a soron következő pályát,
     * és meghívja az init() függvényt.
     */
    public void NextLevel() {
        System.out.println("> NextLevel");
        // TODO implement here
        System.out.println("< NextLevel");
    }

    /**
     * Újraindítja az aktuális pályát.
     */
    public void RestartLevel() {
        System.out.println("> RestartLevel");
        // TODO implement here
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