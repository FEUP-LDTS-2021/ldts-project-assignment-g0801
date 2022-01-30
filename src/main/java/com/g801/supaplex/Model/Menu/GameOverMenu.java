package com.g801.supaplex.Model.Menu;

public class GameOverMenu extends Menu {

    public GameOverMenu() {
        super();
        this.selected = "RESTART LEVEL";
        String[] optString = {"RESTART LEVEL", "RETURN TO MENU"};
        this.optString = optString;
    }
}