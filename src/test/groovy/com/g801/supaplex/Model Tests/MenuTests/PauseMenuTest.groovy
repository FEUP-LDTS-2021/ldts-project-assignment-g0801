package com.g801.supaplex

import com.g801.supaplex.Model.Image
import com.g801.supaplex.Model.Menu.PauseMenu
import spock.lang.Specification;

class PauseMenuTest extends Specification {

    private PauseMenu menu;

    def setup() {
        menu = new PauseMenu();
    }

    def "Initial Pause menu State"() {

        expect:
            menu.getCurrentSelect() == PauseMenu.Option.CONTINUE;
            menu.getTextImagesList().size() == 21;
    }

    def "Position of options in menu"() {

        expect:
            menu.getPosElem(a) == b;

        where:
            a                           | b
            PauseMenu.Option.CONTINUE   | 0
            PauseMenu.Option.RESTART    | 1
            PauseMenu.Option.QUIT       | 2
    }

    def "Getting a string with options"() {

        expect:
            menu.enumToString(a) == b;

        where:
            a                           | b
            PauseMenu.Option.CONTINUE   | "CONTINUE GAME"
            PauseMenu.Option.RESTART    | "RESTART"
            PauseMenu.Option.QUIT       | "QUIT"
    }

    def "Select another option"() {

        when:
            menu.setSelected(PauseMenu.Option.RESTART);
        then:
            menu.getCurrentSelect() == PauseMenu.Option.RESTART;

        when:
            menu.setSelected(PauseMenu.Option.QUIT );
        then:
            menu.getCurrentSelect() == PauseMenu.Option.QUIT;
    }

    def "Return all options"() {

        expect:
            menu.getOpt()[a] == b

        where:
            a | b
            0 | PauseMenu.Option.CONTINUE
            1 | PauseMenu.Option.RESTART
            2 | PauseMenu.Option.QUIT
    }

    def "Return all string options"() {

        expect:
            menu.getOptString()[a] == b

        where:
            a | b
            0 | "CONTINUE GAME"
            1 | "RESTART"
            2 | "QUIT"
    }

    def "Upper Button Click"() {

        expect:
            menu.setSelected(a);
            menu.upButton();
            menu.getCurrentSelect() == b;

        where:
                                      a | b
            PauseMenu.Option.CONTINUE   | PauseMenu.Option.QUIT
            PauseMenu.Option.QUIT       | PauseMenu.Option.RESTART
            PauseMenu.Option.RESTART    | PauseMenu.Option.CONTINUE
    }

    def "Down Button Click"() {

        expect:
            menu.setSelected(a);
            menu.downButton();
            menu.getCurrentSelect() == b;

        where:
                                      a | b
            PauseMenu.Option.CONTINUE   | PauseMenu.Option.RESTART
            PauseMenu.Option.RESTART    | PauseMenu.Option.QUIT
            PauseMenu.Option.QUIT       | PauseMenu.Option.CONTINUE

    }

    def "Images content"() {

        given:
        List<Image> allImages = menu.getTextImagesList();

        expect:
        allImages.size() == 21;
        for (Image image : allImages) {
            assert image.getBitMap() != null
            assert image.getPosition() != null
        }
    }
}