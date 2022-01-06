package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Controller.Action;
import com.g801.supaplex.Model.Aura.Aura;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

public class Murphy extends Movable {
    enum Direction{
        UP, DOWN, LEFT, RIGHT
    }

    private static Murphy m;
    private Aura aura;
    private boolean alive;

    private Murphy(){
        super.model = SpriteFactory.factoryMethod('M');
        super.pos = null;
        alive = true;
        aura = new Aura();
    }

    public static Murphy getInstance(){
        if(m == null)
            m = new Murphy();
        return m;
    }

    //Checks if Murphy can move to the desired block
    public boolean canMove(Action.Actions action){
        return aura.canMove(action);
    }

    //Checks if Murphy can eat the desired block
    public boolean canEat(Direction d){
        return true;
    }

    public void updateAura(){
        aura.update();
    }

    //Tests
    public void setAura(Aura aura) {
        this.aura = aura;
    }
}
