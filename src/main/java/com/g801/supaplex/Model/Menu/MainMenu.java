package com.g801.supaplex.Model.Menu;

import com.g801.supaplex.Model.Image;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu {

    private final List<Image> textImagesList;

    public enum Option {START, LEVEL, EXIT}

    public String[] optString = {"START", "SELECT LEVEL", "QUIT"};

    Option selected;

    Option[] options = Option.values();

    public MainMenu() {
        this.selected = Option.START;
        this.textImagesList = new ArrayList<>();
        createImages(textImagesList);
    }

    public int getPosElem(Option target) {
        int i = 0;
        for (; options[i] != target; i++);
        return i;
    }

    public String enumToString(Option menuOption) {
        return optString[getPosElem(menuOption)];
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

    public void upButton() {
        selected = getPosElem(selected) == 0 ? options[2] : options[(getPosElem(selected)-1) % 3];
    }

    public void downButton() {
        selected = options[(getPosElem(selected)+1) % 3];
    }

    public List<Image> getTextImagesList() {
        return textImagesList;
    }
}
