package com.g801.supaplex.Model;

import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Level.ScreenSettings;

import java.util.Objects;

public class Configuration {
    private static Configuration confs;
    private static ScreenSettings displayConfig;
    private Integer currentLevel;
    private final Integer NUM_LEVELS = 5;

    private Configuration() {
        this.currentLevel = 1;
        //Make it count how many levels in level folder and initialize NUM_LEVELS accordingly
        displayConfig = new ScreenSettings();
    }

    public static Configuration getInstance(){
        if (confs == null)
            confs = new Configuration();
        return confs;
    }

    public Integer getWidth(){
        return displayConfig.getWidth();
    }

    public Integer getHeight(){
        return displayConfig.getHeight();
    }

    public Integer getYmin(){
        return displayConfig.getYmin();
    }

    public Integer getXmin(){
        return displayConfig.getXmin();
    }

    public Position getMapBounds(){
        return displayConfig.getMapBounds();
    }

    private void setYmin(Integer y){
        displayConfig.setYmin(y);
    }


    private void setXmin(Integer x){
        displayConfig.setXmin(x);
    }


    public void setMapBounds(Integer x, Integer y){
        displayConfig.setMapBounds(x, y);
    }

    public void updateSettings(Murphy m, Position bound){
        Integer xMin;
        Integer yMin;
        Position pos = m.getPos();

        yMin = pos.getY() - 3 < 0 ? 0 : pos.getY() - 3 ;
        xMin = pos.getX() -5 < 0 ? 0 : pos.getX() - 5 ;


        yMin = (pos.getY() + 3 > bound.getY()) && yMin != 0 ? bound.getY() - 7 : pos.getY() - 3 ;
        xMin = (pos.getX() + 5 > bound.getX()) && xMin != 0 ? bound.getX() - 11 : pos.getX() - 5  ;

        setYmin(yMin);
        setXmin(xMin);
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void increaseCurrentLevel() {
        if (Objects.equals(currentLevel, NUM_LEVELS)) {
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
