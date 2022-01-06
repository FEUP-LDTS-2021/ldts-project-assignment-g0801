package com.g801.supaplex.Model.Aura;

import com.g801.supaplex.Controller.Action;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Elements.Wall;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Level.GameScreen;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Position;

import java.util.ArrayList;
import java.util.List;

public class Aura{

    private static List<Model> aura = new ArrayList<>(4);

    public void update(){
        aura = Display.getAura(Murphy.getInstance().getPos());
    }

    public boolean canMove(Action.Actions action){
        update();
        boolean ret = true;
        //WIll have to be extended for rocks
        switch(action){
            case MOVE_UP : if (aura.get(0) instanceof Wall) ret = false; break;
            case MOVE_DOWN: if(aura.get(1) instanceof Wall) ret = false; break;
            case MOVE_LEFT: if(aura.get(2) instanceof Wall) ret = false; break;
            case MOVE_RIGHT: if(aura.get(3) instanceof Wall) ret = false; break;
        }
        return ret;
    }
}