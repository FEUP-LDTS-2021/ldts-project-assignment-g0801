package com.g801.supaplex.Controller;

import com.g801.supaplex.Model.Elements.Movable;
import com.g801.supaplex.Model.Elements.Murphy;


//This should be generalized to any Movable which it gets from constructor
public class Action {

    public enum Actions {
        MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT,
        EAT_UP, EAT_DOWN, EAT_LEFT, EAT_RIGHT,
        EXPLODE
    }

    //Make this a movable instead of a murphy
    private static Movable movable;

    public Action(Movable m){
        movable = m;
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

    public Movable getMovable() { return movable;}

    public Action() {};

    public void factory(Actions a) {
        if (movable.canMove(a)) {
            switch (a) {
                case MOVE_UP -> movable.moveUp();
                case MOVE_DOWN -> movable.moveDown();
                case MOVE_LEFT -> movable.moveLeft();
                case MOVE_RIGHT -> movable.moveRight();
                case EAT_UP -> eatUp();
                case EAT_DOWN -> eatDown();
                case EAT_LEFT -> eatLeft();
                case EAT_RIGHT -> eatRight();
                case EXPLODE -> explode();
            }
            movable.updateAura();
        }
    }
}