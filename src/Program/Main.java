package Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void tabolo(int n){

        for (int i =0; i<n; i++)            //Csak a kiírás szépségét segítő függvény
            System.out.print("       ");

        return;
    }
    static public int tabber;

    private static void elsoTeszt() throws IOException {
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

    public static void main(String args[]) throws IOException {
        //menü amiből ki lehet választani a teszeseteket
        while (true) {
            System.out.println("Valassz tesztet: 1 2 3 4 5 6 7 8 9 10 11 12 13, kilepeshez -1 majd nyomj entert");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int i = 0;
            try {
                i = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid Format!");
            }

            switch (i) {
                case 1:
                    elsoTeszt();
                    break;
                case 2:
                    masodikTeszt();
                    break;
                case 3:
                    harmadikTeszt();
                    break;
                case 4:
                    negyedikTeszt();
                    break;
                case 5:
                    otodikTeszt();
                    break;
                case 6:
                    hatodikTeszt();
                    break;
                case 7:
                    hetedikTeszt();
                    break;
                case 8:
                    nyolcadikTeszt();
                    break;
                case 9:
                    kilencedikTeszt();
                    break;
                case 10:
                    tizedikTeszt();
                    break;
                case 11:
                    tizenegyedikTeszt();
                    break;
                case 12:
                    tizenkettedikTeszt();
                    break;
                case 13:
                    tizenharmadikTeszt();
                    break;
                 case -1:
                     System.out.println("Kilepes");
                     return;
                default:
                    System.out.println("Hibas input");
                    return;
            }
        }
    }
}