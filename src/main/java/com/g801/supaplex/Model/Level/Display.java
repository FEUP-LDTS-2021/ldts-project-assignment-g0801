package com.g801.supaplex.Model.Level;

import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

import java.util.List;

public class Display {
    private static Display display;
    private Model[][] map;
    private GameScreen gameScreen;
    private SpriteFactory spriteFactory;

    private Display(){
        spriteFactory = new SpriteFactory();
        gameScreen = null;
        //creates char array
        //gets char array from gameScreen
        //renders it into map
    }

    public static Display getInstance(){
        //Singleton pattern for display
        return null;
    }

    public void createGameScreen(int i){
        //if gamescreen == null
            //receives the desired level and creates gamescreen
                //this initializes the map and everything else
        //initializes map with GameMap bounds
    }

    public static List<Model> getAura(Position p){
        //Returns the 4 blocks around p
        return null;
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

    private void render(){
        //Renders gameMap into modelsi
    }

    public void endGame(){
        //Deletes everything
    }
}
