package Program;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;



public class Highscore {

    public ArrayList<Score> hs = new ArrayList<>();


    public void write(ArrayList<Score> list) {
        try {
            FileOutputStream fileOut = new FileOutputStream( "TOP.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved");
        } catch (IOException i) {
            i.printStackTrace();
        }


    }

    public Highscore(){}
    public Highscore(java.util.ArrayList<Score> hs) {
        this.hs = hs;
    }

    public ArrayList<Score> read() {
        ArrayList<Score> list = new ArrayList<Score>();
        try {
            FileInputStream fileIn = new FileInputStream( "TOP.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list = (ArrayList<Score>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static class Score {

        public final SimpleStringProperty name;
        public final SimpleIntegerProperty point;

        public Score(String name, Integer point) {
            this.name = new SimpleStringProperty(name);
            this.point = new SimpleIntegerProperty(point);
        }
    }
}