package com.g801.supaplex.Model.Menu;

public class GameWinMenu extends Menu {

    public GameWinMenu() {
        super();
        this.selected = "NEXT LEVEL";
        String[] optString = {"NEXT LEVEL", "RETURN TO MAIN MENU", "QUIT"};
        this.optString = optString;
    }
}
