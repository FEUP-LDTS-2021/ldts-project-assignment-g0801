package com.g801.supaplex.Viewer.Menu;


import com.g801.supaplex.Model.Menu.SelectLevelMenu;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Viewer.GUI.GUI;
import com.g801.supaplex.Viewer.Viewer;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
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

        //CORNERS
        tg.setForegroundColor(TextColor.ANSI.YELLOW).setCharacter(65,8, Symbols.DOUBLE_LINE_BOTTOM_LEFT_CORNER);
        tg.setCharacter(65, 5, Symbols.DOUBLE_LINE_TOP_LEFT_CORNER);
        tg.setCharacter(85, 8, Symbols.DOUBLE_LINE_BOTTOM_RIGHT_CORNER);
        tg.setCharacter(85, 5, Symbols.DOUBLE_LINE_TOP_RIGHT_CORNER);

        // HORIZONTAL LINES
        tg.drawLine(66, 8, 84, 8, Symbols.DOUBLE_LINE_HORIZONTAL);
        tg.drawLine(66, 5,84,5, Symbols.DOUBLE_LINE_HORIZONTAL);

        // VERTICAL LINES
        tg.drawLine(65, 7,65 ,6, Symbols.DOUBLE_LINE_VERTICAL);
        tg.drawLine(85,7,85, 6, Symbols.DOUBLE_LINE_VERTICAL);

        int y = 10;

        for (SelectLevelMenu.Option elem : getModel().getOpt()) {
            if (getModel().getCurrentSelect() == elem) {
                gui.drawString(TextColor.ANSI.BLUE_BRIGHT, y, getModel().enumToString(elem));
            }
            else gui.drawString(TextColor.ANSI.RED_BRIGHT, y, getModel().enumToString(elem));
            y += 2;
        }
        gui.drawString(TextColor.ANSI.RED_BRIGHT, y, "CURRENT LVL: " + getModel().getConfiguration().getCurrentLevel());
    }
}
