package com.g801.supaplex

import com.g801.supaplex.Model.Elements.Wall
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Models.Model
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Viewer.GUI.GUI
import com.g801.supaplex.Viewer.GUI.LanternaGUI
import com.g801.supaplex.Viewer.MapViewer.DisplayViewer;
import com.g801.supaplex.Viewer.Viewer
import spock.lang.Specification

class DisplayViewerTest extends Specification {

    private Display display;
    private GUI gui;
    private DisplayViewer displayViewer;

    def setup() {
        display = Mock(Display.class);
        gui = Mock(LanternaGUI.class);
        Model[][] map = new Model[9][8];
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 8 ; j++) {
                map[i][j] = new Wall(new Position(9, 10));
            }
        }
        display.getDisplayMap() >> map;
        displayViewer = new DisplayViewer(display);
    }

    def "Draw Model Content"() {

        when:
            displayViewer.drawModel(gui);

        then:
            1 * display.getDisplayMap();
            72 * gui.drawTextImage(new Position(9, 10), _ );

    }
}