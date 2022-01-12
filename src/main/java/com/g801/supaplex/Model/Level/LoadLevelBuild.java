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

    private static ArrayList<String> map;

    public LoadLevelBuild(int lvl) throws FileNotFoundException {
        Configuration confs = Configuration.getInstance();

        String level = lvl < 10 ? "0" + String.valueOf(lvl) : String.valueOf(lvl);

        File file = new File("src/main/resources/Levels" + level + ".txt");
        Scanner reader = new Scanner(file);
        int i = 0;
        String line = new String("");
        while(reader.hasNextLine()){
            line = reader.nextLine();
            map.add(line);
            i++;
        }
        confs.setMapBounds(line.length(), i - 1);
        reader.close();
    }

    public ArrayList<String> getLevelMap(){
        return map;
    }
}
