package Program;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Beta_Test {


    private static Game game;

    public Beta_Test(){
        game = new Game();
    }

    private static void Move(int i, Direction d){ //A megfelelo playert a megfelelo iranyba elmozditja
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
        back5.setStyle("-fx-background-color: #000000;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: red");
        Button control=new Button("Controls");
        control.setStyle("-fx-background-color: #000000;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: red");
        VBox buttonbox=new VBox();
        buttonbox.setStyle("-fx-alignment: center, center;-fx-spacing: 10,10;");


        buttonbox.getChildren().addAll(control, back5);

        HBox hb= new HBox();
        hb.setPadding(new Insets(15, 12, 15, 12));
        hb.setSpacing(50);
        hb.setStyle("-fx-font-size: 15; -fx-background-color: #f78257; -fx-font-weight: bold;");

        Region reg1=new Region();
        Region reg2=new Region();


        VBox vbleft= new VBox();
        VBox vbright=new VBox();
        vbleft.setSpacing(10);
        vbleft.setPadding(new Insets(10,10,10,15));
        vbright.setSpacing(10);
        vbright.setPadding(new Insets(10,15,10,10));
        vbleft.setAlignment(Pos.TOP_LEFT);
        vbright.setAlignment((Pos.TOP_RIGHT));


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

        hb.getChildren().addAll(vbleft,reg1,  buttonbox, reg2, vbright);
        HBox.setHgrow(reg1, Priority.ALWAYS);
        HBox.setHgrow(reg2, Priority.ALWAYS);
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

        control.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ControlsWindow.display();
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
                if (game.GetCurrentLevel().getPlayersController().size()>1)
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

                if (game.GetCurrentLevel().getPlayersController().size()>2)
                    if(event.getCode()== KeyCode.LEFT) {
                        Move(3,Direction.left);
                        game.GetCurrentLevel().DrawAll();

                    }
                    else if(event.getCode()== KeyCode.UP ) {
                        Move(3,Direction.up);
                        game.GetCurrentLevel().DrawAll();

                    }
                    else if(event.getCode()== KeyCode.DOWN ) {
                        Move(3,Direction.down);
                        game.GetCurrentLevel().DrawAll();

                    }
                    else if(event.getCode()== KeyCode.RIGHT ) {
                        Move(3,Direction.right);
                        game.GetCurrentLevel().DrawAll();

                    }
                    else if(event.getCode()== KeyCode.SHIFT ) {
                        Put(3, "Honey");
                        game.GetCurrentLevel().DrawAll();

                    }
                    else if(event.getCode()== KeyCode.CONTROL ) {
                        Put(3, "Oil");
                        game.GetCurrentLevel().DrawAll();

                    }

                if (game.GetCurrentLevel().getPlayersController().size()>3)
                    if(event.getCode()== KeyCode.NUMPAD4) {
                        Move(4,Direction.left);
                        game.GetCurrentLevel().DrawAll();

                    }
                    else if(event.getCode()== KeyCode.NUMPAD8 ) {
                        Move(4,Direction.up);
                        game.GetCurrentLevel().DrawAll();

                    }
                    else if(event.getCode()== KeyCode.NUMPAD5 ) {
                        Move(4,Direction.down);
                        game.GetCurrentLevel().DrawAll();

                    }
                    else if(event.getCode()== KeyCode.NUMPAD6 ) {
                        Move(4,Direction.right);
                        game.GetCurrentLevel().DrawAll();

                    }
                    else if(event.getCode()== KeyCode.NUMPAD7 ) {
                        Put(4, "Honey");
                        game.GetCurrentLevel().DrawAll();

                    }
                    else if(event.getCode()== KeyCode.NUMPAD9 ) {
                        Put(4, "Oil");
                        game.GetCurrentLevel().DrawAll();

                    }

                Beta_Test.DrawPoints();
                if(Game.isEndGame())
                {
                    game.GetCurrentLevel().drawEndGame(game.GetCurrentLevel().getCanvas());
                }


            }
        });

    }

}
