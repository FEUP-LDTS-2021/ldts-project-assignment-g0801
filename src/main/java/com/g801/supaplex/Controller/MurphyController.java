package com.g801.supaplex.Controller;

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Elements.EndBlock;
import com.g801.supaplex.Model.Elements.Infotron;
import com.g801.supaplex.Model.Elements.Rock;
import com.g801.supaplex.Model.Elements.Wall;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Menu.PauseMenu;
import com.g801.supaplex.Model.Position;
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
            switch(keyaction) {
                case DOWN -> this.getModel().getMurphy().moveDown();
                case UP -> this.getModel().getMurphy().moveUp();
                case LEFT -> this.getModel().getMurphy().moveLeft();
                case RIGHT -> this.getModel().getMurphy().moveRight();
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
                if (getModel().getMap()[pos.getUp().getY()][pos.getUp().getX()] instanceof EndBlock && getModel().getInfotronCount() == 0) game.pushState(new PauseMenuState(new PauseMenu()));
                if (getModel().getMap()[pos.getUp().getY()][pos.getUp().getX()] instanceof Infotron) getModel().decrementInfotronCount();
            }
            case DOWN -> {
                if (getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()] instanceof Wall) ret = false;
                if (getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()] instanceof Rock) ret = false;
                if (getModel().getMap()[pos.getDown().getY()][pos.getDown().getX()] instanceof Infotron) getModel().decrementInfotronCount();
            }
            case LEFT -> {
                if (getModel().getMap()[pos.getLeft().getY()][pos.getLeft().getX()] instanceof Wall) ret = false;
                if (getModel().getMap()[pos.getLeft().getY()][pos.getLeft().getX()] instanceof Rock) ret = false;
                if (getModel().getMap()[pos.getLeft().getY()][pos.getLeft().getX()] instanceof Infotron) getModel().decrementInfotronCount();
            }
            case RIGHT -> {
                if (getModel().getMap()[pos.getRight().getY()][pos.getRight().getX()] instanceof Wall) ret = false;
                if (getModel().getMap()[pos.getRight().getY()][pos.getRight().getX()] instanceof Rock) ret = false;
                if (getModel().getMap()[pos.getRight().getY()][pos.getRight().getX()] instanceof Infotron) getModel().decrementInfotronCount();
            }
        }
        return ret;
    }
}