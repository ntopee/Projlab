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
     * 
     */
    private int num_of_movable_boxes;

    /**
     * 
     */
    private int goalcounter;



    /**
     * 
     */
    private Set<Player> players;

    /**
     *
     */
    private Set<Tile> tiles;

    /**
     * 
     */
    public void AddPlayer() {
        System.out.println("> AddPlayer");
        // TODO implement here
        System.out.println("< AddPlayer");
    }

    /**
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
     * 
     */
    public void CheckEndGame() {
        System.out.println("> CheckEndGame");
        // TODO implement here
        System.out.println("< CheckEndGame");
    }

}