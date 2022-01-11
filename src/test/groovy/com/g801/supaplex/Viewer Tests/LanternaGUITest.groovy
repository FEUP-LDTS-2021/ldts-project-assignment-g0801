package com.g801.supaplex

import com.g801.supaplex.Model.Size
import com.g801.supaplex.Viewer.GUI.LanternaGUI
import spock.lang.Specification

class LanternaGUITest extends Specification {

    private Size size;
    private LanternaGUI lanternaGUI;

    def setup() {
        size = new Size(100, 200);
        lanternaGUI = new LanternaGUI(size);
    }

    def "Initial configuration of Lanterna GUI"() {

        expect:
            lanternaGUI.getSize() == new Size(100, 200);
            lanternaGUI.getScreen() != null;
    }
}