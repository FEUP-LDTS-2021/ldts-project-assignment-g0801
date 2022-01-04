package com.g801.supaplex.Controller;

import com.g801.supaplex.Model.Elements.Movable;
import com.g801.supaplex.Model.Elements.Murphy;

public class Action {

    public enum Actions {
        MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT,
        EAT_UP, EAT_DOWN, EAT_LEFT, EAT_RIGHT,
        EXPLODE
    }

    private final Movable movable = Murphy.getInstance();

    private static void up() {
        //Checks if murphy can move up
            //YES : moves murphy up
            //NO :  does nothing
    }


    private static void down() {
    }

    private static void right() {
    }

    private static void left() {
    }

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
        return movable;
    }

    public Action() {};

    public void factory(Actions a) {
        switch (a) {
            case MOVE_UP -> up();
            case MOVE_DOWN -> down();
            case MOVE_LEFT -> left();
            case MOVE_RIGHT -> right();
            case EAT_UP -> eatUp();
            case EAT_DOWN -> eatDown();
            case EAT_LEFT -> eatLeft();
            case EAT_RIGHT -> eatRight();
            case EXPLODE -> explode();
        }
    }
}