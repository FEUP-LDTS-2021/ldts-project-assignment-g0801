package com.g801.supaplex.Controller;

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Viewer.GUI.GUI;

import java.io.IOException;

public class MurphyController extends Controller<Display> {
    //Get murphy through constructor
    private static Action actions;

    public MurphyController(Display model){
        super(model);
        actions = new Action(getModel().getMurphy());
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

        Position oldPos = getModel().getMurphy().getPos();

        switch(keyaction) {
            case DOWN -> this.getModel().getMurphy().moveDown();
            case UP -> this.getModel().getMurphy().moveUp();
            case LEFT -> this.getModel().getMurphy().moveLeft();
            case RIGHT -> this.getModel().getMurphy().moveRight();
            default -> getModel().update(getModel().getMurphy(), oldPos);
        }

    }
}
