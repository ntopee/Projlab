package Program;

import static Program.Main.tabber;
import static Program.Main.tabolo;

public abstract class Usables {

    private final double friction = 1;


    public double getFriction(){
        tabber++;
        tabolo(tabber);
        System.out.println("> GetFriction");

        tabolo(tabber);
        tabber--;

        System.out.println("< GetFriction");



        return friction;
    }
}
