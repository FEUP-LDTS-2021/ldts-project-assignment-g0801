package com.g801.supaplex.Model.Menu.MenuElem;

import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Model.Text;

public class Title extends MenuElement{

    private Text text;

    public Title(Position position, Text text) {
        super(position);
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

}
