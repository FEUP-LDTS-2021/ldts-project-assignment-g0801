package com.g801.supaplex.Model;

import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Model.Text;
import com.googlecode.lanterna.graphics.TextImage;

public class Image {

    private char [][] bitMap;
    private Position position;

    public Image(Position position, char [][] bitMap) {
        this.position = position;
        this.bitMap = bitMap;
    }

    public Position getPosition() {
        return position;
    }

    public char[][] getBitMap() {
        return bitMap;
    }
}
