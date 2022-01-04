package com.g801.supaplex.Model.Models;

public class Sprite {

    private static int width = 10;
    private static int height = 5;

    char[][] bitmap;

    public Sprite() {
       bitmap = new char[height][width];
    }

    public char[][] getBitmap() {
        return bitmap;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

}
