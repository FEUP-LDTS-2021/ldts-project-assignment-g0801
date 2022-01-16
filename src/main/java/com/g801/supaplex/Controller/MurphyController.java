package com.g801.supaplex.Controller;

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Viewer.GUI.GUI;

import java.io.IOException;

public class MurphyController extends Controller<Display> {

    public MurphyController(Display model){
        super(model);
        //Get murphy through constructor
        Action actions = new Action(getModel().getMurphy());
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

        switch(keyaction) {

            case DOWN -> {
                this.getModel().getMurphy().moveDown();
                getModel().update(getModel().getMurphy(),keyaction);
            }
            case UP -> {
                this.getModel().getMurphy().moveUp();
                getModel().update(getModel().getMurphy(),keyaction);
            }
            case LEFT -> {
                this.getModel().getMurphy().moveLeft();
                getModel().update(getModel().getMurphy(),keyaction);
            }
            case RIGHT ->  {
                this.getModel().getMurphy().moveRight();
                getModel().update(getModel().getMurphy(),keyaction);
            }
        }
    }
}
