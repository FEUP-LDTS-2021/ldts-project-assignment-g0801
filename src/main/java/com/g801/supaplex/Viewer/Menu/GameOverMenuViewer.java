package com.g801.supaplex.Viewer.Menu;

import com.g801.supaplex.Model.Menu.GameOverMenu;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Viewer.GUI.GUI;
import com.g801.supaplex.Viewer.Viewer;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class GameOverMenuViewer extends Viewer<GameOverMenu> {

    public GameOverMenuViewer(GameOverMenu model) {
        super(model);
    }

    @Override
    public void drawModel(GUI gui) {

        Size size = gui.getSize();
        Screen screen = gui.getScreen();
        TextGraphics tg = screen.newTextGraphics();
        String title = " YOU LOST :( ";
        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString((size.getWidth() - title.length())/ 2 + 1, 7, title, SGR.BOLD);
        gui.drawTitleBorder();

        int y = 10;

        for (GameOverMenu.Option elem : getModel().getOpt()) {
            if (getModel().getCurrentSelect() == elem) {
                gui.drawStringCentered(TextColor.ANSI.BLUE_BRIGHT, y, getModel().enumToString(elem));
            }  else gui.drawStringCentered(TextColor.ANSI.RED_BRIGHT, y, getModel().enumToString(elem));
            y += 2;
        }
        gui.drawImages(getModel().getTextImagesList());
    }
}