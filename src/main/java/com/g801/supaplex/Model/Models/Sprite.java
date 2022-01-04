package com.g801.supaplex.Model.Models;

public class Sprite {

    static int height = 5;
    static int width = 10;
    String[][] bitmap;

    public Sprite() {
       bitmap = new String[height][width];
    }

    public String[][] getBitmap() {
        return bitmap;
    }

}
