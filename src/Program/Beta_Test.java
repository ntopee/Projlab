package Program;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beta_Test {


    private static Game game;

    public Beta_Test(){
        game = new Game();
    }

    private static void Move(int i, Direction d){ //A megfelelo playert a megfelelo iranyba elmozditja
        System.out.println(i+""+d);
        if (game.GetCurrentLevel().getPlayer().indexOf(game.GetCurrentLevel().getPlayersController().get(i-1)) != -1)
        game.GetCurrentLevel().getPlayersController().get(i-1).Move(d);
    }

    private static void Put(int i, String BeUSA){ //mezet vagy olajat rak a player tile-jara
        if(BeUSA.equals("Honey")){
            if (game.GetCurrentLevel().getPlayer().indexOf(game.GetCurrentLevel().getPlayersController().get(i-1)) != -1)
                game.GetCurrentLevel().getPlayersController().get(i-1).Bee();
        }
        else if(BeUSA.equals("Oil")) {
                if (game.GetCurrentLevel().getPlayer().indexOf(game.GetCurrentLevel().getPlayersController().get(i-1)) != -1)
                    game.GetCurrentLevel().getPlayersController().get(i-1).USA();
        }
        else System.out.println("You're not BEE-ing USA");
    }

    public static void Start(Scene scene, String level, BorderPane pane){
        game = new Game();
        game.Init(level);
        initDraw(scene, pane);
    }

    static SimpleIntegerProperty po1=new SimpleIntegerProperty(0);
    static SimpleIntegerProperty po2=new SimpleIntegerProperty(0);
    static SimpleIntegerProperty po3=new SimpleIntegerProperty(0);
    static SimpleIntegerProperty po4=new SimpleIntegerProperty(0);
    static void DrawPoints(){
        int i=game.GetCurrentLevel().getPlayersController().size();
        if(0<i)po1.setValue(game.GetCurrentLevel().getPlayersController().get(0).GetPoints());
        if(1<i)po2.setValue(game.GetCurrentLevel().getPlayersController().get(1).GetPoints());
        if(2<i)po3.setValue(game.GetCurrentLevel().getPlayersController().get(2).GetPoints());
        if(3<i)po4.setValue(game.GetCurrentLevel().getPlayersController().get(3).GetPoints());
    }


    private static void topDraw(Scene scene, BorderPane pane){
        //allapotsav
        Button back5 = new Button("Back");
        HBox hb= new HBox();
        hb.setPadding(new Insets(15, 12, 15, 12));
        hb.setSpacing(50);
        hb.setStyle("-fx-background-color: #f78257;");

        VBox vbleft= new VBox();
        VBox vbright=new VBox();



        //pontok
        HBox p1h=new HBox();
        Label p1 = new Label("Player 1: ");
        Label p1points= new Label("0");
        p1h.getChildren().addAll(p1, p1points);
        p1points.textProperty().bind(po1.asString());

        HBox p2h=new HBox();
        Label p2 = new Label("Player 2: ");
        Label p2points= new Label("0");
        p2h.getChildren().addAll(p2, p2points);
        p2points.textProperty().bind(po2.asString());

        HBox p3h=new HBox();
        Label p3 = new Label("Player 3: ");
        Label p3points= new Label("0");
        p3h.getChildren().addAll(p3, p3points);
        p3points.textProperty().bind(po3.asString());

        HBox p4h=new HBox();
        Label p4 = new Label("Player 4: ");
        Label p4points= new Label("0");
        p4h.getChildren().addAll(p4, p4points);
        p4points.textProperty().bind(po4.asString());


        vbleft.getChildren().addAll(p1h, p2h);
        vbright.getChildren().addAll(p3h, p4h);

        hb.getChildren().addAll(vbleft, back5, vbright);
        pane.setTop(hb);

        //Back button vissza a menube
        back5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Game.setEndGame(false);
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

    }

    private static void initDraw(Scene scene, BorderPane pane){

        Canvas canvas= new Canvas();
        pane.setCenter(canvas);

        topDraw(scene, pane);
        game.setMapCanvas(canvas);
        game.GetCurrentLevel().DrawAll();

        game.GetCurrentLevel().DrawAll();
        //gomblenyomások eventkezelője
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if(Game.isEndGame())return;
                Beta_Test.DrawPoints();
                if(event.getCode()== KeyCode.A) {
                    Move(1,Direction.left);
                    game.GetCurrentLevel().DrawAll();

                }
                else if(event.getCode()== KeyCode.W ) {
                    Move(1,Direction.up);
                    game.GetCurrentLevel().DrawAll();

                }
                else if(event.getCode()== KeyCode.S ) {
                    Move(1,Direction.down);
                    game.GetCurrentLevel().DrawAll();

                }
                else if(event.getCode()== KeyCode.D ) {
                    Move(1,Direction.right);
                    game.GetCurrentLevel().DrawAll();

                }
                else if(event.getCode()== KeyCode.Q ) {
                    Put(1, "Honey");
                    game.GetCurrentLevel().DrawAll();

                }
                else if(event.getCode()== KeyCode.E ) {
                    Put(1, "Oil");
                    game.GetCurrentLevel().DrawAll();

                }

                if(event.getCode()== KeyCode.J) {
                    Move(2,Direction.left);
                    game.GetCurrentLevel().DrawAll();

                }
                else if(event.getCode()== KeyCode.I ) {
                    Move(2,Direction.up);
                    game.GetCurrentLevel().DrawAll();

                }
                else if(event.getCode()== KeyCode.K ) {
                    Move(2,Direction.down);
                    game.GetCurrentLevel().DrawAll();

                }
                else if(event.getCode()== KeyCode.L ) {
                    Move(2,Direction.right);
                    game.GetCurrentLevel().DrawAll();

                }
                else if(event.getCode()== KeyCode.U ) {
                    Put(2, "Honey");
                    game.GetCurrentLevel().DrawAll();

                }
                else if(event.getCode()== KeyCode.O ) {
                    Put(2, "Oil");
                    game.GetCurrentLevel().DrawAll();

                }

                if(Game.isEndGame())
                {
                    game.GetCurrentLevel().drawEndGame(game.GetCurrentLevel().getCanvas());
                }


            }
        });



    }



    /*private static void InputHandler() throws IOException { //a konzolon bejovo commandokra csinal valamit
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
    }*/


    /*private static void List(){ //kiirja a palya jelenlegi allasat
        int h = game.GetCurrentLevel().getTilesH();
        int v = game.GetCurrentLevel().getTilesV();
        for (int i = 0; i<h;i++) {
            for (int j = 0; j < v; j++) {

                System.out.print(game.GetCurrentLevel().tiles[i][j].GetThings().toString());

            }
            System.out.println("\n");
        }
    }*/

    /*private static void StartLevel(){
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

    }*/
}
