package com.g801.supaplex.Model.Menu;

import com.g801.supaplex.Model.Image;
import java.util.ArrayList;
import java.util.List;

public class GameWinMenu extends Menu {

    private final List<Image> textImagesList;

    public enum Option {NEXT_LEVEL, MENU_RET, QUIT}

    public String[] optString = {"NEXT LEVEL", "RETURN TO MAIN MENU", "QUIT"}; // GET THE STRING ASSOCIATED TO THE ENUMERATOR

    Option selected;

    Option[] options = Option.values();

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
        return optString[getPosElem(menuOption)];
    }

    public GameWinMenu.Option[] getOpt() {
        return options;
    }

    public GameWinMenu.Option getCurrentSelect() {
        return selected;
    }

    public List<Image> getTextImagesList() {
        return textImagesList;
    }

    public void upButton() {
        selected = getPosElem(selected) == 0 ? options[2] : options[(getPosElem(selected)-1) % 3];
    }

    public void downButton() {
        selected = options[(getPosElem(selected)+1) % 3];
    }
}
