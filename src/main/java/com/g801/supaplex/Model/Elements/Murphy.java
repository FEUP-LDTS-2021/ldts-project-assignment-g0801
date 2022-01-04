package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Level.MurphyAura;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Models.Sprite;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;


public class Murphy extends Movable {
    private static Murphy m;
    private MurphyAura aura;

    private Murphy(){
        super.model = SpriteFactory.factoryMethod('M');
        super.pos = null;
    }

    public void setPosition(Position p){
        super.pos = p;
    }

    public static Murphy getInstance(){
        if(m == null)
            m = new Murphy();
        return m;
    }
}
