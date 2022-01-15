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

    def "Eat Up"() {

        when:
            action.factory(Action.Actions.EAT_UP);
        then:
            1 * movable.eatUp();
            1 * movable.updateAura();
    }
    def "Eat Down"() {

        when:
            action.factory(Action.Actions.EAT_DOWN);
        then:
            1 * movable.eatDown();
            1 * movable.updateAura();
    }

    def "Eat Left"() {

        when:
            action.factory(Action.Actions.EAT_LEFT);
        then:
            1 * movable.eatLeft();
            1 * movable.updateAura();
    }

    def "Eat Right"() {

        when:
            action.factory(Action.Actions.EAT_RIGHT);
        then:
            1 * movable.eatRight();
            1 * movable.updateAura();
    }

    def "Explode"() {

        when:
            action.factory(Action.Actions.EXPLODE);
        then:
            1 * movable.explode();
            1 * movable.updateAura();
    }
}