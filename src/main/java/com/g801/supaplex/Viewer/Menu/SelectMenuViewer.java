package com.g801.supaplex.Viewer.Menu;

import com.g801.supaplex.Model.Menu.SelectLevelMenu;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Viewer.GUI.GUI;
import com.g801.supaplex.Viewer.Viewer;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class SelectMenuViewer extends Viewer <SelectLevelMenu> {

    public SelectMenuViewer(SelectLevelMenu model) {
        super(model);
    }

    @Override
    public void drawModel(GUI gui)  {

        Size size = gui.getSize();
        Screen screen = gui.getScreen();
        TextGraphics tg = screen.newTextGraphics();
        String title = "SELECT LEVEL";
        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString((size.getWidth() - title.length())/ 2 + 1, 7, title, SGR.BOLD);
        gui.drawTitleBorder();

        int y = 10;

        for (String elem : getModel().getOptString()) {
            if (getModel().getCurrentSelect() == elem) {
                gui.drawStringCentered(TextColor.ANSI.BLUE_BRIGHT, y, elem);
            } else gui.drawStringCentered(TextColor.ANSI.RED_BRIGHT, y, elem);
            y += 2;
        }
        gui.drawStringCentered(TextColor.ANSI.RED_BRIGHT, y, "CURRENT LVL: " + getModel().getConfiguration().getCurrentLevel());
        gui.drawImages(getModel().getTextImagesList());
    }
}
