package com.g801.supaplex.Model;

import com.g801.supaplex.Model.Elements.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Factory {

    HashMap<Character, String> colors;

    public Factory() {
        colors = new HashMap<Character, String>();
        readColors();
    }

    public void readColors() {

        try {
            File file = new File("src/main/java/com/g801/supaplex/Model/Resorces/Colors.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                colors.put(line.charAt(0), line.substring(2, 9));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    /*public Base getBaseBlock(double x, double y) {
        return new Base(x, y, colors);
    }

    public Chip getChipBlock(double x, double y) {
        return new Chip(x, y, colors);
    }

    public Endblock getEndBlock(double x, double y) {
        return new Endblock(x, y, colors);
    }

    public Infotron getInfotron(double x, double y) {
        return new Infotron(x, y, colors);
    }

    public Murphy getMurphy(double x, double y) {
        return new Murphy(x, y, colors);
    }

    public Wall getWall(double x, double y) {
        return new Wall(x, y, colors);
    }*/
}
