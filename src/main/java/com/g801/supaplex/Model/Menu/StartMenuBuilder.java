package com.g801.supaplex.Model.Menu;

import com.g801.supaplex.Model.Size;

public class StartMenuBuilder extends MenuBuilder {

    public static final String menuBackGround = "#21455D";
    public static final String menuForeGround = "#5DD67E";
    public static final String selectedBackGround = "#1C8EC0";
    public static final String selectedForeGround = "#E2DF1A";

    public StartMenuBuilder(Size size) {
        super(size);
    }

    public String options[] =  {"START", "SELECT_LEVEL", "QUIT"};

    public String[] getOptions() {
        return options;
    }
}