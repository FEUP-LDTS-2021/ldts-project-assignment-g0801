package com.g801.supaplex.Model.Models;

import com.g801.supaplex.Model.Models.Sprite;
import com.g801.supaplex.Model.Position;

import java.util.HashMap;

public class Model {

    Position pos;
    Sprite model;

    Position getPos() {
        return pos;
    }

    Sprite getModel() {
        return model;
    }

    public void setSprite(String s, HashMap<Character, String> colors) {
        model.read(s, colors);
    }

}

