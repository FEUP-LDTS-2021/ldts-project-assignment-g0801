package com.g801.supaplex.Model;

public class Position {
    private Integer x, y;

    public Position(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Integer getX(){
        return x;
    }

    public Integer getY(){
        return y;
    }

    public void setX(Integer n){
        x = n;
    }

    public void setY(Integer n){
        y = n;
    }

    public void addX(Integer n){
        x += n;
    }

    public void addY(Integer n){
        y += n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
}
