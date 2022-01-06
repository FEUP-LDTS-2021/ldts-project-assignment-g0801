package com.g801.supaplex.Viewer.MapViewer;

import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Viewer.GUI.GUI;

public class ElementViewer {
    public void drawElement(Model element, GUI gui, Position position) {
        gui.drawTextImage(position, element.getModel().getBitmap());
    }
}
