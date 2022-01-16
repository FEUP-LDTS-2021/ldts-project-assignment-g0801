package com.g801.supaplex.Controller;

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Menu.PauseMenu;
import com.g801.supaplex.States.PauseMenuState;
import com.g801.supaplex.Viewer.GUI.GUI;

import java.io.IOException;

public class GameController extends Controller <Display> {
    private final MurphyController murphyController;

    public GameController(Display model) {
        super(model);
        this.murphyController = new MurphyController(model);
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {

        switch(keyaction) {
            case PAUSE -> game.pushState(new PauseMenuState(new PauseMenu()));
            /** case UP:
             *  case DOWN:
             *  case LEFT:
             *  case RIGHT:
             */
            default -> murphyController.execute(game, keyaction, time);
        }

    }
}
