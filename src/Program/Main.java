package Program;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends  Application{

    static public void tabolo(int n){

        for (int i =0; i<n; i++)            //Csak a kiírás szépségét segítő függvény
            System.out.print("       ");

        return;
    }
    static public int tabber;

    static public void Menu() throws IOException { // menu megvalositasa

        while (true) {
            System.out.println("Alpha teszt : A\n" +
                    "Beta teszt: B\n" +
                    "Exit: E\n" +
                    "Please enter the right character, then hit Enter.");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int i = 0;
            try {
                i = br.read();

            } catch (NumberFormatException nfe) {
                System.err.println("Invalid Format!");
            }
            char c = (char) i;
            switch (c) {
                case 'A':
                    Alpha_Test.Start();
                    break;
                case 'B':
                    Beta_Test Beta = new Beta_Test();
                    break;

                case 'E':
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Wrong input");
                    return;
            }

        }
    }

    public static void main(String args[]) throws IOException {

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