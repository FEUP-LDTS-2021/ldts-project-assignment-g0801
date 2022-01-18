package com.g801.supaplex.States;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Controller.GameOverMenuController;
import com.g801.supaplex.Model.Menu.GameOverMenu;
import com.g801.supaplex.Viewer.Menu.GameOverMenuViewer;
import com.g801.supaplex.Viewer.Viewer;

public class GameOverState extends State<GameOverMenu> {

    public GameOverState(GameOverMenu model) {
        super(model);
    }

    @Override
    protected Viewer<GameOverMenu> getViewer() {
        return new GameOverMenuViewer(getModel());
    }

    @Override
    protected Controller<GameOverMenu> getController() {
        return new GameOverMenuController(getModel());
    }
}
