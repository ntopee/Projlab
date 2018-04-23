package Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Beta_Test {


    private Game game;
    private ArrayList<String> levels;


    public Beta_Test(){
        levels = game.getLevels();

    }


    public void StartLevel(int i){
        game.Init(levels.get(i)); //több pálya lehetséges
    }

    public void Move(int i , Direction d){
        game.GetCurrentLevel().getPlayer().get(i).Move(d);
    }

    public void List(){

    }

    public void Put(int i, String BeUSA){
        if(BeUSA.equals("Honey"))
            game.GetCurrentLevel().getPlayer().get(i).Bee();
        else if(BeUSA.equals("Oil"))
            game.GetCurrentLevel().getPlayer().get(i).Bee();
        else System.out.println("You're not BEE-ing USA");
    }

    public void InputHandler() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            String str = br.readLine();



    }



}
