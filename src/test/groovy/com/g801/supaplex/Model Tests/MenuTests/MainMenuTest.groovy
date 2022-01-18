package com.g801.supaplex

import com.g801.supaplex.Model.Image
import com.g801.supaplex.Model.Menu.MainMenu
import spock.lang.Specification;

class MainMenuTest extends Specification {

    private MainMenu menu;

    def setup() {
        menu = new MainMenu();
    }

    def "Initial menu State"() {

        expect:
            menu.getCurrentSelect() == MainMenu.Option.START;
            menu.getTextImagesList().size() == 21;
    }

    def "Position of options in menu"() {

        expect:
            menu.getPosElem(a) == b;

        where:
            a                     | b
            MainMenu.Option.START | 0
            MainMenu.Option.LEVEL | 1
            MainMenu.Option.EXIT  | 2
    }

    def "Getting a string with options"() {

        expect:
            menu.enumToString(a) == b;

        where:
            a                     | b
            MainMenu.Option.START | "START"
            MainMenu.Option.LEVEL | "SELECT LEVEL"
            MainMenu.Option.EXIT  | "QUIT"
    }

    def "Select another option"() {

        when:
            menu.setSelected(MainMenu.Option.LEVEL);
        then:
            menu.getCurrentSelect() == MainMenu.Option.LEVEL;

        when:
            menu.setSelected(MainMenu.Option.EXIT);
        then:
            menu.getCurrentSelect() == MainMenu.Option.EXIT;
    }

    def "Return all options"() {

        expect:
            menu.getOpt()[a] == b

        where:
            a | b
            0 | MainMenu.Option.START
            1 | MainMenu.Option.LEVEL
            2 | MainMenu.Option.EXIT
    }

    def "Return all string options"() {

        expect:
            menu.getOptString()[a] == b

        where:
            a | b
            0 | "START"
            1 | "SELECT LEVEL"
            2 | "QUIT"
    }

    def "Upper Button Click"() {

        expect:
            menu.setSelected(a);
            menu.upButton();
            menu.getCurrentSelect() == b;

        where:
                                a | b
            MainMenu.Option.START | MainMenu.Option.EXIT
            MainMenu.Option.LEVEL | MainMenu.Option.START
            MainMenu.Option.EXIT  | MainMenu.Option.LEVEL
    }

    def "Down Button Click"() {

        expect:
            menu.setSelected(a);
            menu.downButton();
            menu.getCurrentSelect() == b;

        where:
                                a | b
            MainMenu.Option.START | MainMenu.Option.LEVEL
            MainMenu.Option.LEVEL | MainMenu.Option.EXIT
            MainMenu.Option.EXIT  | MainMenu.Option.START

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