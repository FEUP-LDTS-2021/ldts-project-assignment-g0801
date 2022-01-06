package com.g801.supaplex.Controller;

import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Menu.PauseMenu;
import com.g801.supaplex.Viewer.GUI.GUI;
import java.io.IOException;

public class PauseMenuController extends Controller<PauseMenu> {

    public PauseMenuController(PauseMenu model) {
        super(model);
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
                switch (getModel().getCurrentSelect()) {
                    case CONTINUE -> game.popState();
                    /** case RESTART ->  ERA UMA IDEIA FIXE DE IMPLEMENTAR MAIS PARA A FRENTE **/
                    case QUIT -> System.exit(0);
                }
        }
    }
}
