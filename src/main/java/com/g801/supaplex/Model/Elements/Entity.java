package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.Sprite;
import com.g801.supaplex.Model.Position;

public class Entity extends Model {

    Entity(double x, double y){
        pos = new Position(x, y);
    }

    @Override
    Position getPos() {
        return null;
    }

    @Override
    Sprite getModel() {
        return null;
    }

}
