package com.g801.supaplex.Viewer;

import com.g801.supaplex.Model.Menu.MenuElem.Title;
import com.g801.supaplex.Viewer.GUI.GUI;

public class TitleViewer implements MenuElementViewer<Title>{

    @Override
    public void drawElement(Title element, GUI gui) {
        gui.drawText(element.getPosition(), element.getText());
    }
}
