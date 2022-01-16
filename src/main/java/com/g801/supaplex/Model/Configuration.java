package com.g801.supaplex.Model;

import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Level.ScreenSettings;
import org.codehaus.groovy.transform.SourceURIASTTransformation;

import java.util.Objects;

public class Configuration {
    private static Configuration confs;
    private static ScreenSettings displayConfig;
    private Integer currentLevel;
    private final Integer NUM_LEVELS = 5;

    private Configuration() {
        this.currentLevel = 1;
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

    public void updateSettings(Murphy m){
        Integer xMin;
        Integer yMin;
        Position bound = displayConfig.getMapBounds();
        Position pos = m.getPos();

        Integer w = getWidth() / 2;
        Integer h = getHeight() / 2;

        yMin = Math.max(pos.getY() - h, 0);
        xMin = Math.max(pos.getX() - w, 0);

        if (yMin != 0) yMin = pos.getY() + h >= bound.getY() ? bound.getY() - getHeight() : pos.getY() - h;
        if (xMin != 0) xMin = pos.getX() + w >= bound.getX() ? bound.getX() - getWidth() : pos.getX() - w;

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

    public static void setWidth(Integer w) {
        displayConfig.setWidth(w);
    }

    public static void setHeight(Integer h) {
        displayConfig.setHeight(h);
    }
}
