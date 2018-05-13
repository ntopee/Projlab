package Program;

import java.util.*;
import javafx.scene.canvas.Canvas;

/**
 *  Tárolja a Tile-okat, amikből maga a pálya felépül.
 *  A pálya tulajdonságai is lekérdezhetőek, amelyek a pálya kirajzolásához kellenek majd.
 *  Tudja, mikor van vége a játéknak és ekkor meghívja a Game EndGame függvényét.
 *  Ismeri a mozgatható dobozok számát és csökkenteni tudja őket.
 */
public class Map {

    /**
     * Default constructor
     */
    public Map(int N, int M) {
    tiles = new Tile[N][M];
    tilesH = N;
    tilesV = M;
    }

    /**
     * A kezdőértéke egyenlő a ládák számával,
     * majd ha egy láda mozgathatatlanná válik,
     * akkor ez a szám eggyel csökken.
     */
    private int num_of_movable_boxes;

    private int tilesV;

    private int tilesH;
    /**
     * Megadja, hogy hány láda van a helyén.
     */
    private int goalcounter;


    /**
     *  Ellenszámlálás, ha egy láda a goalon van, és mellé nem is mozdítható, akkor ez növekedik egyel
     */
    private int counterweight;



    /**
     * A player objektumok referenciái.
     */
    private ArrayList<Player> players = new ArrayList<>();

    /**
     * A pályán található összes mező itt van eltárolva.
     */
    public Tile[][] tiles;

    private Canvas canvas;

    /**
     * Egy Tile-ra rárak egy új játékost, amit ugyanez a függvény hoz létre.
     */
    public void AddPlayer(Player p,int N) {
        players.add(N,p);
    }

    /**
     * A játékos referenciát, amit megkap a függvény, kitörli a pályáról.
     * @param p Eltávolítandó Player referenciája.
     */
    public void RemovePlayer(Player p) {
        players.remove(p);
    }

    /**
     * Visszaadja hogy mozdítható láda van a helyén
     * @return
     */
    public int GetNumOfMBoxes() {
        return num_of_movable_boxes;
    }

    /**
     * Beállítja a num_of_movable_boxes értékét.
     * @param n Erre az értékre állítja be a num_of_movable_boxes értékét.
     */
    public void SetNumOfMBoxes(int n) {
        num_of_movable_boxes = n;
    }

    public void DecreaseNumOfBoxes(){
        --num_of_movable_boxes;
    }

    /**
     * Visszaadja hogy hány láda van a helyén.
     * @return
     */
    public int GetGoalCounter() {
        return goalcounter;
    }

    /**
     * Bállítja hogy hogy hány láda van a helyén.
     * @param n
     */
    public void SetGoalCounter(int n) {
        goalcounter = n;
    }

    /**
     * Kivonja egymásból a goalcounter-t
     * és a num_of_moveable_boxes-t,
     * ha nulla végeredmény,
     * akkor meghívja az EndGame() függvényt.
     */
    public void CheckEndGame() {
        if ( (players.size() == 0) || (goalcounter == (num_of_movable_boxes + counterweight))  || (num_of_movable_boxes == 0))
            Game.EndGame();
    }

    public int GetCounterWeight() {
        return counterweight;
    }

    /**
     * Bállítja hogy hogy hány láda van a helyén.
     * @param n
     */
    public void SetCounterWeight(int n) {
        counterweight = n;
    }

    public ArrayList<Player> getPlayer(){
        return players;
    }

    public int getTilesV(){
        return  tilesV;
    }

    public int getTilesH(){
        return tilesH;
    }

    public void setCanvas(Canvas cv){
        canvas = cv;
        canvas.setHeight(tilesH*Game.TILE_SIZE);
        canvas.setWidth(tilesV*Game.TILE_SIZE);
    }
    public Canvas getCanvas() { return canvas; }

    public void DrawAll(){
        for (int i = 0; i < tilesH; i++){
            for (int j = 0; j < tilesV; j++){
                tiles[i][j].Draw((j)*Game.TILE_SIZE,(i)*Game.TILE_SIZE, canvas);
            }
        }

    }

}