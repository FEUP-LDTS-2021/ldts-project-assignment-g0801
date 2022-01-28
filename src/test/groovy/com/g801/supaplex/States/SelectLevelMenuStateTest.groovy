package com.g801.supaplex.States

import com.g801.supaplex.Controller.Menu.SelectLevelMenuController
import com.g801.supaplex.Model.Configuration
import com.g801.supaplex.Model.Menu.SelectLevelMenu
import com.g801.supaplex.Viewer.Menu.SelectMenuViewer
import spock.lang.Specification;

class SelectLevelMenuStateTest extends Specification {

    def "Select Level States"() {

        given:
            SelectLevelMenuState levelState = new SelectLevelMenuState(new SelectLevelMenu(new Configuration()));
        expect:
            levelState.getModel() instanceof SelectLevelMenu;
            levelState.getViewer() instanceof SelectMenuViewer;
            levelState.getController() instanceof SelectLevelMenuController;
    }
}