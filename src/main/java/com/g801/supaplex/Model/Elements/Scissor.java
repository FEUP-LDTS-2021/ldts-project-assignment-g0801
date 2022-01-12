package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Position;

public class Scissor extends Movable{

    public Scissor(Position p){}

    @Override
    //Checks if scissor collides with something
    public boolean checkCollision() {
        return false;
    }

    //Makes scissor spin
    public void spin(){}
}
