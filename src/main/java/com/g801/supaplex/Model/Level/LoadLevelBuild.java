package com.g801.supaplex.Model.Level;

import com.g801.supaplex.Model.Configuration;

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
        Configuration confs = Configuration.getInstance();

        String level = lvl < 10 ? "0" + String.valueOf(lvl) : String.valueOf(lvl);

        File file = new File("src/main/resources/Levels/Level" + level + ".txt");
        Scanner reader = new Scanner(file);
        int i = 0, j = 0;
        String line;
        while(reader.hasNextLine()){
            line = reader.nextLine();
            map[i] = new Character[line.length()];
            for(j = 0; j < line.length(); j++){
                map[i][j] = line.charAt(j);
            }
            i++;
        }
        confs.setMapBounds(j, i - 1);
        reader.close();
    }

    public Character[][] getLevelMap(){
        return map;
    }
}
