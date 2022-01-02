package com.g801.supaplex.Viewer;

import com.g801.supaplex.Viewer.GUI.GUI;

public interface MenuElementViewer<T> {

    void drawElement(T element, GUI gui);
}
