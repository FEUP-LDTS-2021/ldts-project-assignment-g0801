package com.g801.supaplex.Controller.Menu;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Menu.SelectLevelMenu;
import com.g801.supaplex.Viewer.GUI.GUI;

import java.io.IOException;

public class SelectLevelMenuController extends Controller<SelectLevelMenu> {

    public SelectLevelMenuController(SelectLevelMenu model) {
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
                    case LOWER -> getModel().getConfiguration().lowerCurrentLevel();
                    case INCREASE -> getModel().getConfiguration().increaseCurrentLevel();
                    case BACK -> game.popState();
                }
        }
    }
}
