package com.g801.supaplex

import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Viewer.GUI.GUI
import com.g801.supaplex.Viewer.GUI.LanternaGUI
import com.g801.supaplex.Viewer.Menu.MainMenuViewer
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen;
import spock.lang.Specification;

class MainMenuViewerTest extends Specification {

    private MainMenuViewer mainMenuViewer;
    private MainMenu mainMenu;
    private GUI gui;

    def setup() {
        gui = new LanternaGUI(new Size(10, 20));
        mainMenu = Mock(MainMenu.class);
        mainMenu.getOpt() >> MainMenu.Option;
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