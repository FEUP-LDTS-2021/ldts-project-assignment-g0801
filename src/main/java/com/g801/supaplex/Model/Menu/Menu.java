package com.g801.supaplex.Model.Menu;

import com.g801.supaplex.Model.Menu.MenuElem.Button;
import com.g801.supaplex.Model.Menu.MenuElem.Title;

import java.util.List;

public class Menu {

    public enum Option {START, LEVEL, EXIT};

    public String[] optString = {"START GAME", "SELECT LEVEL", "QUIT"};

    Option selected;

    Option[] opt = Option.values();

    private Title title;
    private List<Button> buttons;
    private int currentSelect;

    public Menu() {
        this.currentSelect = 0;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public int getPosElem(Option target) {
        int i = 0;
        for (; opt[i] != target; i++);
        return i;
    }

    public String enumToString(Option menuOption) {
        int pos = getPosElem(menuOption);
        return optString[pos];
    }

    public void setSelected(Option selected) {
        this.selected = selected;
    };

    public Option[] getOpt() {
        return opt;
    }

    public String[] getOptString() {
        return optString;
    }
}
