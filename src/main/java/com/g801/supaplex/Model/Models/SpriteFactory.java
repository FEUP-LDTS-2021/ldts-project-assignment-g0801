package com.g801.supaplex.Model.Models;

class WallSprite extends Sprite{
    private static WallSprite sprite;

    private WallSprite(){
        //Reads from file
    }

    public static WallSprite getInstance(){
        if(sprite == null)
            sprite = new WallSprite();
        return sprite;
    }
}

class MurphySprite extends Sprite{
    private static MurphySprite sprite;

    private MurphySprite(){
        //Reads from file
    }

    public static MurphySprite getInstance(){
        if(sprite == null)
            sprite = new MurphySprite();
        return sprite;
    }
}

class BaseSprite extends Sprite{
    private static BaseSprite sprite;

    private BaseSprite(){
        //Reads from file
    }

    public static BaseSprite getInstance(){
        if(sprite == null)
            sprite = new BaseSprite();
        return sprite;
    }
}

class ChipSprite extends Sprite{
    private static ChipSprite sprite;

    private ChipSprite(){
        //Reads from file
    }

    public static ChipSprite getInstance(){
        if(sprite == null)
            sprite = new ChipSprite();
        return sprite;
    }
}

class EndSprite extends Sprite{
    private static EndSprite sprite;

    private EndSprite(){
        //Reads from file
    }

    public static EndSprite getInstance(){
        if(sprite == null)
            sprite = new EndSprite();
        return sprite;
    }
}

public class SpriteFactory {
    public static Sprite factoryMethod(char c){
        switch(c){
            default:
            case 'W' : return WallSprite.getInstance();
            case 'B' : return BaseSprite.getInstance();
            case 'C' : return ChipSprite.getInstance();
            case 'E' : return EndSprite.getInstance();
            case 'M' : return MurphySprite.getInstance();
        }
    }
}
