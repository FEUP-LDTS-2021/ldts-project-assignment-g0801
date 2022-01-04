package com.g801.supaplex.Model.Level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

class Config{
    public static final int x = 5;   //How many blocks to the side of murphy
    public static final int y = 3;
    public int yMin;
    public int yMax;
    public int xMin;
    public int xMax;
}


class GameMap{
    private static int level;
    private static char[][] map;
    private int xBound;
    private int yBound;

    GameMap(int i){
        xBound = 0;
        yBound = 0;
        map = null;
        level = i;
    }

    private File openFile(){
        return new File("");
    }

    private void loadMap(File f){
    }

    private void createGameMap(){

    }

    public int getXBound(){
        return 0;
    }

    public int getYBound(){
        return 0;
    }

    protected char[][] getMap(){
        createGameMap();
        return map;}
}

public class GameScreen{
    private GameMap map;
    private static Config confs;

    //Eventually make this into a singleton
    public GameScreen(int lvl){
        map = new GameMap(lvl);

        Murphy m = Murphy.getInstance();
        confs = new Config();
        int mY = m.getPos().getY();
        int mX = m.getPos().getX();

        //Make sure these don't get negative
        confs.yMin = mY - Config.y;
        confs.xMin = mX - Config.x;

        //Make sure this doesnt go past mapboung
        confs.yMax = mY + Config.y;
        confs.xMax = mX + Config.x;
    }

    public Position getMapBounds(){
        return null;
    }

    public Position getLowerBounds(){
        return null;
    }

    public Position getUpperBounds(){
        return null;
    }

    public void update(Position p){
        //receives Murphy's new position
        //updates Config accordingly
    }

    public char[][] getMap(){
        return map.getMap();
    }

    public char[][] getGameScreen(){
        return null;
    }

}
