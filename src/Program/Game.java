package Program;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;

import javax.swing.*;
import java.io.*;
import java.util.*;

import static Program.Direction.*;

/**
 * A játékot reprezentálja, mapeket tölt be.
 */
public class Game {

    private static Highscore highscore =new Highscore();
    private static int magicCounter=0;
    private ArrayList<String> levels = new ArrayList<>();
    private int currentLvl = 0;

    private static boolean endGame = false;
    /**
     * Default constructor
     */
    public Game() {

        //todo beolvasni a fileneveket

        levels.add("level1.txt");
        levels.add("level2.txt");
    }

    public static int TILE_SIZE = 50;


    /**
     * Az osztály eltárolja a játékban fellelhető szinteket.
     */
   // private Set<Map> levels;   // List? #Bende

    /**
     * A jelenlegi pályának egy referenciáját tárolja el, arra jó,
     * hogy mindig tudjuk, melyik pálya van most “használatban”.
     */
    private static Map currentlevel;

    /**
     * Megállítja a játékot (mivel vége van),
     * és kiírja a játékos(ok) pontszámát,
     * és ez alapján a nyertest is “kihirdeti”.
     */
    public static void EndGame() {
        if (magicCounter == 0) {
            /**
             * kiirja a kepernyore hogy vege van, aztan kidob menube
             */
            endGame = true;

            for (Player p :
                    currentlevel.getPlayer()) {

                currentlevel.getPlayersController().get(currentlevel.getPlayersController().indexOf(p)).SetPoints(p.GetPoints());
            }
            System.out.println("Game Over");

            //adatbekérés highscorehoz
            for (Player p :
                    currentlevel.getPlayersController()) {
                String name = JOptionPane.showInputDialog("What's your name?");
                Highscore.Score score = new Highscore.Score(name, p.GetPoints());
                highscore.hs.add(score);
            }

            highscore.write();
            magicCounter++;
        }
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

    public Map GetCurrentLevel(){
        return currentlevel;
    }

    public void setMapCanvas(Canvas canvas){
        currentlevel.setCanvas(canvas);
    }

    public static void setEndGame(boolean b){ endGame = b; }

    public static boolean isEndGame() {
        return endGame;
    }

    /**
     * Betölti a megfelelő pályát a játékba.
     */

    public void Init(String filename) {
    magicCounter =0;
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


            for (int i = 0; i<=N+1;i++)
            {
                currentlevel.tiles[i][0].SetNeighbour(right,currentlevel.tiles[i][1]);
                currentlevel.tiles[i][M+1].SetNeighbour(left,currentlevel.tiles[i][M]);
            }

            for (int i = 0; i<=M+1;i++)
            {
                currentlevel.tiles[0][i].SetNeighbour(down,currentlevel.tiles[1][i]);
                currentlevel.tiles[N+1][i].SetNeighbour(up,currentlevel.tiles[N][i]);
            }

            for (int i = 1;i<=N;i++)
                for (int j= 1; j<=M;j++)
                {
                    currentlevel.tiles[i][j].SetNeighbour(left,currentlevel.tiles[i][j-1]);
                    currentlevel.tiles[i][j].SetNeighbour(right,currentlevel.tiles[i][j+1]);
                    currentlevel.tiles[i][j].SetNeighbour(up,currentlevel.tiles[i-1][j]);
                    currentlevel.tiles[i][j].SetNeighbour(down,currentlevel.tiles[i+1][j]);
                }



            int cycle = 1;

            for (int i = 0; i<=N+1; i++)
                for (int j=0 ; j<=M+1;j++)
                {

                    int seg;
                    seg = br.read();

                    char c = (char) seg;

                    if(cycle == M+2){
                        br.readLine();
                        cycle = 0;
                    }
                    switch (c){
                        case 'P':
                            seg = br.read();
                            Player p = new Player(seg-48);
                            currentlevel.tiles[i][j].Add(p);

                            currentlevel.AddPlayer(p,seg-48-1);
                            currentlevel.AddPlayerToController(p, seg-48-1);

                            break;
                        case 'B':
                            currentlevel.tiles[i][j].Add(new Box());
                            currentlevel.SetNumOfMBoxes(currentlevel.GetNumOfMBoxes()+1);
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
                            seg = br.read() ;

                            currentlevel.tiles[i][j].Add(swk.get(seg-48-1));

                            break;
                        case 'T':
                            seg = br.read();
                            seg = seg-48;
                            Hole h = new Hole(false);

                            currentlevel.tiles[i][j].Add(h);
                            swk.get(seg-1).Add(h);
                            break;
                        case 'H':

                            currentlevel.tiles[i][j].Add(new Hole(true));
                            break;


                    }
                    cycle++;

                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //filename.betolt

        /**
         * filename alapjan betolti a palyat
         */

    }

    public static ObservableList<Highscore.Score> getHighscore() {
        return highscore.getObsList();
    }

    public static Highscore getHighscore2() {
        return highscore;
    }
}