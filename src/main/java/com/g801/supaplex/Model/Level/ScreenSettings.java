package com.g801.supaplex.Model.Level;

import com.g801.supaplex.Model.Position;

public class ScreenSettings{
    private static final Integer width = 11;   //How many blocks to the side of murphy
    private static final Integer height = 7;
    private static Position mapBounds;
    private static Position displayTopleft;


    public Integer getWidth(){
        return width;
    }

    public Integer getHeight(){
        return height;
    }

    public Integer getYmin(){
        return displayTopleft.getY();
    }

    public Integer getXmin(){
        return displayTopleft.getX();
    }


    public Position getMapBounds(){
        return mapBounds;
    }

    public void setYmin(Integer y){
        displayTopleft.setY(y);
    }

    public void setXmin(Integer x){
        displayTopleft.setX(x);
    }

    public void setMapBounds(Integer x, Integer y){
        mapBounds = new Position(x, y);
    }
}