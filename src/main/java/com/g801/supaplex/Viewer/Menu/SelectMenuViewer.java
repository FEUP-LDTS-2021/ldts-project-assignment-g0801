package com.g801.supaplex.Viewer.Menu;


import com.g801.supaplex.Model.Menu.SelectLevelMenu;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Viewer.GUI.GUI;
import com.g801.supaplex.Viewer.Viewer;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class SelectMenuViewer extends Viewer <SelectLevelMenu> {

    public SelectMenuViewer(SelectLevelMenu model) {
        super(model);
    }

    @Override
    public void drawModel(GUI gui) throws IOException {
        gui.clear();
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
                tg.setForegroundColor(TextColor.ANSI.BLUE);
            }
            else {
                tg.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
            }
            tg.putString((size.getWidth() - getModel().enumToString(elem).length()) / 2 + 1, y, getModel().enumToString(elem));
            y += 2;
        }

        tg.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
        tg.putString((size.getWidth() - "Current Level:".length()) / 2, y, "Current Level: " + getModel().getConfiguration().getCurrentLevel());
        y += 2;

        gui.refresh();
    }
}
