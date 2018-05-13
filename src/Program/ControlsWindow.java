package Program;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ControlsWindow {

    /**
     * Irányítást leíró ablak.
     */
    public static void display(){
        Stage window= new Stage();
        window.setTitle("Controls");
        window.initModality(Modality.APPLICATION_MODAL);
        String text="";
        Label label= new Label(text);
        Button cancel= new Button("cancel");
        cancel.setOnAction(e -> window.close());

        cancel.setStyle("-fx-background-color: #000000;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: red");

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(150, 150);
        layout.getChildren().addAll(label, cancel);
        layout.setStyle("-fx-background-color: orange;");

        Scene scene= new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
