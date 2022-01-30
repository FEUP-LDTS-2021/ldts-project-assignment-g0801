package com.g801.supaplex.Controller.Menu;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Menu.PauseMenu;
import com.g801.supaplex.States.GameState;
import com.g801.supaplex.Viewer.GUI.GUI;
import java.io.IOException;

public class PauseMenuController extends Controller<PauseMenu> {

    public PauseMenuController(PauseMenu model) {
        super(model);
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

        PauseMenu model = getModel();

        switch(keyaction) {
            case DOWN -> model.downButton();
            case UP -> model.upButton();
            case SELECT -> {
                switch (model.getCurrentSelect()) {
                    case "CONTINUE GAME" -> game.popState();
                    case "START" -> {
                        game.popState(); game.popState();
                        game.pushState(new GameState(new Display()));
                    }
                    case "QUIT" -> {
                        game.popState();
                        game.popState();
                    }
                }
            }
        }
    }
}