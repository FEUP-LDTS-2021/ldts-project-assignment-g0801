package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Controller.Action;
import com.g801.supaplex.Model.Aura.Aura;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Models.Sprite;

public abstract class Movable extends Model {
    protected Aura aura;

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

    public void updateAura(Display d){
        aura.update(d);
    }

    //Checks if Movable collides with something
    public abstract boolean checkCollision();

    //Makes Movable explode
    public void explode(){}
}
