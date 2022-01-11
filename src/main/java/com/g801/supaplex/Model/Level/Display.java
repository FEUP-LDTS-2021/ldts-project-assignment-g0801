package com.g801.supaplex.Model.Level;


import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Elements.*;
import com.g801.supaplex.Model.Models.*;
import com.g801.supaplex.Model.Position;

import java.io.FileNotFoundException;
import java.util.*;

public class Display {
    private Configuration configurations;
    private final SpriteFactory spriteFactory = new SpriteFactory();
    private static Model[][] map;
    private static final Position blockSize = new Position(Sprite.width, Sprite.height);
    private static Murphy murphy;

    private Display() {
        configurations = Configuration.getInstance();
        for (Model[] row : map) Arrays.fill(row, null); // tests
        murphy = null;
        render();

    }

    //Make this receive a movable and process according to instanceOf
    public static List<Model> getAura(Position p){
        List<Model> ret = new ArrayList<Model>(4);
        Position point = new Position(p.getX()/blockSize.getX(), p.getY()/blockSize.getY());
        //ret[0] = block above
        ret.set(0, map[point.getX()][point.getY() - 1]);
        //ret[1] = block below
        ret.set(1, map[point.getX()][point.getY()+1]);
        //ret[2] = block to the left
        ret.set(2, map[point.getX()-1][point.getY()]);
        //ret[3] = block to the right
        ret.set(3, map[point.getX()+1][point.getY()]);

        return ret;
    }

    public void update(Position p){
        //calls updateMap
        //calls updateState
        //prints map
    }

    private void updateMap(Position p){
        //checks if there's a need to render new Models
        //YES:
        // calls renderLine or renderColumns as needed
        //sets new models in map
        //NO:
        //does nothing
        //calls gameScreen.update;
    }

    private void updateState(){
        //makes changes on map as needed
            //move murphy
            //change blocks as needed
            //move scissors
                //this will require multithreading
            //move rocks
                //will also need multithreading
    }

    public void render(){
        LoadLevelBuild level = null;
        try {
            level = new LoadLevelBuild(configurations.getCurrentLevel());
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        Character[][] gameMap = level.getLevelMap();
        Position bounds = configurations.getMapBounds();
                modelPos = null;
        Model load = null;
        for(int i = 0; i < bounds.getY(); i++) {
            map[i] = new Model[bounds.getX()];
            for(int j = 0; j < bounds.getX(); j++){
                modelPos = new Position(j * blockSize.getX(), i * blockSize.getY());
                switch(gameMap[i][j]){
                    case 'W' -> load = new Wall(modelPos);
                    case 'B' -> load = new Base(modelPos);
                    case 'C' -> load = new Chip(modelPos);
                    case 'E' -> load = new EndBlock(modelPos);
                    case 'M' -> {
                        murphy = new Murphy(modelPos);
                        load = murphy;
                    }
                    case 'I' -> load = new Infotron(modelPos);
                }
                map[i][j] = load;
                load = null;
            }
        }

    }

    //Add method to set Murphy attribute

    //Returns the subarray to be printed
    public Model[][] getDisplayMap(){
        return null;
    }

    public void endGame(){
        //Deletes everything
    }
}
