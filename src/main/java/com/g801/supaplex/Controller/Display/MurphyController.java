package com.g801.supaplex.Controller.Display;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Elements.*;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Menu.GameWinMenu;
import com.g801.supaplex.Model.Menu.PauseMenu;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.States.GameWinMenuState;
import com.g801.supaplex.States.PauseMenuState;
import com.g801.supaplex.Viewer.GUI.GUI;
import java.io.IOException;

public class MurphyController extends Controller<Display> {

    public MurphyController(Display model){
        super(model);
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

        if (canMove(keyaction, game)) {
            Position oldPos = getModel().getMurphy().getPos();
            switch(keyaction) {
                case DOWN -> this.getModel().getMurphy().moveDown();
                case UP -> this.getModel().getMurphy().moveUp();
                case LEFT -> this.getModel().getMurphy().moveLeft();
                case RIGHT -> this.getModel().getMurphy().moveRight();
                case EAT_LEFT -> this.getModel().getMap()[oldPos.getLeft().getY()][oldPos.getLeft().getX()] = new Base(oldPos.getLeft());
                case EAT_RIGHT -> this.getModel().getMap()[oldPos.getRight().getY()][oldPos.getRight().getX()] = new Base(oldPos.getRight());
                case EAT_UP -> this.getModel().getMap()[oldPos.getUp().getY()][oldPos.getUp().getX()] = new Base(oldPos.getUp());
                case EAT_DOWN -> this.getModel().getMap()[oldPos.getDown().getY()][oldPos.getDown().getX()] = new Base(oldPos.getDown());
            }
            getModel().update(getModel().getMurphy(),keyaction);
            getModel().updateTopLeft();
        }
    }

    public boolean canMove(GUI.KEYACTION keyaction, Game game){
        boolean ret = true;
        Position pos = getModel().getMurphy().getPos();

        switch(keyaction){
            case UP -> {
                if (getModel().getMap()[pos.getUp().getY()][pos.getUp().getX()] instanceof Wall) ret = false;
                if (getModel().getMap()[pos.getUp().getY()][pos.getUp().getX()] instanceof Rock) ret = false;
                if (getModel().getMap()[pos.getUp().getY()][pos.getUp().getX()] instanceof EndBlock) {
                    if (!checkInfotronCount(game)) {
                        ret = false;
                    }
                }
                if (getModel().getMap()[pos.getUp().getY()][pos.getUp().getX()] instanceof Infotron) {
                    this.soundPlayer.decreaseInfotronSound();
                    getModel().decrementInfotronCount();
                }
            }
            case DOWN -> {
                if (getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()] instanceof Wall) ret = false;
                if (getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()] instanceof Rock) ret = false;
                if (getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()] instanceof EndBlock) {
                    if (!checkInfotronCount(game)) {
                        ret = false;
                    }
                }
                if (getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()] instanceof Infotron) {
                    this.soundPlayer.decreaseInfotronSound();
                    getModel().decrementInfotronCount();
                }
            }
            case LEFT -> {
                if (getModel().getMap()[pos.getLeft().getY()][pos.getLeft().getX()] instanceof Wall) ret = false;
                if (getModel().getMap()[pos.getLeft().getY()][pos.getLeft().getX()] instanceof Rock) ret = false;
                if (getModel().getMap()[pos.getLeft().getY()][pos.getLeft().getX()] instanceof EndBlock)
                {
                    if (!checkInfotronCount(game)) {
                        ret = false;
                    }
                }
                if (getModel().getMap()[pos.getLeft().getY()][pos.getLeft().getX()] instanceof Infotron) {
                    this.soundPlayer.decreaseInfotronSound();
                    getModel().decrementInfotronCount();
                }
            }
            case RIGHT -> {
                if (getModel().getMap()[pos.getRight().getY()][pos.getRight().getX()] instanceof Wall) ret = false;
                if (getModel().getMap()[pos.getRight().getY()][pos.getRight().getX()] instanceof Rock) ret = false;
                if (getModel().getMap()[pos.getRight().getY()][pos.getRight().getX()] instanceof EndBlock)
                {
                    if (!checkInfotronCount(game)) {
                        ret = false;
                    }
                }
                if (getModel().getMap()[pos.getRight().getY()][pos.getRight().getX()] instanceof Infotron) {
                    this.soundPlayer.decreaseInfotronSound();
                    getModel().decrementInfotronCount();
                }
            }

            case EAT_DOWN -> ret = getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()] instanceof Chip;
            case EAT_UP -> ret = getModel().getMap()[pos.getUp().getY()][pos.getUp().getX()] instanceof Chip;
            case EAT_LEFT -> ret = getModel().getMap()[pos.getLeft().getY()][pos.getLeft().getX()] instanceof Chip;
            case EAT_RIGHT -> ret = getModel().getMap()[pos.getRight().getY()][pos.getRight().getX()] instanceof Chip;

        }
        return ret;
    }

    boolean checkInfotronCount(Game game) {
        if (getModel().getInfotronCount() == 0) {
            this.soundPlayer.playGameWinSound();
            game.pushState(new GameWinMenuState(new GameWinMenu()));
            return true;
        }
        return false;
    }
}