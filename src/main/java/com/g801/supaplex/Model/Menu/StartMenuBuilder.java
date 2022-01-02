package com.g801.supaplex.Model.Menu;


import com.g801.supaplex.Model.Menu.MenuElem.Title;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Model.Size;
import com.g801.supaplex.Model.Text;

public class StartMenuBuilder extends MenuBuilder {

    public StartMenuBuilder(Size size) {
        super(size);
    }

    @Override
    protected Title createTitle() {
        Title title = new Title(new Position(size.getWidth() / 2 - 3, size.getHeight() / 8),
                new Text("SUPAPLEX", "#000000", "#ff2222"));

        return title;
    }
}
