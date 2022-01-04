package com.g801.supaplex.Controller;

import com.g801.supaplex.Model.Elements.Movable;

public class Action {
    protected Movable movable;

    public Action(){
        movable = null;
    }

    public Action(Movable m){
        movable = m;
    }

}
