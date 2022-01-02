package com.g801.supaplex.Viewer;

import com.g801.supaplex.Model.Menu.Menu;
import com.g801.supaplex.Viewer.GUI.GUI;

public class MenuViewer extends Viewer<Menu>{

    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawModel(GUI gui) {
        TitleViewer titleViewer = new TitleViewer();

        drawSingle(getModel().getTitle(), titleViewer, gui);
    }

    public <T> void drawSingle(T element, MenuElementViewer<T> viewer, GUI gui) {
        viewer.drawElement(element, gui);
    }


}
