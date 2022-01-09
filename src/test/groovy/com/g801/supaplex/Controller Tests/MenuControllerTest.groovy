package com.g801.supaplex
import com.g801.supaplex.Controller.MenuController
import com.g801.supaplex.Game
import com.g801.supaplex.Model.Menu.MainMenu
import com.g801.supaplex.Viewer.GUI.GUI;
import spock.lang.Specification;

class MenuControllerTest extends Specification {

    private MenuController menuController;
    private MainMenu mainMenu;
    private Game game;
    private time = 900000;

    def setup() {
        game = Mock(Game.class);
        mainMenu = Mock(MainMenu.class);
        menuController = new MenuController(mainMenu);
    }

    def "Main Menu receives DOWN key pressed"() {

        when:
            menuController.execute(game, GUI.KEYACTION.DOWN, time);
        then:
            1 * mainMenu.downButton();
    }

    def "Main Menu receives UP key pressed"() {

        when:
            menuController.execute(game, GUI.KEYACTION.UP, time);
        then:
            1 * mainMenu.upButton();
    }

    def "Let's begin the game"() {

        given:
            mainMenu.getCurrentSelect() >> MainMenu.Option.START;
        when:
            menuController.execute(game, GUI.KEYACTION.SELECT, time);
        then:
            1 * game.run();
    }

    def "Let's select a level"() {

        given:
            mainMenu.getCurrentSelect() >> MainMenu.Option.LEVEL;
        when:
            menuController.execute(game, GUI.KEYACTION.SELECT, time);
        then:
            1 * game.pushState(_);
            1 * game.getConfiguration();
    }
}