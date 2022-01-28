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

        Display model = getModel();
        for (Rock elem : model.getRockList()) {
            if (canMoveDown(elem)) {
                this.soundPlayer.playFallSound();
                elem.moveDown();
                model.updateRock(elem);
            }
            else if (canMoveRight(elem)) {
                elem.moveRight(); elem.moveDown();
                model.updateRockRight(elem);
            }
            else if (canMoveLeft(elem)) {
                elem.moveLeft(); elem.moveDown();
                model.updateRockLeft(elem);
            }
        }
    }

    public boolean canMoveDown(Rock elem){
        Position pos = elem.getPos().getDown();
        Model model = getModel().getMap()[pos.getY()][pos.getX()];
        return model instanceof Base;
    }

    public boolean canMoveRight(Rock elem) {
        Model[][] map = getModel().getMap();
        Position pos = elem.getPos();
        Model tmp = map[pos.getY()][pos.getX()];
        pos = pos.getRight();
        Model tmp1 = map[pos.getY()][pos.getX()];
        Model tmp2 = map[pos.getY()+1][pos.getX()];
        return tmp instanceof Rock && tmp1 instanceof Base && tmp2 instanceof Base;
    }

    public boolean canMoveLeft(Rock elem) {
        Model[][] map = getModel().getMap();
        Position pos = elem.getPos();
        Model tmp = map[pos.getY()][pos.getX()];
        pos = pos.getLeft();
        Model tmp1 = map[pos.getY()][pos.getX()];
        Model tmp2 = map[pos.getY()+1][pos.getX()];
        return tmp instanceof Rock && tmp1 instanceof Base && tmp2 instanceof Base;
    }
}