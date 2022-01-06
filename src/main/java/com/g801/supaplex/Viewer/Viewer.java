package com.g801.supaplex.Viewer;

import com.g801.supaplex.Model.Menu.Elements.Image;
import com.g801.supaplex.Viewer.GUI.GUI;

import java.io.IOException;
import java.util.List;

abstract public class Viewer <T> {

    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawModel(gui);
        gui.refresh();
    }

    public abstract void drawModel(GUI gui) throws IOException;

    public T getModel() {
        return model;
    }

    public void drawImages(List<Image> elements, GUI gui) {
        for (Image img : elements) {
            gui.drawTextImage(img.getPosition(), img.getBitMap());
        }
    }
}