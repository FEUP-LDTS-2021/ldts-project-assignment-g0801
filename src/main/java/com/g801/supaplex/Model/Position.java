package com.g801.supaplex.Model;

public class Position {
    double x, y;

    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    double getX(){
        return x;
    }

    double getY(){
        return y;
    }

    void addX(double n){
        x += n;
    }

    void addY(double n){
        y += n;
    }
}
