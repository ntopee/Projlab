package Program;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


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



    public ObservableList<Score> getObsList() {

        Collections.max(hs, new Comparator<Score>() { //TODO
            @Override

            public int compare(Score o1, Score o2) {
                return o1.compareTo(o1,o2);
            }
        });
        ObservableList<Score> obs = FXCollections.observableArrayList();

       for(Score s : hs){
           obs.add(s);

        }


        return obs;
    }





    public static class Score{

        public final SimpleStringProperty name;
        public final SimpleIntegerProperty point;

        public Score(String name, Integer point) {
            this.name = new SimpleStringProperty(name);
            this.point = new SimpleIntegerProperty(point);
        }

        public int compareTo(Score o1, Score o2) {
            if (o1.point.getValue() == o2.point.getValue()) {
                return 0;
            } else if (o1.point.getValue() < o2.point.getValue()) {
                return -1;
            } else {
                return 1;
            }
        }

        public String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public int getPoint() {
            return point.get();
        }

        public SimpleIntegerProperty pointProperty() {
            return point;
        }

        public void setPoint(int point) {
            this.point.set(point);
        }


    }
}