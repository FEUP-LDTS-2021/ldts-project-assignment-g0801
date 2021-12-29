package com.g801.supaplex.Model.Models;

public class Sprite {
    static int height = 5;
    static int width = 10;
    String[][] bitmap;
    char type;

    Sprite(){
       bitmap = new String[height][width];
       type = '\0';
    }

    void read(){
        //Reads sprite info from file
    }

}
