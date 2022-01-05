package com.g801.supaplex.Model.Models;
import com.g801.supaplex.Model.Reader;

class WallSprite extends Sprite {

    private static WallSprite sprite;

    private WallSprite(){
        Reader.fillSprite("Wall", this);
    }

    public static WallSprite getInstance(){
        if (sprite == null)
            sprite = new WallSprite();
        return sprite;
    }
}

class MurphySprite extends Sprite {

    private static MurphySprite sprite;

    public MurphySprite(){
        Reader.fillSprite("Murphy", this);
    }

    public static MurphySprite getInstance(){
        if (sprite == null)
            sprite = new MurphySprite();
        return sprite;
    }
}

class BaseSprite extends Sprite {

    private static BaseSprite sprite;

    private BaseSprite(){
        Reader.fillSprite("Base", this);
    }

    public static BaseSprite getInstance(){
        if (sprite == null)
            sprite = new BaseSprite();
        return sprite;
    }
}

class ChipSprite extends Sprite {

    private static ChipSprite sprite;

    private ChipSprite(){
        Reader.fillSprite("Chip", this);
    }

    public static ChipSprite getInstance(){
        if (sprite == null)
            sprite = new ChipSprite();
        return sprite;
    }
}

class EndSprite extends Sprite {

    private static EndSprite sprite;

    private EndSprite(){
        Reader.fillSprite("EndBlock", this);
    }

    public static EndSprite getInstance(){
        if (sprite == null)
            sprite = new EndSprite();
        return sprite;
    }
}

class ScissorsSprite extends Sprite {
    private static ScissorsSprite sprite;
    private ScissorsSprite() { Reader.fillSprite("Scissor", this);}
    public static ScissorsSprite getInstance(){
        if (sprite == null)
            sprite = new ScissorsSprite();
        return sprite;
    }
}

class InfotronSprite extends Sprite {

    private static InfotronSprite sprite;

    private InfotronSprite(){
        Reader.fillSprite("Infotron", this);
    }

    public static InfotronSprite getInstance(){
        if (sprite == null)
            sprite = new InfotronSprite();
        return sprite;
    }
}

public class SpriteFactory {

    public static Sprite factoryMethod(char c) {
        switch(c){
            case 'W' : return WallSprite.getInstance();
            case 'B' : return BaseSprite.getInstance();
            case 'C' : return ChipSprite.getInstance();
            case 'E' : return EndSprite.getInstance();
            case 'M' : return MurphySprite.getInstance();
            case 'I' : return InfotronSprite.getInstance();
            case 'X' : return ScissorsSprite.getInstance();
            // default something, retorna uma excepção de caracter inválido
        }
        return null; // temos de ter um return value após o switch?!
    }
}