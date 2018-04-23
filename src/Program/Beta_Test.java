package Program;

import java.util.ArrayList;

public class Beta_Test {

    //Game.Init("Map.txt");
    private Game game;
    private ArrayList<String> levels;
    //game.Init(levels.get());

    public Beta_Test(){
        levels = game.getLevels();

    }


    public void StartLevel(int i){
        game.Init(levels.get(i));
    }

    public void Move(String player , Direction d){

        game.GetCurrentLevel();
    }

    public void List(){

    }

    public void Put(){

    }

    public void EventHandler(){

    }



}
