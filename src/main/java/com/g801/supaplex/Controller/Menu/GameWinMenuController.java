package com.g801.supaplex.Controller.Menu;

import com.g801.supaplex.Controller.Controller;
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

        GameWinMenu model = getModel();

        switch(keyaction) {
            case DOWN -> model.downButton();
            case UP -> model.upButton();
            case SELECT -> {
                switch (model.getCurrentSelect()) {
                    case NEXT_LEVEL -> {
                        game.popState();
                        game.popState();
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
}