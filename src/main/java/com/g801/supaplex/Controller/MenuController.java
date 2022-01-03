package com.g801.supaplex.Controller;

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Menu.Menu;
import com.g801.supaplex.Viewer.GUI.GUI;

import java.io.IOException;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException {
        switch(keyaction) {
            case DOWN:
                getModel().downButton();
                break;
            case UP:
                getModel().upButton();
                break;
            case SELECT:
                switch(getModel().getCurrentSelect()) {
                    case START:
                        //game start
                        break;
                    case LEVEL:
                        break;
                    case EXIT:
                        System.exit(1);
                        break;
                }

        }
    }
}
