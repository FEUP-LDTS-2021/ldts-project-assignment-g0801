package com.g801.supaplex.Model.Level;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoadLevelBuild {

    private final List<String> lines;



    public LoadLevelBuild() throws FileNotFoundException {

        URL resource = LoadLevelBuild.class.getResource("/Levels/Level01.txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) {
        return new ArrayList<>();
    }

//    private List<String> readLines(BufferedReader br) {
//        List<String> lines = new ArrayList<>();
//        for (String line; (line = br.readLines()) != null; )
//    }
}
