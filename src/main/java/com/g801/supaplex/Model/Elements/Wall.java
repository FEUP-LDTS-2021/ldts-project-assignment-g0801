package com.g801.supaplex.Model.Elements;

import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

public class Wall extends Model {

    public Wall(Position p){
        super.model = SpriteFactory.factoryMethod('W');
        super.pos = p;
    }
}
