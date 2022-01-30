package com.g801.supaplex.Viewer.Menu;

import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Viewer.GUI.GUI;
import com.g801.supaplex.Viewer.Viewer;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class MainMenuViewer extends Viewer<MainMenu> {

    public MainMenuViewer(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void drawModel(GUI gui) {

        Size size = gui.getSize();
        Screen screen = gui.getScreen();
        TextGraphics tg = screen.newTextGraphics();
        String title = "SUPAPL0X";
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
        gui.drawImages(getModel().getTextImagesList());
    }
}