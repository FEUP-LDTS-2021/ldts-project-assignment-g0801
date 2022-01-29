package com.g801.supaplex.Model.Menu;

import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Image;
import java.util.ArrayList;
import java.util.List;

public class SelectLevelMenu extends Menu {

    Configuration configuration;

    private final List<Image> textImagesList;

    public enum Option {LOWER, INCREASE, BACK}

    public String[] optString = {"LOWER", "INCREASE", "BACK"};

    Option selected;

    Option[] options = Option.values();

    public SelectLevelMenu(Configuration configuration) {
        this.selected = getOpt()[0];
        this.configuration = configuration;
        this.textImagesList = new ArrayList<>();
        createImages(textImagesList);

    }

    public Option[] getOpt() {
        return options;
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

    public Configuration getConfiguration() {
        return configuration;
    }

    public List<Image> getTextImagesList() {
        return textImagesList;
    }
}