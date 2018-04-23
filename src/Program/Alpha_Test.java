package Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Alpha_Test {

    private static void Add(String str){}

    private static void Move(){}

    private static void Put(String str){}

    private static void List(){}

    private static ArrayList<Tile> tiles;

    private static Player p;

    static public void Start() throws IOException {

        tiles = new ArrayList<>();
        p = new Player();

        Tile T1 = new Tile();

        T1.Add(p);
        tiles.add(T1);

        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            if (str.equals("List"))
                List();
            if (str.equals("Move"))
                Move();
            if (str.split(" ")[0].equals("ADD"))
                Add(str);
            if (str.split(" ")[0].equals("Put"))
                Put(str);
            if (str.equals("Back"))
                return;
        }
    }


}
