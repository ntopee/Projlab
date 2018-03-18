package Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void  elsoTeszt() throws IOException {
        Map m = new Map();
        Tile T1 = new Tile();
        Tile T2 = new Tile();
        Tile T3 = new Tile();
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

    public static void masodikTeszt() throws IOException
    {
        Map m = new Map();
        Tile T1 = new Tile();
        Tile T2 = new Tile();
        Tile T3 = new Tile();
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
        b.HitBy(new Player(),Direction.right);
    }


    public static void negyedikTeszt(){
        Map m = new Map();
        Tile T1 = new Tile();
        Tile T2 = new Tile();
        Box b = new Box();        //Néhány objektum példányosítása a példákhoz.
        Wall w = new Wall();

        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(b);
        T2.Add(w);

        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);
        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("(Box) Dobozt neki lok egy jatekos egy fallnak. " +
                "\nA jelenlegi specifikacio szerint a fal es az oszlop ugyan ugy viselkedik, " +
                "\ntehat ez a teszteset lefedi azt is amikor a dobozt egy oszlopnak lokjuk.");
        b.HitBy(new Player(), Direction.right);
    }

    public static void main(String args[]) throws IOException{
        //Itt majd lesz egy menu amiben ki lehet valasztani a tesztesetet.
        System.out.println("Elso teszt: \n");
        elsoTeszt();
        masodikTeszt();
        negyedikTeszt();
    }
}