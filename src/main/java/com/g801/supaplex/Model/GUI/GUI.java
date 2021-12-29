package com.g801.supaplex.Model.GUI;

import com.g801.supaplex.Model.Size;

import java.io.IOException;

public interface GUI {

    enum KEYACTION {
        UP, DOWN, LEFT, RIGHT,
        EAT_UP, EAT_DOWN, EAT_LEFT, EAT_RIGHT,
        SELECT, PAUSE, RESTART, SKIP,
        QUIT, CLOSE, NONE
    }

    KEYACTION getNextAction() throws IOException;

//    void drawCharacter();
//    void drawText(...);
//    void drawTextImage(...);
//    void drawRectangle(...);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    Size getSize();
}
