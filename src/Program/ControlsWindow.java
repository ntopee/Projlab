package Program;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class creates a window that tells the player that he/she lost/won.
 * Cant use main window until this window is open.
 * After closing, the main window returns to the menu.
 */
public class ControlsWindow {

    /**
     * This method creates the window.
     * @param text Text of the window.
     */
    public static void display(String text){
        Stage window= new Stage();
        window.setTitle("Game over");
        window.initModality(Modality.APPLICATION_MODAL);

        Label label= new Label(text);
        label.setStyle("Menu:label");
        Button cancel= new Button("cancel");
        cancel.setOnAction(e -> window.close());

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(150, 150);
        layout.getChildren().addAll(label, cancel);

        Scene scene= new Scene(layout);
        label.setStyle("Menu:label");
        window.setScene(scene);
        window.showAndWait();
    }
}
