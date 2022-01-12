package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Controller.Action;
import com.g801.supaplex.Model.Position;

public class Rock extends Movable{

    public Rock(Position p){}

    //Checks if  Murphy can push this rock
    public boolean canPush(Action.Actions action){
        return true;
    }

    //Makes rock fall
    public void fall(){}

    //Checks if rock collides with murphy or a scissor
    public boolean checkCollision(){
        return true;
    }
}
