package com.g801.supaplex

import com.g801.supaplex.Controller.Action
import com.g801.supaplex.Model.Elements.Movable
import spock.lang.Specification

class ActionTest extends Specification {

    private Action action;
    private Movable movable;

    def setup() {
        movable = Mock(Movable.class);
        movable.canMove(_) >> true;
        action = new Action(movable);
    }

    def "Initial configuration"() {

        expect:
            movable.canMove(Action.Actions.MOVE_LEFT);
            action.getMovable().equals(movable);
    }

    def "Move Left"() {

        when:
            action.factory(Action.Actions.MOVE_LEFT);
        then:
            1 * movable.moveLeft();
            1 * movable.updateAura();
    }

    def "Move Right"() {

        when:
            action.factory(Action.Actions.MOVE_RIGHT);
        then:
            1 * movable.moveRight();
            1 * movable.updateAura();
    }

    def "Move Up"() {

        when:
            action.factory(Action.Actions.MOVE_UP);
        then:
            1 * movable.moveUp();
            1 * movable.updateAura();
    }

    def "Move Down"() {

        when:
            action.factory(Action.Actions.MOVE_DOWN);
        then:
            1 * movable.moveDown();
            1 * movable.updateAura();
    }
}