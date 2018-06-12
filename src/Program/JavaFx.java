package Program;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import java.io.IOException;
/**
 * gyakorlatilag a teljes menürendszer kezelése

 */
public class JavaFx {

    /**
     * Kilépés gomb
     * @param event
     */
    public void press_btn_exit(ActionEvent event){
        System.exit(0);
    }

    /**
     * Egy előugró ablakba kirajzolja a highscore-t
     * @param event
     * @throws IOException
     */
    public void press_btn_highscore(ActionEvent event) throws IOException {


        Game.getHighscore2().read();
        Stage window = new Stage();


        window.setTitle("Highscore ");
        window.initModality(Modality.APPLICATION_MODAL);



        TableColumn<Highscore, String> namecolumn= new TableColumn<>("Name");
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        namecolumn.setMinWidth(250);

        TableColumn<Highscore, Integer> scorecolumn = new TableColumn<>("Point");
        scorecolumn.setCellValueFactory(new PropertyValueFactory<>("point"));

        TableView table= new TableView<>();


        table.setItems(Game.getHighscore());
        table.getColumns().addAll(namecolumn, scorecolumn);

        VBox layout = new VBox();
        layout.getChildren().add(table);

        Scene scene= new Scene(layout, 300, 270);
        window.setScene(scene);
        window.showAndWait();

    }

    /**
     * Vissza a menübe
     * @param event
     * @throws IOException
     */
    public void press_btn_back(ActionEvent event) throws IOException {

        Parent hs = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(hs);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    /**
     * Play gomb, a pályaválasztóhoz irányít
     * @param event
     * @throws IOException
     */
    public void press_btn_play(ActionEvent event) throws IOException{
        Parent hs = FXMLLoader.load(getClass().getResource("SelectScene.fxml"));
        Scene scene = new Scene(hs);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }

    /**
     * Pályaválasztó
     * @param event
     * @throws IOException
     */
    public void press_image(MouseEvent event) {
        System.out.println(event.getPickResult().getIntersectedNode().getId());
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane);

        String filename="level1.txt";
        switch(event.getPickResult().getIntersectedNode().getId()){
            case("iv2"):
                filename="level2.txt";
                break;
            case("iv3"):
                filename="level3.txt";
                break;
            case("iv4"):
                filename="level4.txt";
                break;
            case("iv5"):
                filename="level5.txt";
                break;
            case("iv6"):
                filename="level6.txt";
                break;
            case("iv7"):
                filename="level7.txt";
                break;
            case("iv8"):
                filename="level8.txt";
                break;
            case("iv9"):
                filename="level9.txt";
                break;
            default:
                break;
        }

        Beta_Test.Start(scene, filename, pane);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        }

}
