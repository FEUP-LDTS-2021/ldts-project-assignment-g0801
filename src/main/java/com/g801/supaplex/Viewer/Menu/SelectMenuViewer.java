package com.g801.supaplex.Viewer.Menu;


import com.g801.supaplex.Model.Menu.SelectLevelMenu;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Viewer.GUI.GUI;
import com.g801.supaplex.Viewer.Viewer;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class SelectMenuViewer extends Viewer <SelectLevelMenu> {

    public SelectMenuViewer(SelectLevelMenu model) {
        super(model);
    }

    @Override
    public void drawModel(GUI gui) throws IOException {
        Size size = gui.getSize();
        Screen screen = gui.getScreen();
        TextGraphics tg = screen.newTextGraphics();

        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString((size.getWidth() - "SELECT LEVEL".length())/ 2 + 1, 7, "SELECT LEVEL", SGR.BOLD);

        // drawing double line box
        gui.drawTitleBorder();

        int y = 10;

        for (SelectLevelMenu.Option elem : getModel().getOpt()) {
            if (getModel().getCurrentSelect() == elem) {
                gui.drawStringCentered(TextColor.ANSI.BLUE_BRIGHT, y, getModel().enumToString(elem));
            }
            else gui.drawStringCentered(TextColor.ANSI.RED_BRIGHT, y, getModel().enumToString(elem));
            y += 2;
        }
        gui.drawStringCentered(TextColor.ANSI.RED_BRIGHT, y, "CURRENT LVL: " + getModel().getConfiguration().getCurrentLevel());

        gui.drawImages(getModel().getTextImagesList());
    }
}
