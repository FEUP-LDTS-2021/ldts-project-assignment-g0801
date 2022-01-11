package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Controller.Action;
import com.g801.supaplex.Model.Aura.Aura;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

public class Murphy extends Movable {
    enum Direction{
        UP, DOWN, LEFT, RIGHT
    }

    private boolean alive;

    public Murphy(Position p){
        super.model = SpriteFactory.factoryMethod('M');
        super.pos = p;
        alive = true;
        super.aura = new Aura();
    }



    //Checks if Murphy can eat the desired block
    public boolean canEat(Direction d){
        return true;
    }

    //Tests
    public void setAura(Aura aura) {
        this.aura = aura;
    }

    public Aura getAura() { return aura; }
}
