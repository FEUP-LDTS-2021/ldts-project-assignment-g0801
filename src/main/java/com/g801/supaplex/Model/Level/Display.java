package com.g801.supaplex.Model.Level;

import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Elements.*;
import com.g801.supaplex.Model.Models.*;
import com.g801.supaplex.Model.Position;

import java.util.*;

public class Display {
    private static Display display;
    private static Model[][] map;
    private GameScreen gameScreen;
    private SpriteFactory spriteFactory;

    private Display(){
        spriteFactory = new SpriteFactory();
        gameScreen = GameScreen.getInstance();
        render();
    }


    public static Display getInstance(){
        if(display == null)
            display = new Display();
        return display;
    }


    public static List<Model> getAura(Position p){
        List<Model> ret = new ArrayList<Model>(4);
        Position blockSize = Configuration.getInstance().getBlockSize();
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
        Character[][] gameMap = gameScreen.getMap();
        Position bounds = gameScreen.getMapBounds(),
                modelPos = null,
                blockSize = Configuration.getInstance().getBlockSize();
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
                    case 'M' -> load = Murphy.getInstance();
                    case 'I' -> load = new Infotron(modelPos);
                    //Add more in the future
                }
                map[i][j] = load;
                load = null;
            }
        }

    }

    //Returns the subarray to be printed
    public Model[][] getDisplayMap(){
        return null;
    }

    public void endGame(){
        //Deletes everything
    }
}
