package com.g801.supaplex.Viewer.Menu;

import com.g801.supaplex.Model.Menu.Menu;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Model.Text;
import com.g801.supaplex.Viewer.GUI.GUI;
import com.g801.supaplex.Viewer.Viewer;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.util.List;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawModel(GUI gui) {
        TitleViewer titleViewer = new TitleViewer();
        Size size = gui.getSize();
        Screen screen = gui.getScreen();
        TextGraphics tg = screen.newTextGraphics();

        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString((size.getWidth() - "SUPAPLEX".length())/ 2 + 1, 7, "SUPAPLEX", SGR.BOLD);

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

        tg.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
        for (String elem : getModel().getOptString()) {
            tg.putString((size.getWidth() - elem.length()) / 2 + 1, y, elem);
            y += 2;
        }
    }

    public <T> void drawSingle(T element, MenuElementViewer<T> viewer, GUI gui) {
        viewer.drawElement(element, gui);
    }


}
