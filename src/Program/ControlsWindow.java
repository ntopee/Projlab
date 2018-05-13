package Program;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ControlsWindow {

    /**
     * Irányítást leíró ablak.
     */
    public static void display() {
        Stage window = new Stage();
        window.setResizable(false);
        window.setTitle("Controls");
        window.initModality(Modality.APPLICATION_MODAL);
        Button cancel = new Button("cancel");
        cancel.setOnAction(e -> window.close());

        cancel.setStyle("-fx-background-color: #000000;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: red");


        TableView<Temp> table = new TableView();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        final Label label = new Label("Munkások irányítása");
        label.setFont(new Font("Arial", 20));

        TableColumn first = new TableColumn("Esemény");
        first.setCellValueFactory(
                new PropertyValueFactory<Temp, String>("event")
        );


        TableColumn pl1 = new TableColumn("Player 1");
        pl1.setCellValueFactory(
                new PropertyValueFactory<Temp, String>("p1")
        );

        TableColumn pl2 = new TableColumn("Player 2");
        pl2.setCellValueFactory(
                new PropertyValueFactory<Temp, String>("p2")
        );

        TableColumn pl3 = new TableColumn("Player 3");
        pl3.setCellValueFactory(
                new PropertyValueFactory<Temp, String>("p3")
        );

        TableColumn pl4 = new TableColumn("Player 4");
        pl4.setCellValueFactory(
                new PropertyValueFactory<Temp, String>("p4")
        );

        TableColumn but = new TableColumn("Aktiváló gomb");

        final ObservableList<Temp> data = FXCollections.observableArrayList(
                new Temp("Fel", "W", "I", "UP", "NUM8"),
                new Temp("Le", "S", "K", "DOWN", "NUM5"),
                new Temp("Jobbra", "D", "L", "RIGHT", "NUM6"),
                new Temp("Balra", "A", "J", "LEFT", "NUM4"),
                new Temp("Méz", "Q", "U", "Shift", "NUM7"),
                new Temp("Olaj", "E", "O", "Ctrl", "NUM9")
        );
        table.setItems(data);

        but.getColumns().addAll(pl1, pl2, pl3, pl4);
        table.getColumns().addAll(first, but);


        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(150, 150);
        layout.setMaxSize(317, 300);
        layout.getChildren().addAll(label, table, cancel);
        layout.setStyle("-fx-background-color: orange;");
        layout.setPadding(new Insets(10,0,10,0));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public static class Temp {
        private final SimpleStringProperty event;
        private final SimpleStringProperty p1;
        private final SimpleStringProperty p2;
        private final SimpleStringProperty p3;
        private final SimpleStringProperty p4;

        public Temp(String e, String p1, String p2, String p3, String p4) {
            event = new SimpleStringProperty(e);
            this.p1 = new SimpleStringProperty(p1);
            this.p2 = new SimpleStringProperty(p2);
            this.p3 = new SimpleStringProperty(p3);
            this.p4 = new SimpleStringProperty(p4);
        }

        public String getEvent() {
            return event.get();
        }

        public SimpleStringProperty eventProperty() {
            return event;
        }

        public void setEvent(String event) {
            this.event.set(event);
        }

        public String getP1() {
            return p1.get();
        }

        public SimpleStringProperty p1Property() {
            return p1;
        }

        public void setP1(String p1) {
            this.p1.set(p1);
        }

        public String getP2() {
            return p2.get();
        }

        public SimpleStringProperty p2Property() {
            return p2;
        }

        public void setP2(String p2) {
            this.p2.set(p2);
        }

        public String getP3() {
            return p3.get();
        }

        public SimpleStringProperty p3Property() {
            return p3;
        }

        public void setP3(String p3) {
            this.p3.set(p3);
        }

        public String getP4() {
            return p4.get();
        }

        public SimpleStringProperty p4Property() {
            return p4;
        }

        public void setP4(String p4) {
            this.p4.set(p4);
        }
    }
}