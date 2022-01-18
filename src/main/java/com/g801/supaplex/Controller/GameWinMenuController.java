package com.g801.supaplex.Controller;

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Menu.GameWinMenu;
import com.g801.supaplex.States.GameState;
import com.g801.supaplex.Viewer.GUI.GUI;

import java.io.IOException;

public class GameWinMenuController extends Controller<GameWinMenu> {

    public GameWinMenuController(GameWinMenu model) {
        super(model);
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {
        switch(keyaction) {
            case DOWN:
                getModel().downButton();
                break;
            case UP:
                getModel().upButton();
                break;
            case SELECT:
                switch (getModel().getCurrentSelect()) {
                    case NEXT_LEVEL -> {
                        Configuration.getInstance().increaseCurrentLevel();
                        game.pushState(new GameState(new Display()));
                    }
                    case MENU_RET -> {
                        game.popState();
                        game.popState();
                    }
                    case QUIT -> System.exit(0);
                }
        }
    }
}