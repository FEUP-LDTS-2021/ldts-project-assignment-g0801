package com.g801.supaplex
import com.g801.supaplex.Model.Aura.Aura
import com.g801.supaplex.Model.Elements.Murphy
import com.g801.supaplex.Model.Models.Sprite
import com.g801.supaplex.Model.Position;
import spock.lang.Specification;

class MurphyTest extends Specification {

    private Murphy murphy;
    private int x = 10;
    private int y = 20;

    def setup() {
        murphy = Murphy.getInstance();
        murphy.setPos(new Position(x, y));
    }

    def "Murphy initial Position"() {
        expect:
            murphy.getPos() == new Position(x, y);
    }

    def "Murphy Size"() {

        given:
            int height = murphy.getModel().getHeight();
            int width = murphy.getModel().getWidth();

        expect:
            height == Sprite.height;
            width == Sprite.width;
    }

    def "Murphy set Position"() {

        given:
            murphy.setPos(new Position(y, x));

        expect:
            murphy.getPos() != new Position(x, y);
            murphy.getPos() == new Position(y, x);
    }

    def "Murphy set Aura"() {

        given:
        Aura newAura = new Aura();
        when:
        murphy.setAura(newAura);
        then:
        murphy.getAura() == newAura;
    }

    def "Murphy Colors"() {

        given:
            char[][] bitmap = murphy.getModel().getBitmap();

        expect:
            bitmap[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'B'
            1 | 3 | 'A'
            1 | 6 | 'A'
            3 | 4 | 'W'
            3 | 6 | 'R'
    }
}