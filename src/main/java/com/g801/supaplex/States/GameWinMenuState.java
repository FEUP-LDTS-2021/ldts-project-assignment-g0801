package com.g801.supaplex.States;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Controller.GameWinMenuController;
import com.g801.supaplex.Model.Menu.GameWinMenu;
import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.Viewer.Menu.GameWinMenuViewer;
import com.g801.supaplex.Viewer.Viewer;

public class GameWinMenuState extends State<GameWinMenu> {

    public GameWinMenuState(GameWinMenu model) {
        super(model);
    }

    @Override
    protected Viewer<GameWinMenu> getViewer() {
        return new GameWinMenuViewer(getModel());
    }

    @Override
    protected Controller<GameWinMenu> getController() {
        return new GameWinMenuController(getModel());
    }
}
