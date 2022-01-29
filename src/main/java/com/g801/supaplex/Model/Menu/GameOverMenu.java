package com.g801.supaplex.Model.Menu;

import com.g801.supaplex.Model.Image;
import java.util.ArrayList;
import java.util.List;

public class GameOverMenu extends Menu {

    private final List<Image> textImagesList;

    public enum Option {RESTART, MENU_RET}

    public String[] optString = {"RESTART LEVEL", "RETURN TO MENU"};

    Option selected;

    Option[] options = Option.values();

    public GameOverMenu() {
        this.selected = Option.RESTART;
        this.textImagesList = new ArrayList<>();
        createImages(textImagesList);
    }

    public int getPosElem(Option target) {
        int i = 0;
        for (; options[i] != target; i++);
        return i;
    }

    public String enumToString(Option menuOption) {
        int pos = getPosElem(menuOption);
        return optString[pos];
    }

    public Option[] getOpt() {
        return options;
    }

    public Option getCurrentSelect() {
        return selected;
    }

    public List<Image> getTextImagesList() {
        return textImagesList;
    }

    public void upButton() {
        selected = selected == Option.RESTART ? Option.MENU_RET : Option.RESTART;
    }

    public void downButton() {
        selected = selected == Option.MENU_RET ? Option.RESTART : Option.MENU_RET;
    }
}
