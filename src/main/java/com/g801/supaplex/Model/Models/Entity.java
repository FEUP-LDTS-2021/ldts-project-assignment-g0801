package com.g801.supaplex.Model.Models;

import com.g801.supaplex.Model.Position;

public class Entity extends Model {

    public Entity(double x, double y){
        pos = new Position(x, y);
        model = new Sprite();
    }

    @Override
    public Position getPos() {
        return pos;
    }

    @Override
    public Sprite getModel() {
        return model;
    }

}
