package com.g801.supaplex.Viewer.Menu;

import com.g801.supaplex.Model.Menu.Elements.Image;
import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Viewer.GUI.GUI;
import com.g801.supaplex.Viewer.Viewer;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;
import java.util.List;

public class MainMenuViewer extends Viewer<MainMenu> {

    public MainMenuViewer(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void drawModel(GUI gui) throws IOException {

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

        for (MainMenu.Option elem : getModel().getOpt()) {
            if (getModel().getCurrentSelect() == elem) {
                gui.drawString(TextColor.ANSI.BLUE_BRIGHT, y, getModel().enumToString(elem));
            }
            else gui.drawString(TextColor.ANSI.RED_BRIGHT, y, getModel().enumToString(elem));
            y += 2;
        }

        drawImages(getModel().getTextImagesList(), gui);
    }

    public void drawImages(List<Image> elements, GUI gui) {
        for (Image img : elements) {
            gui.drawTextImage(img.getPosition(), img.getBitMap());
        }
    }
}
