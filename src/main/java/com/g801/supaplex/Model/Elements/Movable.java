package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Models.Model;

public class Movable extends Model {

    public Movable(){
        super.model = null;
        super.pos = null;
    }

    public void moveUp(){
        super.pos.addY(-Configuration.getInstance().getBlockSize().getY());
    }

    public void moveDown(){
        super.pos.addY(Configuration.getInstance().getBlockSize().getY());
    }

    public void moveLeft(){
        super.pos.addX(-Configuration.getInstance().getBlockSize().getX());
    }

    public void moveRight(){
        super.pos.addX(Configuration.getInstance().getBlockSize().getX());
    }

    //Put this in MoveScissors
    public void spin(){}

    //Put this in MoveRock
    public void fall(){}

}
