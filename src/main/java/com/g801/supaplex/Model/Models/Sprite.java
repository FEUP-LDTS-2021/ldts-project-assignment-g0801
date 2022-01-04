package com.g801.supaplex.Model.Models;

public class Sprite {

    static int height = 5;
    static int width = 10;
    char[][] bitmap;

    public Sprite() {
       bitmap = new char[height][width];
    }

    public char[][] getBitmap() {
        return bitmap;
    }

}
