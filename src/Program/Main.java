package Program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends  Application{

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        primaryStage.setTitle("Killer Sokoban by S20ftv3r_Pr0j3kt_M@st3r2");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


}