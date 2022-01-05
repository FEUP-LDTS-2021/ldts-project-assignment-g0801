package com.g801.supaplex.Model.Level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

//No need to make it a singleton since it is a private class
class GameMap{
    private static Integer level;
    private static Character[][] map;
    private Integer xBound;
    private Integer yBound;

    GameMap(Integer i){
        xBound = 0;
        yBound = 0;
        map = null;
        level = i;
        loadMap();
    }

    private void loadMap(){
        String lvl = "";
        if(level < 10) lvl += String.valueOf(0);
        lvl += String.valueOf(level);

        File file = new File("/Levels/Level0" + lvl + ".txt");
        Scanner reader = null;
        try{
            reader = new Scanner(file);
            String line = null;
            int i = 0;
            while(reader.hasNextLine()){
                line = reader.nextLine();
                xBound = line.length();
                map[i] = new Character[xBound];
                for(int j = 0; j < xBound; j++)
                    map[i][j] = line.charAt(j);
                i++;
            }
            yBound = i;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }


    public Integer getXBound(){
        return xBound;
    }

    public Integer getYBound(){
        return yBound;
    }

    protected Character[][] getMap(){
        return map;
    }
}

public class GameScreen{
    private static GameScreen gameScreen;
    private GameMap map;
    private static Configuration confs;


    private GameScreen(){
        map = new GameMap(confs.getCurrentLevel());

        Murphy m = Murphy.getInstance();
        confs = Configuration.getInstance();
        confs.updateSettings(m, getMapBounds());
    }

    public static GameScreen getInstance(){
        if(gameScreen == null)
            gameScreen = new GameScreen();
        return gameScreen;
    }

    //Returns GameMap bounds
    public Position getMapBounds(){
        return null;
    }

    //Updates ScreenSettings when murphy is changed
    public static void update(){
    }

    public Character[][] getMap(){
        return map.getMap();
    }
}
