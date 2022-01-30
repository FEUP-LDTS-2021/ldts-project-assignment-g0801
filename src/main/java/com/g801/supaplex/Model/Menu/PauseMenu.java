package com.g801.supaplex.Model.Menu;

public class PauseMenu extends Menu {

    public PauseMenu() {
        super();
        this.selected = "CONTINUE GAME";
        String[] optString = {"CONTINUE GAME", "RESTART", "RETURN TO MENU"};
        this.optString = optString;
    }
}