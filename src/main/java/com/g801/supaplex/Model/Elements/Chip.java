package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.Entity;
import java.util.HashMap;

public class Chip extends Entity {

    public Chip(double x, double y, HashMap<Character, String> colors) {
        super(x, y);
        setSprite("Chip", colors);
    }

}