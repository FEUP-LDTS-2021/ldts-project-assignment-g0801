package com.g801.supaplex.Controller.action;

import com.g801.supaplex.Model.Elements.Movable;

public class Action {
    protected Movable movable;

    public Action(){
        movable = null;
    }

    public Action(Movable m){
        movable = m;
    }

    //Test method, might be needed later
    public Movable getMovable(){
        return movable;
    }

}