package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.Entity;
import java.util.HashMap;

public class Murphy extends Entity {

    public Murphy(double x, double y, HashMap<Character, String> colors) {
        super(x, y);
        setSprite("Murphy", colors);
    }

}
