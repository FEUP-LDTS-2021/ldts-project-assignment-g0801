package com.g801.supaplex.Viewer.Menu;

import com.g801.supaplex.Model.Menu.Elements.Image;
import com.g801.supaplex.Viewer.GUI.GUI;

import java.util.List;

abstract public class MenuViewer {

    public void drawImages(List<Image> elements, GUI gui) {
        for (Image img : elements) {
            gui.drawTextImage(img.getPosition(), img.getBitMap());
        }
    }
}
