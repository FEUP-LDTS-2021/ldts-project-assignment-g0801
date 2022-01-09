package com.g801.supaplex.Model.Level;

import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Position;

//No need to make it a singleton since it is a private class
class GameMap{
    private static Integer level;
    private static Character[][] map;
    private final Integer xBound;
    private final Integer yBound;

    GameMap(Integer i){
        xBound = 0;
        yBound = 0;
        map = new Character[0][0];
        level = i;
        loadMap();
    }

    private void loadMap(){
        LoadLevelBuild.getLevelMap(level);
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
    private final GameMap map;
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
