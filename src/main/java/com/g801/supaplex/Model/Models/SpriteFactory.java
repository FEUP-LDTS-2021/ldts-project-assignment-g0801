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

class WallChipSprite extends Sprite {

    private static WallChipSprite sprite;

    private WallChipSprite(){
        Reader.fillSprite("Wall_Chip", this);
    }

    public static WallChipSprite getInstance(){
        if (sprite == null)
            sprite = new WallChipSprite();
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

class RockSprite extends Sprite {

    private static RockSprite rock;

    private RockSprite(){
        Reader.fillSprite("Rock", this);
    }

    public static RockSprite getInstance(){
        if (rock == null)
            rock = new RockSprite();
        return rock;
    }
}

public class SpriteFactory {

    public static Sprite factoryMethod(char c) {
        return switch (c) {
            case 'W' -> WallSprite.getInstance();
            case 'K' -> WallChipSprite.getInstance();
            case 'B' -> BaseSprite.getInstance();
            case 'C' -> ChipSprite.getInstance();
            case 'E' -> EndSprite.getInstance();
            case 'M' -> MurphySprite.getInstance();
            case 'I' -> InfotronSprite.getInstance();
            case 'X' -> ScissorsSprite.getInstance();
            case 'R' -> RockSprite.getInstance();

            default ->

                    // default something, retorna uma excepção de caracter inválido
                    null;
        };
        // temos de ter um return value após o switch?!
    }
}