package com.g801.supaplex.States;

import com.g801.supaplex.Controller.Controller;
import com.g801.supaplex.Controller.MenuController;
import com.g801.supaplex.Controller.SelectLevelMenuController;
import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.Model.Menu.SelectLevelMenu;

import com.g801.supaplex.Viewer.Menu.SelectMenuViewer;
import com.g801.supaplex.Viewer.Viewer;

public class SelectLevelMenuState extends State<SelectLevelMenu>{

        public SelectLevelMenuState(SelectLevelMenu model) {
            super(model);
        }

        @Override
        protected Viewer<SelectLevelMenu> getViewer() {
            return new SelectMenuViewer(getModel());
        }

        @Override
        protected Controller<SelectLevelMenu> getController() {
            return new SelectLevelMenuController(getModel());
        }

}
