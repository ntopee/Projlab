package Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Alpha_Test {

    private static void Add(String str){
        String [] parameters = str.split(" ");
        if (parameters.length > 1){
            for (String s :
                    parameters) {
                if (s.equals("Wall"))
                    tile.Add(new Wall());
                if (s.equals("Pillar"))
                    tile.Add(new Pillar());
                if (s.equals("Player"))
                    tile.Add(new Player());
                if (s.equals("Box"))
                    tile.Add(new Box());
                if (s.equals("Goal"))
                    tile.Add(new Goal());
                if (s.equals("Oil"))
                    tile.SetOil(0.55);
                if (s.equals("Honey"))
                    tile.SetHoney(1.45);

                if (s.contains("Hole")){
                    if (s.length() > 4) {
                        int i = Integer.parseInt(s.substring(4, s.length()));
                        Hole hole = new Hole(false);
                        for (Tile t :
                                tiles) {
                            for (Thing thing :
                                    t.GetThings()) {
                                if (thing instanceof Switch)
                                    if (((Switch) thing).getID() == i)
                                        ((Switch) thing).Add(hole);
                            }
                        }
                        tile.Add(hole);
                    }else
                        tile.Add(new Hole(true));

                }


                if (s.contains("Switch")){
                    tile.Add(new Switch(Integer.parseInt(s.substring(6, s.length()))));
                }


            }

        }
            Tile tmp = new Tile(map);
            tile.SetNeighbour(Direction.right,tmp);
            tmp.SetNeighbour(Direction.left,tile);
            tiles.add(tmp);
            tile = tmp;

    }

    private static void Move(){
        p.Move(Direction.right);
    }

    private static void Put(String str){
        String [] parameters = str.split(" ");
        if (parameters.length > 1) {
            if (parameters[1].equals("Honey")) {
                p.Bee();
                return;
            }
            if (parameters[1].equals("Oil")) {
                p.USA();
                return;
            }
        }
        System.out.println("Wrong parameter");
    }

    private static void List(){
        for (Tile t :
                tiles) {
            System.out.print("| ");
            for (Thing thing :
                    t.GetThings()) {
                System.out.print(thing.toString() + " ");
            }
            if (t.GetHoney() != 1)
                System.out.print("Honey ");
            if (t.GetOil() != 1)
                System.out.print("Oil ");
        }
        System.out.println();
    }

    private static ArrayList<Tile> tiles;

    private static Tile tile;

    private static Player p;

    private static Map map;

    static public void Start() throws IOException {
        map = new Map(1,300);
        tiles = new ArrayList<>();
        p = new Player(100);

        map.AddPlayer(p,0);

        Tile T1 = new Tile(map);

        T1.Add(p);
        tiles.add(T1);

        tile = new Tile(map);
        tiles.add(tile);
        T1.SetNeighbour(Direction.right,tile);
        tile.SetNeighbour(Direction.left,T1);

        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            if (str.equals("List"))
                List();
            if (str.equals("Move"))
                Move();
            if (str.split(" ")[0].equals("Add"))
                Add(str);
            if (str.split(" ")[0].equals("Put"))
                Put(str);
            if (str.equals("Back"))
                return;
            if (map.getPlayer().size() == 0){
                List();
                System.out.println("Meghalt a játékos.");
                return;
            }
        }
    }

}
