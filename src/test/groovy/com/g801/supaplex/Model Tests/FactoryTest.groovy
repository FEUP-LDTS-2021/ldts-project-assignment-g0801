package com.g801.supaplex

import com.g801.supaplex.Model.Factory;
import com.g801.supaplex.Model.Elements.Base
import com.g801.supaplex.Model.Models.Sprite;
import spock.lang.Specification

import java.sql.SQLOutput;

class FactoryTest extends Specification {

    Factory factory;

    def setup() {
        this.factory = new Factory();
    }

    def "Block Size"() {

        given:
            Base baseBlock = factory.getBaseBlock(11, 29);
        when:
            int x = baseBlock.getPos().getX();
            int y = baseBlock.getPos().getY();
        then:
            x == 11;
            y == 29;
    }

    def "Block Colors"() {

        given:
            Base baseBlock = factory.getBaseBlock(10, 20);
            String[][] bitmap = baseBlock.getModel().getBitmap()
        when:
            String color1 = bitmap[1][1];
            String color2 = bitmap[3][9];
        then:
            color1 == "#000000";
            color2 == "#000000";
    }

}