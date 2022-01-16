package com.g801.supaplex

import com.g801.supaplex.Controller.PauseMenuController
import com.g801.supaplex.Model.Menu.PauseMenu
import com.g801.supaplex.States.PauseMenuState
import com.g801.supaplex.Viewer.Menu.PauseMenuViewer;
import spock.lang.Specification;

class PauseMenuStateTest extends Specification {

    def "Pause Menu States"() {

        given:
            PauseMenuState pauseMenuState = new PauseMenuState(new PauseMenu());
        expect:
            pauseMenuState.getModel() instanceof PauseMenu;
            pauseMenuState.getViewer() instanceof PauseMenuViewer;
            pauseMenuState.getController() instanceof PauseMenuController;
    }
}