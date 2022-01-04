
/*
import com.g801.supaplex.Model.Elements.Chip;
import com.g801.supaplex.Model.Elements.EndBlock;
import com.g801.supaplex.Model.Elements.Infotron;
/*package com.g801.supaplex

import com.g801.supaplex.Model.Elements.Chip
import com.g801.supaplex.Model.Elements.EndBlock
import com.g801.supaplex.Model.Elements.Infotron
>>>>>>> ebe630bc1443bf62c4d2f733d5735221519ce147
import com.g801.supaplex.Model.Elements.Murphy
import com.g801.supaplex.Model.Elements.Wall
import com.g801.supaplex.Model.Elements.Base
import com.g801.supaplex.Model.Models.Model
import com.g801.supaplex.Model.Position
import groovy.util.Factory;
import spock.lang.Specification

class FactoryTest extends Specification {

    Factory factory;

    def setup() {
        this.factory = new Factory();
    }

    def "Block Size"() {

        given:
        double a = 13;
        double b = 24;
        double c = 23;
        Base base = factory.getBaseBlock(a, b);
        Chip chip = factory.getChipBlock(a, b);
        EndBlock end = factory.getEndBlock(a, b);
        Infotron infotron = factory.getInfotron(a, b);
        Murphy murphy = factory.getMurphy(a, b);
        Wall wall = factory.getWall(a, b);
        def blocks = [base, chip, end, infotron, murphy, wall];

        assert blocks.every() { Model block ->
            block.getPos().getX() == a;
            block.getPos().getY() == b;
            block.getPos().equals(new Position(a, b));
        }

    }

    def "Base Block Colors"() {

        given:
        Base base = factory.getBaseBlock(10, 20);
        expect:
        c == base.getModel().getBitmap()[a][b];
        where:
        a | b | c
        1 | 2 | "#000000"
        3 | 5 | "#000000"
        0 | 0 | "#000000"
        4 | 9 | "#000000"
    }

    def "Chip Block Colors"() {

        given:
        Chip chip = factory.getChipBlock(23, 56);
        expect:
        c == chip.getModel().getBitmap()[a][b];
        where:
        a | b | c
        1 | 2 | "#919183"
        3 | 5 | "#919183"
        0 | 0 | "#919183"
        4 | 9 | "#919183"
    }

    def "End Block Colors"() {

        given:
        Endblock endblock = factory.getEndBlock(0, 0);
        expect:
        c == endblock.getModel().getBitmap()[a][b];
        where:
        a | b | c
        1 | 2 | "#FFFFFF"
        3 | 5 | "#FF9933"
        0 | 0 | "#FF9933"
        4 | 9 | "#FF9933"
        2 | 4 | "#FFFFFF"
    }

    def "Infotron Block Colors"() {

        given:
        Infotron infotron = factory.getInfotron(12, 12);
        expect:
        c == infotron.getModel().getBitmap()[a][b];
        where:
        a | b | c
        1 | 3 | "#FF0000"
        3 | 9 | "#0000FF"
        0 | 0 | "#336600"
        4 | 3 | "#00FF00"
    }

    def "Murphy Block Colors"() {

        given:
        Murphy murphy = factory.getMurphy(34, 34);
        expect:
        c == murphy.getModel().getBitmap()[a][b];
        where:
        a | b | c
        1 | 2 | "#FF0000"
        3 | 5 | "#FFFFFF"
        0 | 0 | "#336600"
        4 | 9 | "#336600"
        1 | 6 | "#FFFFFF"
    }

    def "Wall Block Colors"() {

        given:
        Wall wall = factory.getWall(0, 9);
        expect:
        c == wall.getModel().getBitmap()[a][b];
        where:
        a | b | c
        1 | 2 | "#919183"
        3 | 5 | "#919183"
        0 | 0 | "#919183"
    }

    def "Movements"() {

        given:
        Chip chip = factory.getChipBlock(12, 34);
        Infotron infotron = factory.getInfotron(12, 34);
        Murphy murphy = factory.getMurphy(12, 34);
        def entities = [chip, infotron, murphy];

        assert entities.every() {it ->
                it.getPos().addX(a);
            it.getPos().addY(b);
            it.getPos().getX() == c;
            it.getPos().getY() == d;
        }

        where:
        a | b   |  c  | d
        12 |  34 |  24 | 68
                -12 | -34 |   0 | 0
                -10 |  -3 |   2 | 31
        0 |   0 |  12 | 34
                -56 |  25 | -44 | 59
    }
<<<<<<< HEAD
}
*/
