package com.g801.supaplex.Controller;

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Elements.*;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Viewer.GUI.GUI;
import java.io.IOException;

public class RockController extends ElementController {

    public RockController(Display model) {
        super(model);
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

        for (Rock elem : getModel().getRockList()) {
            if (canMove(elem)) {
                elem.moveDown();
                getModel().update(elem);
            }
        }
    }

    public boolean canMove(Rock elem){
        boolean ret = false;
        Position pos = elem.getPos();
        Model attemp = getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()];
        if (attemp instanceof Base) ret = true;
        return ret;
    }

    public boolean canMoveRight(Movable elem) {
        boolean ret = false;

        return ret;
    }

}
