package com.g801.supaplex.Model.Menu;

public class Menu {

    public enum Option {START, LEVEL, EXIT};

    public Option[] options = {Option.START, Option.LEVEL, Option.EXIT};

    public String[] optString = {"START", "SELECT LEVEL", "QUIT"}; // GET THE STRING ASSOCIATED TO THE ENUMERATOR

    Option selected;

    Option[] opt = Option.values();

    private int currentSelect;

    public Menu() {
        this.selected = Option.START;
    }

    public Option[] getOptions() {
        return options;
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

    public Option getCurrentSelect() {
        return selected;
    }

    public String[] getOptString() {
        return optString;
    }


    public void upButton() {
        if (selected == Option.START) selected = Option.EXIT;
        else {
            int i = getPosElem(selected);
            i--;
            selected = opt[i];
        }
    }

    public void downButton() {
        if (selected == Option.EXIT) selected = Option.START;
        else {
            int i = getPosElem(selected);
            i++;
            selected = opt[i];
        }
    }
}
