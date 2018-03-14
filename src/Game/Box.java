package Game;

/**
 * 
 */
public class Box extends Thing {

    /**
     * Default constructor
     */
    public Box() {
    }

    /**
     * 
     */
    private boolean valid;

    /**
     * 
     */
    private boolean isOnGoal;

    /**
     * @param b 
     * @param d
     */
    public void HitBy(Box b, Direction d) {
        // TODO implement here
    }

    /**
     * @param p 
     * @param d
     */
    public void HitBy(Player p, Direction d) {
        // TODO implement here
    }

    /**
     * 
     */
    public void Die() {
        // TODO implement here
    }

    /**
     * @param o 
     * @param d
     */
    public void HitBy(Obstacle o, Direction d) {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean CheckMovable() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean GetisOnGoal() {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public void SetisOnGoal() {
        // TODO implement here
    }

    /**
     * 
     */
    public void SetValid() {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean GetValid() {
        // TODO implement here
        return false;
    }

    /**
     * @param d
     */
    public void AddPoint(Direction d) {
        // TODO implement here
    }

}