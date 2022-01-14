package com.g801.supaplex

import com.g801.supaplex.Model.Elements.Movable
import com.g801.supaplex.Model.Models.Sprite
import com.g801.supaplex.Model.Position;
import spock.lang.Specification

class MovableTest extends Specification {

    private Movable movable;
    private int x = Sprite.width;
    private int y = Sprite.height;
    private int originalX = 10;
    private int originalY = 10;

    def setup () {
        movable = new Movable();
        movable.setPos(new Position(originalX, originalY));
    }

    def "initial state"() {

        expect:
            movable.getPos() == new Position(originalX, originalX);
            movable.getModel() != null;
    }

    def "Move Left"() {

        when:
            movable.moveLeft();
        then:
            movable.getPos() == new Position(originalX - x, originalY);
    }

    def "Move Right"() {

        when:
            movable.moveRight();
        then:
            movable.getPos() == new Position(originalX + x, originalY);
    }

    def "Move Up"() {

        when:
            movable.moveUp();
        then:
            movable.getPos() == new Position(originalX, originalY - y);
    }

    def "Move Down"() {

        when:
            movable.moveDown();
        then:
            movable.getPos() == new Position(originalX, originalY + y);
    }
}