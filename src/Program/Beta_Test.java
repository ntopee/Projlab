package Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Beta_Test {


    private Game game;
    private ArrayList<String> levels = new ArrayList<>() ;
    private boolean running = true;


    public Beta_Test(){
        game = new Game();

        levels.add( game.getLevels().get(0));
        StartLevel(0);
    }

    public void StartLevel(int i){
        game.Init(levels.get(i)); //több pálya lehetséges
        System.out.println("Input commands:\n" +
                "- Move pX D - to move player. X is the player's number (e.g. p1,p2,etc.) \n" +
                "and D is a Direction (e.g. U, D, L, R for Up Down Left Right\n" +
                "- Put pX Oil/Honey - to put Oil Or Honey with Player X\n" +
                "- List - to List the current map\n" +
                "- Exit - to Exit to main menu\n");

        while(running){
            try {
                InputHandler();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Wrong input.");

            }


        }

    }

    public void Move(int i , Direction d){
        System.out.println(i+""+d);
        game.GetCurrentLevel().getPlayer().get(i-1).Move(d);
    }

    public void List(){
        int h = game.GetCurrentLevel().getTilesH();
        int v = game.GetCurrentLevel().getTilesV();
        for (int i = 0; i<h;i++) {
            for (int j = 0; j < v; j++) {

                System.out.print(game.GetCurrentLevel().tiles[i][j].GetThings().toString());

            }
            System.out.println("\n");
        }
    }

    public void Put(int i, String BeUSA){
        if(BeUSA.equals("Honey"))
            game.GetCurrentLevel().getPlayer().get(i-1).Bee();
        else if(BeUSA.equals("Oil"))
            game.GetCurrentLevel().getPlayer().get(i-1).USA();
        else System.out.println("You're not BEE-ing USA");
    }

    public void InputHandler() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            String str = br.readLine();
            String[] cmd = str.split(" ");
            if(cmd[0].equals("Move")) {

               int num = Integer.parseInt(cmd[1].substring(1));
               if(num>game.GetCurrentLevel().getPlayer().size()) {
                   System.out.println("Wrong input.");
                   return;
               }


                  if(cmd[2].equals("U"))
                        Move(num,Direction.up);

                else if(cmd[2].equals("D"))
                        Move(num, Direction.down);

                else if(cmd[2].equals("L"))
                        Move(num,Direction.left);

                else if(cmd[2].equals("R"))
                       Move(num,Direction.right);
                else
                       System.out.println("Wrong Input");
               }


            else if(cmd[0].equals("List"))
                List();
            else if(cmd[0].equals("Put")){
                int num = Integer.parseInt(cmd[1].substring(1));
                if(num>game.GetCurrentLevel().getPlayer().size()){
                    System.out.println("Wrong input.");
                    return;
                }
                Put(num,cmd[2]);
            }
            else if(cmd[0].equals("Exit"))
                running = false;
            else
                System.out.println("Wrong input.");
    }



}
