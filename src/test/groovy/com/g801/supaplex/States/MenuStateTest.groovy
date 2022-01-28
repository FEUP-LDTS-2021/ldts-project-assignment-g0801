package com.g801.supaplex.States

import com.g801.supaplex.Controller.Menu.MainMenuController
import com.g801.supaplex.Model.Menu.MainMenu
import com.g801.supaplex.Viewer.Menu.MainMenuViewer
import spock.lang.Specification;

class MenuStateTest extends Specification {

    def "Menu States"() {

        given:
            MenuState menuState = new MenuState(new MainMenu());
        expect:
            menuState.getModel() instanceof MainMenu;
            menuState.getViewer() instanceof MainMenuViewer;
            menuState.getController() instanceof MainMenuController;
    }
}