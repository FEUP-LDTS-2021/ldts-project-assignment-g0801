package com.g801.supaplex.Model.Menu;

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Menu.Elements.Image;

import java.util.ArrayList;
import java.util.List;

public class GameWinMenu extends Menu {

    private final List<Image> textImagesList;

    public enum Option {NEXT_LEVEL, MENU_RET, QUIT}

    public String[] optString = {"NEXT LEVEL", "RETURN TO MAIN MENU", "QUIT"}; // GET THE STRING ASSOCIATED TO THE ENUMERATOR

    Option selected;

    Option[] options = Option.values();

    private int currentSelect;

    public GameWinMenu() {
        this.selected = GameWinMenu.Option.NEXT_LEVEL;
        this.textImagesList = new ArrayList<>();
        createImages(textImagesList);
    }

    public int getPosElem(GameWinMenu.Option target) {
        int i = 0;
        for (; options[i] != target; i++);
        return i;
    }

    public String enumToString(GameWinMenu.Option menuOption) {
        int pos = getPosElem(menuOption);
        return optString[pos];
    }

    public void setSelected(GameWinMenu.Option selected) {
        this.selected = selected;
    }

    public GameWinMenu.Option[] getOpt() {
        return options;
    }

    public GameWinMenu.Option getCurrentSelect() {
        return selected;
    }

    public String[] getOptString() {
        return optString;
    }

    public List<Image> getTextImagesList() {
        return textImagesList;
    }

    public void upButton() {
        if (selected == Option.NEXT_LEVEL) selected = GameWinMenu.Option.QUIT;
        else {
            int i = getPosElem(selected);
            i--;
            selected = options[i];
        }
    }

    public void downButton() {
        if (selected == GameWinMenu.Option.QUIT) selected = Option.NEXT_LEVEL;
        else {
            int i = getPosElem(selected);
            i++;
            selected = options[i];
        }
    }
}
