package com.g801.supaplex.Model.Elements;
import com.g801.supaplex.Model.Models.Sprite;
import com.g801.supaplex.Model.Position;

public class Terrain extends Model{
    Terrain(double x, double y){
        pos = new Position(x, y);
    }

    @Override
    Position getPos(){
        return pos;
    }

    @Override
    Sprite getModel(){
        return model;
    }

    void setModel(Sprite s){
        model = s;
    }
}

