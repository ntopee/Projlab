package Program;

import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;

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
        game.GetCurrentLevel().getPlayer().get(i-1).Move(d);
    }

    public void List(){
        int v = game.GetCurrentLevel().getTilesV();
        int h = game.GetCurrentLevel().getTilesH();
        for (int i = 0; i<=v-1;i++)
            for (int j= 0; j<=h-1;j++)
            {
                //System.out.println(v+" "+h);
                game.GetCurrentLevel().tiles[i][j].GetThings().toString();

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
               if(num>=game.GetCurrentLevel().getPlayer().size()) return;
               char dir ;
               dir = cmd[2].charAt(0);
               switch (dir){
                   case 'U':
                        Move(num,Direction.up);
                         break;
                   case 'D':
                        Move(num, Direction.down);
                        break;
                   case 'L':
                        Move(num,Direction.left);
                        break;
                   case 'R':
                       Move(num,Direction.right);
                        break;
                   default:
                       System.out.println("Wrong Input");
               }

            }
            else if(cmd[0].equals("List"))
                List();
            else if(cmd[0].equals("Put")){
                int num = Integer.parseInt(cmd[1].substring(1));
                if(num>=game.GetCurrentLevel().getPlayer().size()) return;
                Put(num,cmd[2]);
            }
            else if(cmd[0].equals("Exit"))
                running = false;
            else
                System.out.println("Wrong input.");
    }



}
