package com.g801.supaplex.Model.Level;

import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Models.SpriteFactory;

class GameMap{
    private char map[][];
    private int xBound;
    private int yBound;

    GameMap(int i){
        //Receives level
        //Opens level file
        //Reads level info into map array
        //Counts line and character
            //These are the indexes of the char map

        /*char c = '\0';
        switch(c){
            case 'M' : Murphy m = Murphy.getInstance();
                    //Sets murphy sprite and position
                    //Calls ModelFactory to get sprite
                    //Uses position with the counters
                    break;
        }*/
    }

    public char[][] getMap(){return map;}
}

class Config{
    //Eventually move this into Configuration.java
    public static final int x = 5;   //How many blocks to the side of murphy
    public static final int y = 3;
    public int yMin;
    public int yMax;
    public int xMin;
    public int xMax;
}

public class GameScreen {
    private static GameMap map;
    private static Config confs;
    private SpriteFactory mf;

    //Eventually make this into a singleton
    public GameScreen(int i){
        //initialize game map
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
        mf = new SpriteFactory();
    }

    public void getGameScreen(){
        //Change return type to Model[][]
        // get map from GameMap
        //use ModelFactory to parse subarray
            //Subarray specs stored in cofig
        //Return Model 2D array
            //Other option is setting it as attribute
    }

    //Methods to update GameScreen upon event



}
