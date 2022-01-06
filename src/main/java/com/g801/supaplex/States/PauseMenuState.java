package com.g801.supaplex.States;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Controller.PauseMenuController;
import com.g801.supaplex.Model.Menu.PauseMenu;
import com.g801.supaplex.Viewer.Menu.PauseMenuViewer;
import com.g801.supaplex.Viewer.Viewer;

public class PauseMenuState extends State<PauseMenu>  {

    public PauseMenuState(PauseMenu model) {
        super(model);
    }

    @Override
    protected Viewer<PauseMenu> getViewer() {
        return new PauseMenuViewer(getModel());
    }

    @Override
    protected Controller<PauseMenu> getController() {
        return new PauseMenuController(getModel());
    }
}
