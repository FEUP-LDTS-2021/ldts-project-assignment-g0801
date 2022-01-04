package com.g801.supaplex.Controller.action;

import com.g801.supaplex.Model.Elements.Movable;

class MoveUp extends Action{

    public MoveUp(Movable m){
        super.movable = m;
        System.out.println("Move Up");
    }
}
class MoveDown extends Action{

    public MoveDown(Movable m){
        super.movable = m;
        System.out.println("Move Down");
    }
}

class MoveLeft extends Action{

    public MoveLeft(Movable m){
        super.movable = m;
        System.out.println("Move Left");
    }
}

class MoveRight extends Action{
    public MoveRight(Movable m){
        super.movable = m;
        System.out.println("Move Right");
    }
}

class EatUp extends Action{
    public EatUp(Movable m){
        super.movable = m;
        System.out.println("Eat Up");
    }
}

class EatDown extends Action{
    public EatDown(Movable m){
        super.movable = m;
        System.out.println("Eat Down");
    }
}

class EatLeft extends Action{
    public EatLeft(Movable m){
        super.movable = m;
        System.out.println("Eat Left");
    }
}

class EatRight extends Action{
    public EatRight(Movable m){
        super.movable = m;
        System.out.println("Eat Right");
    }
}

class Explode extends Action{
    public Explode(Movable m){
        super.movable = m;
        System.out.println("Explode");
    }
}

class WinGame extends Action{
    public WinGame(Movable m){
        super.movable = m;
        System.out.println("Win Game");
    }
}

//Eventually make this extend Explode
class LoseGame extends Action{
    public LoseGame(Movable m){
        super.movable = m;
        System.out.println("Lose Game");
    }
}

class GetInfo extends Action{
    public GetInfo(Movable m){
        super.movable = m;
        System.out.println("Get Info");
    }
}

//These two might not be needed
//class Fall extends Action{}
//class Flip extends Action{}


public class ActionFactory {
    public enum Actions{
        MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT,
        EAT_UP, EAT_DOWN, EAT_LEFT, EAT_RIGHT,
        EXPLODE, WIN_GAME, LOSE_GAME, GET_INFO;
    }
    
    private static Movable movable;

    public ActionFactory(Movable m){

        movable = m;
    }

    public static Action factoryMethod(Actions a){
        switch(a){
            default:
            case MOVE_UP : return new MoveUp(movable);
            case MOVE_DOWN : return new MoveDown(movable);
            case MOVE_LEFT : return new MoveLeft(movable);
            case MOVE_RIGHT : return new MoveRight(movable);
            case EAT_UP : return new EatUp(movable);
            case EAT_DOWN : return new EatDown(movable);
            case EAT_LEFT : return new EatLeft(movable);
            case EAT_RIGHT : return new EatRight(movable);
            case EXPLODE : return new Explode(movable);
            case WIN_GAME : return new WinGame(movable);
            case LOSE_GAME : return new LoseGame(movable);
            case GET_INFO : return new GetInfo(movable);
        }
    }
}
