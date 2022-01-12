package com.g801.supaplex.Model.Level;

import com.g801.supaplex.Model.Position;

public class ScreenSettings{
    private static final Integer width = 15;   //How many blocks to the side of murphy
    private static final Integer height = 10;
    private static Position mapBounds;
    private static Position displayTopleft;

    public ScreenSettings(){
        displayTopleft = new Position(0,0);
    }

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

    public void setDisplayTopleft(Position p){
        displayTopleft = p;
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