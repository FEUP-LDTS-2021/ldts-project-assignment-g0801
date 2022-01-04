package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Aura.Aura;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

public class Murphy extends Movable {
    private static Murphy m;
    private Aura aura;

    private Murphy(){
        super.model = SpriteFactory.factoryMethod('M');
        super.pos = null;
    }

    public static Murphy getInstance(){
        if(m == null)
            m = new Murphy();
        return m;
    }
}
