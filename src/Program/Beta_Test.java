package Program;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beta_Test {


    private static Game game;
    private static boolean running = true;


    public Beta_Test(){
        game = new Game();
    }

    private static void StartLevel(){
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

    private static void Move(int i, Direction d){ //A megfelelo playert a megfelelo iranyba elmozditja
        System.out.println(i+""+d);
        game.GetCurrentLevel().getPlayer().get(i-1).Move(d);
    }

    private static void List(){ //kiirja a palya jelenlegi allasat
        int h = game.GetCurrentLevel().getTilesH();
        int v = game.GetCurrentLevel().getTilesV();
        for (int i = 0; i<h;i++) {
            for (int j = 0; j < v; j++) {

                System.out.print(game.GetCurrentLevel().tiles[i][j].GetThings().toString());

            }
            System.out.println("\n");
        }
    }

    private static void Put(int i, String BeUSA){ //mezet vagy olajat rak a player tile-jara
        if(BeUSA.equals("Honey"))
            game.GetCurrentLevel().getPlayer().get(i-1).Bee();
        else if(BeUSA.equals("Oil"))
            game.GetCurrentLevel().getPlayer().get(i-1).USA();
        else System.out.println("You're not BEE-ing USA");
    }

    private static void InputHandler() throws IOException { //a konzolon bejovo commandokra csinal valamit
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

    public static void Start(Scene scene, String level, BorderPane pane){
        game = new Game();
        game.Init(level);
        initDraw(scene, pane);
    }

    private static void initDraw(Scene scene, BorderPane pane){

        Canvas canvas= new Canvas();
        pane.setCenter(canvas);
        Button back5 = new Button("Back");
        pane.setTop(back5);

        game.setMapCanvas(canvas);
        game.GetCurrentLevel().DrawAll();
        //Back button vissza a menube
        back5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent hs = null;
                try {
                   hs = FXMLLoader.load(getClass().getResource("start.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(hs);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(scene);
                window.show();
            }
        });

        //gomblenyomások eventkezelője
        //TODO gombra konkrét függvényt hív, hogy player elmozduljon
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if(event.getCode()== KeyCode.A) {
                    Move(1,Direction.left);
                    game.GetCurrentLevel().DrawAll();
                    List();
                }
                else if(event.getCode()== KeyCode.W) {
                    Move(1,Direction.up);
                    game.GetCurrentLevel().DrawAll();
                    List();
                }
                else if(event.getCode()== KeyCode.S) {
                    Move(1,Direction.down);
                    game.GetCurrentLevel().DrawAll();
                    List();
                }
                else if(event.getCode()== KeyCode.D) {
                    Move(1,Direction.right);
                    game.GetCurrentLevel().DrawAll();
                    List();
                }
            }
        });


    }



}
