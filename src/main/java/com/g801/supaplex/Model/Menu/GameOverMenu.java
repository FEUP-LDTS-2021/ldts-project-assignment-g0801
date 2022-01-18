package com.g801.supaplex.Model.Menu;

import com.g801.supaplex.Model.Image;

import java.util.ArrayList;
import java.util.List;

public class GameOverMenu extends Menu {

    private final List<Image> textImagesList;

    public enum Option {RESTART, MENU_RET}

    public String[] optString = {"RESTART LEVEL", "RETURN TO MENU"}; // GET THE STRING ASSOCIATED TO THE ENUMERATOR

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

    public void setSelected(Option selected) {
        this.selected = selected;
    }

    public Option[] getOpt() {
        return options;
    }

    public Option getCurrentSelect() {
        return selected;
    }

    public String[] getOptString() {
        return optString;
    }

    public List<Image> getTextImagesList() {
        return textImagesList;
    }

    public void upButton() {
        if (selected == Option.RESTART) selected = Option.MENU_RET;
        else {
            int i = getPosElem(selected);
            i--;
            selected = options[i];
        }
    }

    public void downButton() {
        if (selected == Option.MENU_RET) selected = Option.RESTART;
        else {
            int i = getPosElem(selected);
            i++;
            selected = options[i];
        }
    }
}
