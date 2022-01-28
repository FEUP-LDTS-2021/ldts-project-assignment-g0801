package com.g801.supaplex.Controller.Menu;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.Model.Menu.SelectLevelMenu;
import com.g801.supaplex.States.GameState;

import com.g801.supaplex.States.SelectLevelMenuState;

import com.g801.supaplex.Viewer.GUI.GUI;

import java.io.IOException;

public class MainMenuController extends Controller<MainMenu> {

    public MainMenuController(MainMenu mainMenu) {
        super(mainMenu);
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
                    case START -> game.pushState(new GameState(new Display()));
                    case LEVEL -> game.pushState(new SelectLevelMenuState(new SelectLevelMenu(game.getConfiguration())));
                    case EXIT -> System.exit(0);
                }
        }
    }
}
