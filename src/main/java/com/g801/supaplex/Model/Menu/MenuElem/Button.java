package com.g801.supaplex.Model.Menu.MenuElem;

import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Model.Text;

public class Button extends MenuElement {

    private final ACTION action;
    private boolean highlight;
    private Text text;
    private Size size;

    public Button(Position position, ACTION action, Text text, Size size) {
        super(position);
        this.action = action;
        this.text = text;
        this.size = size;
        this.highlight = false;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public boolean getHighlighted() {
        return highlight;
    }

    public void setHighlighted() {
        highlight = true;
    }

    public void setNotHighlighted() {
        highlight = false;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public ACTION getAction() {
        return action;
    }


    public enum ACTION {
        START, SELECT_LEVEL, QUIT, NONE
    }
}
