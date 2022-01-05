package com.g801.supaplex.Model;

import com.g801.supaplex.Model.Elements.Murphy;

class ScreenSettings{
    public static final Integer x = 5;   //How many blocks to the side of murphy
    public static final Integer y = 3;
    public Integer yMin;
    public Integer yMax;
    public Integer xMin;
    public Integer xMax;
}

public class Configuration {
    private static Configuration confs;
    private static ScreenSettings displayConfig;
    private Integer currentLevel;
    private Integer NUM_LEVELS = 5;

    private Configuration() {
        this.currentLevel = 1;
        displayConfig = new ScreenSettings();
    }

    public static Configuration getInstance(){
        if (confs == null)
            confs = new Configuration();
        return confs;
    }

    //Returns ScreenSettings lower bound
    public Position getScreenLowerBound(){
        return null;
    }

    public void updateSettings(Murphy m, Position bound){
        Integer mY = m.getPos().getY();
        Integer mX = m.getPos().getX();
        Integer val;

        val = mY - ScreenSettings.y;
        if(val < 0) val = 0;
        displayConfig.yMin = val;

        val = mX - ScreenSettings.x;
        if(val < 0) val = 0;
        displayConfig.xMin = val;

        val = mY + ScreenSettings.y;
        if(val > bound.getY()) val = bound.getY();
        displayConfig.yMax = mY + val;

        val = mX + ScreenSettings.x;
        if(val > bound.getX()) val = bound.getX();
        displayConfig.xMax = val;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void increaseCurrentLevel() {
        if (currentLevel == NUM_LEVELS) {
            currentLevel = 1;
        }
        else currentLevel++;
    }

    public void lowerCurrentLevel() {
        if (currentLevel == 1) {
            currentLevel = NUM_LEVELS;
        } else currentLevel--;
    }
}
