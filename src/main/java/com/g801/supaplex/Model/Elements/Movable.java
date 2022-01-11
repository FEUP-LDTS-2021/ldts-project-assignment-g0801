package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Controller.Action;
import com.g801.supaplex.Model.Aura.Aura;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Models.Sprite;

public class Movable extends Model {
    protected Aura aura;
    //Create an Aura field

    public Movable(){
        super.model = new Sprite();
        super.pos = null;
    }


    public void moveUp(){
        super.pos.addY(-model.getHeight());
    }

    public void moveDown(){
        super.pos.addY(model.getHeight());
    }

    public void moveLeft(){
        super.pos.addX(-model.getWidth());
    }

    public void moveRight(){
        super.pos.addX(model.getWidth());
    }

    //Checks if Murphy can move to the desired block
    public boolean canMove(Action.Actions action){
        return aura.canMove(action);
    }

    public void updateAura(){
        aura.update();
    }

    //Put this in MoveScissors
    public void spin(){}

    //Put this in MoveRock
    public void fall(){}

}
