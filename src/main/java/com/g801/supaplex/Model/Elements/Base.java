package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.Terrain;
import java.util.HashMap;

public class Base extends Terrain {

    public Base (double x, double y, HashMap<Character, String> colors) {
        super(x, y);
        setSprite("Base", colors);
    }

}