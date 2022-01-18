package com.g801.supaplex.Controller.Display;

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Elements.Base;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Elements.Scissors;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Menu.GameOverMenu;
import com.g801.supaplex.States.GameOverState;
import com.g801.supaplex.Viewer.GUI.GUI;

import java.io.IOException;

public class ScissorController extends ElementController {

    public ScissorController(Display model) {
        super(model);
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

        for (Scissors elem : getModel().getScissorList()) {
            if (canMove(elem, game)) {
                switch(elem.getDirection()) {
                    case RIGHT -> elem.moveRight();
                    case LEFT -> elem.moveLeft();
                    case UP -> elem.moveUp();
                    case DOWN -> elem.moveDown();
                }
                getModel().updateScissor(elem);
            }
        }
    }
    public boolean canMove(Scissors elem, Game game) {
        boolean ret = false;
        if (elem.getPos().equals(getModel().getMurphy())) System.exit(0);
        switch (elem.getDirection()) {
            case RIGHT -> {
                if (getModel().getMap()[elem.getPos().getRight().getY()][elem.getPos().getRight().getX()] instanceof Base)
                    ret = true;
                else if (getModel().getMap()[elem.getPos().getRight().getY()][elem.getPos().getRight().getX()] instanceof Murphy) game.pushState(new GameOverState(new GameOverMenu()));
                else  {
                    elem.setDirection(Scissors.Direction.DOWN);
                    elem.setSprite('1');
                }
            }
            case LEFT -> {
                if (getModel().getMap()[elem.getPos().getLeft().getY()][elem.getPos().getLeft().getX()] instanceof Base)
                    ret = true;
                else if (getModel().getMap()[elem.getPos().getLeft().getY()][elem.getPos().getLeft().getX()] instanceof Murphy) game.pushState(new GameOverState(new GameOverMenu()));
                else {
                    elem.setDirection(Scissors.Direction.UP);
                    elem.setSprite('X');
                }
            }
            case UP -> {
                if (getModel().getMap()[elem.getPos().getUp().getY()][elem.getPos().getUp().getX()] instanceof Base)
                    ret = true;
                else if (getModel().getMap()[elem.getPos().getUp().getY()][elem.getPos().getUp().getX()] instanceof Murphy) game.pushState(new GameOverState(new GameOverMenu()));
                else {
                    elem.setDirection(Scissors.Direction.RIGHT);
                    elem.setSprite('2');
                }
            }
            case DOWN -> {
                if (getModel().getMap()[elem.getPos().getDown().getY()][elem.getPos().getDown().getX()] instanceof Base)
                    ret = true;
                else if (getModel().getMap()[elem.getPos().getDown().getY()][elem.getPos().getDown().getX()] instanceof Murphy) ;
                else {
                    elem.setDirection(Scissors.Direction.LEFT);
                    elem.setSprite('3');
                }
            }
        }
        return ret;
    }
}
