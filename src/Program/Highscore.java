package Program;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.*;

/**
 * Highscore kezelésére használt osztály
 */
public class Highscore implements Serializable {

    public ArrayList<Score> hs = new ArrayList<>();

    /**
     * Fájlba írás
     */
    public void write() {

        try {
            FileWriter os = new FileWriter("Top.txt",true);
            BufferedWriter bf = new BufferedWriter(os);
            for (int i = 0; i < hs.size(); i++){
                bf.write(toString2(i));
        }
            bf.close();
        } catch(IOException e) {
            e.printStackTrace();
            return;
        }

        hs.clear();

    }

    /**
     * Serializáláshoz használt formátum
     * @param i
     * @return
     */
    public String toString2(int i){
        return hs.get(i).name.getValue() + ","+hs.get(i).point.getValue()+"\r\n";
    }

    public Highscore(){
    }

    public Highscore(java.util.ArrayList<Score> hs) {
        this.hs = hs;
    }

    /**
     * Beolvassa a highscore-t
     */
    public void read() {
    hs.clear();
        try {
            FileReader fileIn = new FileReader( "Top.txt");
            BufferedReader in = new BufferedReader(fileIn);
            String line;

            while ((line = in.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line,",");

                while(st.hasMoreTokens()){
                    String name =st.nextToken();
                    Integer integer = Integer.valueOf(st.nextToken());
                    hs.add(new Score(name,integer));
                }
            }

            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Tableview miatt használt formátum
     * @return
     */
    public ObservableList<Score> getObsList() {
        Collections.sort(hs, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o1.compareTo(o1,o2);
            }
        });
       ObservableList<Score> obs = FXCollections.observableArrayList();
       obs.addAll(hs);

        return obs;
    }


    /**
     * alap score osztály
     */
    public static class Score implements Serializable{

        public final transient SimpleStringProperty name;
        public final transient SimpleIntegerProperty point;

        public Score(String name, Integer point) {
            this.name = new SimpleStringProperty(name);
            this.point = new SimpleIntegerProperty(point);
        }

        public int compareTo(Score o1, Score o2) {
            if (o1.point.getValue() == o2.point.getValue()) {
                return 0;
            } else if (o1.point.getValue() < o2.point.getValue()) {
                return 1;
            } else {
                return -1;
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