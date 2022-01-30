package com.g801.supaplex.Model.Menu;
public class MainMenu extends Menu {

    public MainMenu() {
        super();
        this.selected = "START";
        String[] optString = {"START", "SELECT LEVEL", "QUIT"};
        this.optString = optString;
    }
}
