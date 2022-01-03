package com.g801.supaplex.Model.Menu;

public class SelectLevelMenu {

    public enum Option {LOWER, INCREASE, BACK};

    public String[] optString = {"LOWER", "INCREASE", "BACK"}; // GET THE STRING ASSOCIATED TO THE ENUMERATOR

    Option selected;

    Option[] options = Option.values();

    private int currentSelect;

    private int currentLevelSelect;

    public SelectLevelMenu() {
        this.selected = getOpt()[0];
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
        int pos = getPosElem(menuOption);
        return optString[pos];
    }

    public void setSelected(Option selected) {
        this.selected = selected;
    };

    public Option getCurrentSelect() {
        return selected;
    }

    public String[] getOptString() {
        return optString;
    }

    public void upButton() {
        if (selected == Option.LOWER) selected = Option.BACK;
        else {
            int i = getPosElem(selected);
            i--;
            selected = options[i];
        }
    }

    public void downButton() {
        if (selected == Option.BACK) selected = Option.LOWER;
        else {
            int i = getPosElem(selected);
            i++;
            selected = options[i];
        }
    }
}
