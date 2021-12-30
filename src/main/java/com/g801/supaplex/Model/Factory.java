package com.g801.supaplex.Model;

import com.g801.supaplex.Model.Elements.Base;

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
                colors.put(line.charAt(0), line.substring(2));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public Base getBaseBlock(double x, double y) {
        return new Base(x, y, colors);
    }
}
