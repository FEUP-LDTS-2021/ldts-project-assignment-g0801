package com.g801.supaplex.Model.Menu;

public class SelectLevelMenu extends Menu {

    public SelectLevelMenu() {
        super();
        this.selected = "LOWER";
        String[] optString = {"LOWER", "INCREASE", "BACK"};
        this.optString = optString;
    }
}