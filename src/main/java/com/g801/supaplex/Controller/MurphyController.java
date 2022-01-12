package com.g801.supaplex.Controller;

import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Viewer.GUI.GUI;

public class MurphyController {
    //Get murphy through constructor
    private static Murphy murphy;
    private static Action actions;

    public MurphyController(Murphy m){
        murphy = m;
        actions = new Action(m);
    }

    //Parses input and calls the correct action method
    public void makeMove(GUI.KEYACTION input){
        //updates aura
    }
}
