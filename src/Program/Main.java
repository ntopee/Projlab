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

/*    private static void elsoTeszt() throws IOException {
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Tile T3 = new Tile(m);
        Player p = new Player();        //Néhány objektum példányosítása a példákhoz.
        Box b = new Box();

        m.tiles.add(T1);
        m.tiles.add(T2);
        m.tiles.add(T3);
        T1.Add(p);
        T2.Add(b);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);
        T2.SetNeighbour(Direction.right,T3);
        T3.SetNeighbour(Direction.left,T2);

        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("Player tol Box");

        //Egy dobozt megtol egy játékos
        System.out.println("? A doboz mozgatható vagy sem? (true/false)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String d = br.readLine();
        if (d.equalsIgnoreCase("true"))
            b.setMovable(true);
        else
            b.setMovable(false);
        p.Move(Direction.right);

        System.out.println("\n----------------------\n");
    }

    private static void masodikTeszt() throws IOException {
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Tile T3 = new Tile(m);
        Box b = new Box();        //Néhány objektum példányosítása a példákhoz.
        Box b2 = new Box();

        m.tiles.add(T1);
        m.tiles.add(T2);
        m.tiles.add(T3);
        T1.Add(b);
        T2.Add(b2);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);
        T2.SetNeighbour(Direction.right,T3);
        T3.SetNeighbour(Direction.left,T2);

        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("Box tol Box\nDobozok nem tudnak maguktol mozogni, ezert egy Player tolja az elso dobozt.");

        System.out.println("? A doboz mozgatható vagy sem? (true/false)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String d = br.readLine();
        b.setMovable(true);
        if (d.equalsIgnoreCase("true"))
            b2.setMovable(true);
        else
            b2.setMovable(false);
        b.HitBy(new Player(),Direction.right,100);

        System.out.println("\n----------------------\n");
    }

    private static void harmadikTeszt() {
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Player p = new Player();       //Néhány objektum példányosítása a példákhoz.
        Wall w = new Wall();

        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(p);
        T2.Add(w);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);

        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("Falnak megy a Player\n" +
                "Mivel jelenlegi specifikáció szerint a Wall és a Pillar viselkedése megegysezik ezért csak az egyik kerül bemutatásra");

        p.Move(Direction.right);

        System.out.println("\n----------------------\n");
    }

    private static void negyedikTeszt(){
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Box b = new Box();        //Néhány objektum példányosítása a példákhoz.
        Wall w = new Wall();

        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(b);
        T2.Add(w);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);

        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("(Box) Dobozt neki lok egy jatekos egy falnak. " +
                "\nA jelenlegi specifikacio szerint a fal es az oszlop ugyan ugy viselkedik, " +
                "\ntehat ez a teszteset lefedi azt is amikor a dobozt egy oszlopnak lokjuk.");
        b.HitBy(new Player(), Direction.right,100);

        System.out.println("\n----------------------\n");
    }

    private static void otodikTeszt() {
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Box b = new Box();        //Néhány objektum példányosítása a példákhoz.
        Goal g = new Goal();

        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(b);
        T2.Add(g);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right, T2);
        T2.SetNeighbour(Direction.left, T1);

        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("(Box) Dobozt neki lok egy jatekos egy celnak. " +
                "\nDobozok nem tudnak maguktol mozogni, ezert egy Player tolja a dobozt," +
                "\nami így a celra er.");
        b.HitBy(new Player(), Direction.right,100);


        System.out.println("\n----------------------\n");

    }

    private static void hatodikTeszt() throws IOException {
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Player p = new Player();       //Néhány objektum példányosítása a példákhoz.
        // Hole h = new Hole();

        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(p);
        //   T2.Add(h);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);



        System.out.println("Player lyukba esik");

        System.out.println("? A lyuk aktív-e (true/false)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String d = br.readLine();
        if (d.equalsIgnoreCase("true"))
        {
            Hole h = new Hole(true);
            T2.Add(h);
        }
        else
        {
            Hole h = new Hole(false);
            T2.Add(h);
        }

        System.out.println("ITT KEZDŐDIK A TESZT");



        p.Move(Direction.right);
    }

    private static void hetedikTeszt() throws IOException {
        System.out.println("Box leesik egy lyukba\n" +
                "(Box) Dobozt nem tud magatol mozogni, ezert egy jatekos tolja bele a lyukba. ");
        System.out.println("? A lyuk aktiv? (true/false)");
        Hole h;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String d = br.readLine();
        if (d.equalsIgnoreCase("true")) {
            h = new Hole(true);
        } else {
            h = new Hole(true);
        }

        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Box b = new Box();       //Néhány objektum példányosítása a példákhoz.


        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(b);
        T2.Add(h);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);

        System.out.println("\nITT KEZDŐDIK A TESZT");

        b.HitBy(new Player(),Direction.right,100);

        System.out.println("\n----------------------\n");
    }

    private static void nyolcadikTeszt(){
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Player p = new Player();    //Néhány objektum példányosítása a példákhoz.
        Player p2 = new Player();

        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(p);
        T2.Add(p2);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);

        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("Player nekimegy egy masik Playernek.");

        p.Move(Direction.right);

        System.out.println("\n----------------------\n");
    }

    private static void kilencedikTeszt(){

        //Néhány objektum példányosítása a példákhoz.
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Tile T3 = new Tile(m);
        Tile T4 = new Tile(m);
        Hole h = new Hole(true);
        Switch s = new Switch(h);

        Box b = new Box();
        Player p = new Player();

        m.tiles.add(T1);
        m.tiles.add(T2);
        m.tiles.add(T3);
        m.tiles.add(T4);
        T1.Add(s);
        T2.Add(b);
        T3.Add(p);
        T4.Add(h);

        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);
        T2.SetNeighbour(Direction.right,T3);
        T3.SetNeighbour(Direction.left,T2);
        T3.SetNeighbour(Direction.right,T4);
        T4.SetNeighbour(Direction.left,T3);



        System.out.println("ITT KEZDŐDIK A TESZT");

        p.Move(Direction.left);
        System.out.println("\n----------------------\n");
    }

    private static void tizedikTeszt(){
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Hole h = new Hole(true);
        Switch s = new Switch(h);

        Player p = new Player();
        m.tiles.add(T1);
        m.tiles.add(T2);

        T1.Add(p);
        T2.Add(s);

        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);


        System.out.println("ITT KEZDŐDIK A TESZT");
        s.HitBy(p, Direction.right, 100);

        System.out.println("\n----------------------\n");
    }

    private static void tizenegyedikTeszt(){
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Player p = new Player();
        Goal g = new Goal();


        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(p);
        T2.Add(g);

        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);

        System.out.println("Player goal-ra lép");
        System.out.println("ITT KEZDŐDIK A TESZT");

        p.Move(Direction.right);
    }

    private static void tizenkettedikTeszt(){
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Player p = new Player();
        Box b = new Box();
        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(p);
        T2.Add(b);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);

        System.out.println("Player HitBy box => a jatekosnak nekitolodik egy doboz." +
                "\nSpecifikacioban ugy fogalmaztuk meg, hogy ha egy playert egy box nekitol egy playernek/boxnak/oszlopnak/falnak," +
                "\nakkor a tolt jatekos meghal." +
                "\nEz a teszteset lefedi mint a 4 variaciot, aminek neki lehet tolni egy playert.");

        System.out.println("ITT KEZDŐDIK A TESZT");
        p.HitBy(new Box(),Direction.right,100);

    }

    private static void tizenharmadikTeszt() {
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Tile T3 = new Tile(m);
        Player p = new Player();        //Néhány objektum példányosítása a példákhoz.
        Box b = new Box();
        Goal g = new Goal();

        m.tiles.add(T1);
        m.tiles.add(T2);
        m.tiles.add(T3);
        T1.Add(p);
        T2.Add(b);
        T3.Add(g);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);
        T2.SetNeighbour(Direction.right,T3);
        T3.SetNeighbour(Direction.left,T2);
        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("Player pontot szerez.");
        System.out.println("Player jelenlegi pontszama: " + p.GetPoints());

        p.Move(Direction.right);
        System.out.println("\nPlayer jelenlegi pontszama: " + p.GetPoints());

        System.out.println("\n----------------------\n");
    }

    public static void Teszt(){
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Tile T3 = new Tile(m);
        Tile T4 = new Tile(m);
        Player p = new Player(25);        //Néhány objektum példányosítása a példákhoz.
        Box b1 = new Box(22);
        Box b2 = new Box(5);
        Wall w = new Wall();

        m.tiles.add(T1);
        m.tiles.add(T2);
        m.tiles.add(T3);
        T1.Add(p);
        T2.Add(b1);
        T3.Add(b2);
        T4.Add(w);

        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);
        T2.SetNeighbour(Direction.right,T3);
        T3.SetNeighbour(Direction.left,T2);
        T3.SetNeighbour(Direction.right,T4);
        T4.SetNeighbour(Direction.left,T3);


        p.Move(Direction.right);
    }


    public static void PlayerBoxBox(){
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Tile T3 = new Tile(m);
        Tile T4 = new Tile(m);

        Player p = new Player(35);        //Néhány objektum példányosítása a példákhoz.
        Box b1 = new Box(22);
        Box b2 = new Box(5);

        m.tiles.add(T1);
        m.tiles.add(T2);
        m.tiles.add(T3);
        m.tiles.add(T4);
        T1.Add(p);
        T2.Add(b1);
        T3.Add(b2);

        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);
        T2.SetNeighbour(Direction.right,T3);
        T3.SetNeighbour(Direction.left,T2);
        T3.SetNeighbour(Direction.right,T4);
        T4.SetNeighbour(Direction.left,T3);

        System.out.println("\n------------------\nSzekvencia\n-------------------\n");
        p.Move(Direction.right);
    }

    public static void PlayerBoxPlayerBox(){
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Tile T3 = new Tile(m);
        Tile T4 = new Tile(m);

        Player p1 = new Player(35);
        Player p2 = new Player(35);        //Néhány objektum példányosítása a példákhoz.
        Box b1 = new Box(22);
        Box b2 = new Box(5);

        m.tiles.add(T1);
        m.tiles.add(T2);
        m.tiles.add(T3);
        m.tiles.add(T4);
        T1.Add(p1);
        T2.Add(b1);
        T3.Add(p2);
        T4.Add(b2);

        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);
        T2.SetNeighbour(Direction.right,T3);
        T3.SetNeighbour(Direction.left,T2);
        T3.SetNeighbour(Direction.right,T4);
        T4.SetNeighbour(Direction.left,T3);

        System.out.println("\n------------------\nSzekvencia\n-------------------\n");
        p1.Move(Direction.right);
    }
*/
    public static void main(String args[]) throws IOException {

   launch(args);
        Menu(); //menu elinditasa
      //  Alpha_Test.Start();

        //Teszt();

        //PlayerBoxBox();

       // PlayerBoxPlayerBox();
       /* Map m = new Map(1,2);
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);

        Player p = new Player(22);
        Hole h = new Hole(true);

        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);

        m.tiles[0][0] = T1;
        m.tiles[0][1] = T2;
        T1.Add(p);
        T2.Add(h);

        System.out.println("\n------------------\nSzekvencia\n-------------------\n");
        p.Move(Direction.right);*/

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        primaryStage.setTitle("Killer Sokoban by S20ftv3r_Pr0j3kt_M@st3r2");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}