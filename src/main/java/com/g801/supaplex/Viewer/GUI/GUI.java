package com.g801.supaplex.Viewer.GUI;

import com.g801.supaplex.Model.Menu.Elements.Image;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Model.Text;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;
import java.util.List;

public interface GUI {

    enum KEYACTION {
        UP, DOWN, LEFT, RIGHT,
        EAT_UP, EAT_DOWN, EAT_LEFT, EAT_RIGHT,
        SELECT, PAUSE, RESTART, SKIP,
        QUIT, CLOSE, NONE
    }

    KEYACTION getNextAction() throws IOException;

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    Size getSize();

    void drawRectangle(Position position);

    void drawString(TextColor color, int row, String s);

    void drawTextImage(Position position, char[][] textImage);

    TerminalScreen getScreen();

    void drawImages(List<Image> elements);

    void drawTitleBorder();
}
