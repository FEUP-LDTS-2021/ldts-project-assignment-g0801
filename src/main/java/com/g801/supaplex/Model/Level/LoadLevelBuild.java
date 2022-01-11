package com.g801.supaplex.Model.Level;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadLevelBuild {

    private static Character[][] map;

    public LoadLevelBuild(int lvl) throws FileNotFoundException {

        String level = lvl < 10 ? "0" + String.valueOf(lvl) : String.valueOf(lvl);

        File file = new File("src/main/java/com/g801/supaplex/Model/Resorces/Levels/Level" + level + ".txt");
        Scanner reader = new Scanner(file);
        int i = 0, j;
        String line;
        while(reader.hasNextLine()){
            line = reader.nextLine();
            map[i] = new Character[line.length()];
            for(j = 0; j < line.length(); j++){
                map[i][j] = line.charAt(j);
            }
            i++;
        }
        reader.close();
    }

    public Character[][] getLevelMap(){
        return map;
    }
}
