package Program;

import static Program.Main.tabber;
import static Program.Main.tabolo;

public abstract class Usables {


    /**
     * A surlodas erteke.
     */
    private double friction = 1;


    /**
     *
     * Visszaadja a surlodas erteket.
     * @return
     */

    public double getFriction(){
        tabber++;
        tabolo(tabber);
        System.out.println("> GetFriction");

        tabolo(tabber);
        tabber--;

        System.out.println("< GetFriction");



        return friction;
    }

    /**
     * Beallitja a surlodas erteket.
     * @param Friction Az az ertek, mit be szeretnenk allitani uj erteknek a surlodashoz.
     */

    public void setFriction(double Friction){
        tabber++;
        tabolo(tabber);
        System.out.println("> SetFriction");

        tabolo(tabber);
        tabber--;

        System.out.println("< SetFriction");

        this.friction = Friction;
    }
}
