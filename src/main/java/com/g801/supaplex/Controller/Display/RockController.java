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
            if (canMoveDown(elem)) {
                this.soundPlayer.playFallSound();
                elem.moveDown();
                getModel().updateRock(elem);
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

    public boolean canMoveDown(Rock elem){
        boolean ret = false;
        Position pos = elem.getPos();
        Model tmp = getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()];
        if (tmp instanceof Base) ret = true;

        return ret;
    }

    public boolean canMoveRight(Movable elem) {
        boolean ret = false;

        Position pos = elem.getPos();
        Model tmp = getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()];
        Model tmp1 = getModel().getMap()[pos.getRight().getY()][pos.getRight().getX()];
        Model tmp2 = getModel().getMap()[pos.getRight().getDown().getY()][pos.getRight().getDown().getX()];

        if (tmp instanceof Rock && (tmp1 instanceof Base && tmp2 instanceof Base)) ret = true;

        return ret;
    }

    public boolean canMoveLeft(Movable elem) {
        boolean ret = false;

        Position pos = elem.getPos();
        Model tmp = getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()];
        Model tmp1 = getModel().getMap()[pos.getLeft().getY()][pos.getLeft().getX()];
        Model tmp2 = getModel().getMap()[pos.getLeft().getDown().getY()][pos.getLeft().getDown().getX()];

        if (tmp instanceof Rock && (tmp1 instanceof Base && tmp2 instanceof Base)) ret = true;

        return ret;
    }

}
