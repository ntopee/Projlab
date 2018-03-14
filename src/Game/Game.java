package Game;
import java.util.*;

/**
 * 
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
    private Set<Map> levels;

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
    public void EndGame() {
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

}