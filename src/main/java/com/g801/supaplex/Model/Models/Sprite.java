package com.g801.supaplex.Model.Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

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

    public void read(String type, HashMap<Character, String> colors) {

        try {
            File file = new File("src/main/java/com/g801/supaplex/Model/Resorces/Blocks/" + type + ".txt");
            Scanner reader = new Scanner(file);
            int i = 0;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                for (int j = 0 ; j < line.length() ; j++) {
                    bitmap[i][j] = colors.get(line.charAt(j));
                }
                i++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

}
