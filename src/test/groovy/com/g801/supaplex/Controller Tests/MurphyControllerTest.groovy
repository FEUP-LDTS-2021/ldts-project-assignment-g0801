package com.g801.supaplex

import com.g801.supaplex.Controller.MurphyController;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Viewer.GUI.GUI;
import spock.lang.Specification;

class MurphyControllerTest extends Specification {

    private Murphy murphy;
    private MurphyController murphyController;

    def setup() {
        murphy = Mock(Murphy.class);
        murphyController = new MurphyController(murphy);
    }

    def "Murphy moves Down"() {

        when:
            murphyController.makeMove(GUI.KEYACTION.DOWN);
        then:
            1 * murphy.moveDown();
    }

    def "Murphy moves Pp"() {

        when:
            murphyController.makeMove(GUI.KEYACTION.UP);
        then:
            1 * murphy.moveUp();
    }

    def "Murphy moves Left"() {

        when:
            murphyController.makeMove(GUI.KEYACTION.LEFT);
        then:
            1 * murphy.moveLeft();
    }

    def "Murphy moves Right"() {

        when:
            murphyController.makeMove(GUI.KEYACTION.RIGHT);
        then:
            1 * murphy.moveRight();
    }

    def "Murphy moves down"() {

        when:
        murphyController.makeMove(GUI.KEYACTION.DOWN);
        then:
        1 * murphy.moveDown();
    }

    def "Murphy eats Down"() {

        when:
            murphyController.makeMove(GUI.KEYACTION.EAT_DOWN);
        then:
            1 * murphy.eatDown();
    }

    def "Murphy eats Up"() {

        when:
            murphyController.makeMove(GUI.KEYACTION.EAT_UP);
        then:
            1 * murphy.eatUp();
    }

    def "Murphy eats Right"() {

        when:
            murphyController.makeMove(GUI.KEYACTION.EAT_RIGHT);
        then:
            1 * murphy.eatRight();
    }

    def "Murphy eats Left"() {

        when:
            murphyController.makeMove(GUI.KEYACTION.EAT_LEFT);
        then:
            1 * murphy.eatLeft();
    }
}