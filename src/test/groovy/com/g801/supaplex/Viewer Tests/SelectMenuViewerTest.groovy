package com.g801.supaplex

import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Viewer.GUI.GUI
import com.g801.supaplex.Viewer.Menu.MainMenuViewer;
import com.googlecode.lanterna.screen.TerminalScreen
import spock.lang.Specification;

class SelectMenuViewerTest extends Specification {

    private MainMenuViewer mainMenuViewer;
    private MainMenu mainMenu;
    private GUI gui;

    def setup() {
        TerminalScreen screen = new TerminalScreen(new Size(40, 60));
        gui = Mock(GUI.class);
        gui.getScreen() >> screen;
        gui.getSize() >> new Size(10, 20);
        mainMenu = Mock(MainMenu.class);
        mainMenuViewer = new MainMenuViewer(mainMenu);
    }

    def "Draw Model configuration"() {

        when:
            mainMenuViewer.drawModel(gui);

        then:
            1 * gui.getScreen();
            1 * gui.getSize();
    }
}