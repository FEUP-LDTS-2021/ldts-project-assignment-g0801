package com.g801.supaplex.Controller.Display;

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
                this.soundPlayer.playFallSound();
                elem.moveDown();
                getModel().update(elem);
            }
            else if (canMoveRight(elem)) {
                elem.moveRight(); elem.moveDown();
                getModel().updateRockRight(elem);
            }
            else if (canMoveLeft(elem)) {
                elem.moveLeft(); elem.moveDown();
                getModel().updateRockLeft(elem);
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

        Position pos = elem.getPos();
        Model attemp = getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()];
        Model attemp1 = getModel().getMap()[pos.getRight().getY()][pos.getRight().getX()];
        Model attemp2 = getModel().getMap()[pos.getRight().getDown().getY()][pos.getRight().getDown().getX()];

        if (attemp instanceof Rock && (attemp1 instanceof Base && attemp2 instanceof Base)) ret = true;

        return ret;
    }

    public boolean canMoveLeft(Movable elem) {
        boolean ret = false;

        Position pos = elem.getPos();
        Model attemp = getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()];
        Model attemp1 = getModel().getMap()[pos.getLeft().getY()][pos.getLeft().getX()];
        Model attemp2 = getModel().getMap()[pos.getLeft().getDown().getY()][pos.getLeft().getDown().getX()];

        if (attemp instanceof Rock && (attemp1 instanceof Base && attemp2 instanceof Base)) ret = true;

        return ret;
    }

}
