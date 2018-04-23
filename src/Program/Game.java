package Program;
import java.io.*;
import java.util.*;

import static Program.Direction.*;
import static Program.Main.tabber;
import static Program.Main.tabolo;

/**
 * A játékot reprezentálja, mapeket tölt be.
 */
public class Game {

    private ArrayList<String> levels = new ArrayList<>();
    private int currentLvl = 0;
    /**
     * Default constructor
     */
    public Game() {

        //todo beolvasni a fileneveket

        levels.add("Map.txt");

    }




    /**
     * Az osztály eltárolja a játékban fellelhető szinteket.
     */
   // private Set<Map> levels;   // List? #Bende

    /**
     * A jelenlegi pályának egy referenciáját tárolja el, arra jó,
     * hogy mindig tudjuk, melyik pálya van most “használatban”.
     */
    private Map currentlevel;


    /**
     * Betölti a megfelelő pályát a játékba.
     */
    public void Init(String filename) {
        System.out.println("> Init");
        // TODO implement here

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int sdb = Integer.parseInt(br.readLine());
            ArrayList<Switch> swk= new ArrayList<>();
            for (int i = 0; i< sdb;i++)
            {
                Switch s = new Switch();
                swk.add(s);
            }
            currentlevel = new Map(N+2,M+2);

            for (int i = 0; i<=N+1; i++)
                for (int j=0 ; j<=M+1;j++)
                {
                    currentlevel.tiles[i][j]=new Tile(currentlevel);


                }

            //currentlevel.tiles[N+2][0].SetNeighbour(up,currentlevel.tiles[N+1][0]);
            //currentlevel.tiles[0][M+2].SetNeighbour(left,currentlevel.tiles[0][M+1]);
            for (int i = 0; i<=N+1;i++)
            {
                currentlevel.tiles[i][0].SetNeighbour(right,currentlevel.tiles[i][1]);
                currentlevel.tiles[i][M+1].SetNeighbour(left,currentlevel.tiles[i][M+1]);
            }

            for (int i = 0; i<=M+1;i++)
            {
                currentlevel.tiles[0][i].SetNeighbour(down,currentlevel.tiles[1][i]);
                currentlevel.tiles[N+1][i].SetNeighbour(up,currentlevel.tiles[N+1][i]);
            }

            for (int i = 1;i<=N;i++)
                for (int j= 1; j<=M;j++)
                {
                    currentlevel.tiles[i][j].SetNeighbour(left,currentlevel.tiles[i][j-1]);
                    currentlevel.tiles[i][j].SetNeighbour(right,currentlevel.tiles[i][j+1]);
                    currentlevel.tiles[i][j].SetNeighbour(up,currentlevel.tiles[i-1][j]);
                    currentlevel.tiles[i][j].SetNeighbour(down,currentlevel.tiles[i+1][j]);
                }

            for (int i = 0; i<=N+1; i++)
                for (int j=0 ; j<=M+1;j++)
                {
                    int seg;
                    seg = br.read();
                    char c = (char) seg;
                    switch (c){
                        case 'P':
                            Player p = new Player();
                            currentlevel.tiles[i][j].Add(p);
                            seg = br.read();
                            currentlevel.AddPlayer(p,seg);

                            break;
                        case 'B':
                            currentlevel.tiles[i][j].Add(new Box());
                            break;

                        case 'O':
                            currentlevel.tiles[i][j].Add(new Pillar());
                            break;
                        case '#':
                            currentlevel.tiles[i][j].Add(new Wall());
                            break;
                        case 'G':
                            currentlevel.tiles[i][j].Add(new Goal());
                            break;
                        case 'S':
                            int indx = br.read() ;
                            System.out.println(indx);
                            System.out.println(seg);
                            currentlevel.tiles[i][j].Add(swk.get(indx));
                            break;
                        case 'T':
                            seg = br.read();
                            Hole h = new Hole(false);
                            currentlevel.tiles[i][j].Add(h);
                            swk.get(seg).Add(h);
                            break;
                        case 'H':
                            currentlevel.tiles[i][j].Add(new Hole(true));
                            break;


                    }

                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //filename.betolt

        /**
         * filename alapjan betolti a palyat
         */

        System.out.println("< Init");
    }

    /**
     * Megállítja a játékot (mivel vége van),
     * és kiírja a játékos(ok) pontszámát,
     * és ez alapján a nyertest is “kihirdeti”.
     */
    public static void EndGame() {
        tabber++;
        tabolo(tabber);
        System.out.println("> EndGame");
        // TODO implement here
        /**
         * kiirja a kepernyore hogy vege van, aztan kidob menube
         */

        tabolo(tabber);
        tabber--;
        System.out.println("< EndGame");
    }

    /**
     * Beállítja a soron következő pályát,
     * és meghívja az init() függvényt.
     */
    public void NextLevel() {
        System.out.println("> NextLevel");
        // TODO implement here

        if (currentLvl != levels.size())
            currentLvl++;
        else
            currentLvl=0;

        Init(levels.get(currentLvl));
        /**
         * meghiv egy initet a kovi levellel
         */

        System.out.println("< NextLevel");
    }

    /**
     * Újraindítja az aktuális pályát.
     */
    public void RestartLevel() {
        System.out.println("> RestartLevel");
        // TODO implement here

        Init(levels.get(currentLvl));
        /**
         * meghivja az initet ugyanazzal a filename-el
         */
        System.out.println("< RestartLevel");
    }

    /**
     * Egy adott iránynak megadja a vele ellenkező irányt.
     * @param d Direction, irány.
     * @return
     */
    static Direction GetOpposite(Direction d){
        switch (d) {
            case up:
                return down;
            case down:
                return up;
            case left:
                return right;
            case right:
                return left;
            default:
                return d;
        }
    }

    public ArrayList<String> getLevels() {
        return levels;
    }

    public Map GetCurrentLevel(){
        return currentlevel;
    }
}