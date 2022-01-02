package com.g801.supaplex.Model.Menu;

import com.g801.supaplex.Model.Size;

import java.io.IOException;

abstract public class MenuBuilder {

    protected final Size size;

    public MenuBuilder(Size size) {
        this.size = size;
    }

    public Menu createMenu() throws IOException {
        Menu menu = new Menu();
        return menu;
    }
}
