package com.g801.supaplex.Viewer.MapViewer;

import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Viewer.GUI.GUI;
import com.g801.supaplex.Viewer.Viewer;
import com.googlecode.lanterna.TextColor;

public class DisplayViewer extends Viewer<Display> {

    public DisplayViewer(Display model) {
        super(model);
    }

    @Override
    public void drawModel(GUI gui) {

        Model[][] map = getModel().getDisplayMap();

        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {
                gui.drawTextImage(map[i][j].getPos(), map[i][j].getModel().getBitmap());
            }
        }

        /** gui.drawString(TextColor.ANSI.RED_BRIGHT,149, "Number of Infotrons: " + ?????getConfiguration().getCurrentInfotronsNumber().toString()) **/;
    }
}
