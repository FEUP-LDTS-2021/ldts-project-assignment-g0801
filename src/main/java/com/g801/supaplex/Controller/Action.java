package com.g801.supaplex.Controller;

import com.g801.supaplex.Model.Elements.Movable;
import com.g801.supaplex.Model.Elements.Murphy;

public class Action {

    public enum Actions {
        MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT,
        EAT_UP, EAT_DOWN, EAT_LEFT, EAT_RIGHT,
        EXPLODE
    }

    private static final Murphy murphy = Murphy.getInstance();


    private static void eatUp() {
    }

    private static void eatDown() {
    }

    private static void eatLeft() {
    }

    private static void eatRight() {
    }

    private static void explode() {
    }

    public Movable getMovable() {
        return murphy;
    }

    public Action() {};

    public void factory(Actions a) {
        if (murphy.canMove(a)) {
            switch (a) {
                case MOVE_UP -> murphy.moveUp();
                case MOVE_DOWN -> murphy.moveDown();
                case MOVE_LEFT -> murphy.moveLeft();
                case MOVE_RIGHT -> murphy.moveRight();
                case EAT_UP -> eatUp();
                case EAT_DOWN -> eatDown();
                case EAT_LEFT -> eatLeft();
                case EAT_RIGHT -> eatRight();
                case EXPLODE -> explode();
            }
            murphy.updateAura();
        }
    }
}