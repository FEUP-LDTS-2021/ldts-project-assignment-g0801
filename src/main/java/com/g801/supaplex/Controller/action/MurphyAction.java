package com.g801.supaplex.Controller.action;

import com.g801.supaplex.Model.Elements.Murphy;

public class MurphyAction extends Action{
    public MurphyAction(){
        super.movable = Murphy.getInstance();
    }
}
