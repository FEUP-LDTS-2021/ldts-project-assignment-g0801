package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.Terrain;
import java.util.HashMap;

public class Endblock extends Terrain {

    public Endblock(double x, double y, HashMap<Character, String> colors) {
        super(x, y);
        setSprite("EndBlock", colors);
    }
}