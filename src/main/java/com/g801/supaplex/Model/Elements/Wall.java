package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.Terrain;
import java.util.HashMap;

public class Wall extends Terrain {

    public Wall(double x, double y, HashMap<Character, String> colors){
        super(x, y);
        setSprite("Wall", colors);
    }
}
