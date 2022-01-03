package com.g801.supaplex.States;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Controller.MenuController;
import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.Viewer.Menu.MainMenuViewer;
import com.g801.supaplex.Viewer.Viewer;

public class MenuState extends State<MainMenu> {
    public MenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MenuController(getModel());
    }
}
