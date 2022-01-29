package com.g801.supaplex.Model.Menu;

import com.g801.supaplex.Model.Image;
import java.util.ArrayList;
import java.util.List;

public class PauseMenu extends Menu {

    private final List<Image> textImagesList;

    public enum Option {CONTINUE, RESTART, QUIT}

    public String[] optString = {"CONTINUE GAME", "RESTART", "RETURN TO MENU"};

    PauseMenu.Option selected;

    PauseMenu.Option[] options = PauseMenu.Option.values();

    public PauseMenu() {
        this.selected = PauseMenu.Option.CONTINUE;
        this.textImagesList = new ArrayList<>();
        createImages(textImagesList);
    }

    public int getPosElem(PauseMenu.Option target) {
        int i = 0;
        for (; options[i] != target; i++);
        return i;
    }

    public String enumToString(PauseMenu.Option menuOption) {
        return optString[getPosElem(menuOption)];
    }

    public void setSelected(PauseMenu.Option selected) {
        this.selected = selected;
    }

    public PauseMenu.Option[] getOpt() {
        return options;
    }

    public PauseMenu.Option getCurrentSelect() {
        return selected;
    }

    public String[] getOptString() {
        return optString;
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
