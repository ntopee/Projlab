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
        System.out.println("> Box HitBy Box");
        // TODO implement here
        System.out.println("< Box HitBy Box");
    }

    /**
     * @param p 
     * @param d
     */
    public void HitBy(Player p, Direction d) {
        System.out.println("> Box HitBy Player");
        // TODO implement here
        System.out.println("< Box HitBy Player");
    }

    /**
     * 
     */
    public void Die() {
        System.out.println("> Die");
        // TODO implement here
        System.out.println("< Die");
    }

    /**
     * @param o 
     * @param d
     */
    public void HitBy(Obstacle o, Direction d) {
        System.out.println("> Box HitBy Obstacle");
        // TODO implement here
        System.out.println("< Box HitBy Obstacle");
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean CheckMovable() {
        System.out.println("> CheckMovable");
        // TODO implement here
        System.out.println("< CheckMovable");
        return false;
    }

    /**
     * @return
     */
    public boolean GetisOnGoal() {
        System.out.println("> GetisOnGoal");
        // TODO implement here
        System.out.println("< GetisOnGoal");
        return false;
    }

    /**
     * 
     */
    public void SetisOnGoal() {
        System.out.println("> SetisOnGoal");
        // TODO implement here
        System.out.println("< SetisOnGoal");
    }

    /**
     * 
     */
    public void SetValid() {
        System.out.println("> SetValid");
        // TODO implement here
        System.out.println("< SetValid");
    }

    /**
     * @return
     */
    public boolean GetValid() {
        System.out.println("> GetValid");
        // TODO implement here
        System.out.print("< GetValid");
        return false;
    }

    /**
     * @param d
     */
    public void AddPoint(Direction d) {
        System.out.println("> AddPoint");
        // TODO implement here
        System.out.println("< AddPoint");
    }

}