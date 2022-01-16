package com.g801.supaplex

import com.g801.supaplex.Model.Configuration
import com.g801.supaplex.Model.Elements.Base
import com.g801.supaplex.Model.Elements.Murphy
import com.g801.supaplex.Model.Models.Model
import com.g801.supaplex.Model.Models.SpriteFactory
import com.g801.supaplex.Model.Position
import spock.lang.Specification;
import com.g801.supaplex.Model.Level.Display;

class DisplayTest extends Specification {

    private SpriteFactory spriteFactory;
    private Display display;
    private Position position;
    private Murphy murphy;

    def setup() {
        Configuration config = Mock(Configuration.class);
        config.getCurrentLevel() >> 1;
        position = new Position(10, 10);
        murphy = new Murphy(position);
        display = new Display();
        List<Model> answer = new ArrayList<Model>()
        for (int i = 0 ; i < 4 ; i++) answer.push(new Model());
        display.getAura(position) >> answer;
    }

    def "Getting Aura by Position"() {

        when:
            List<Model> answer = display.getAura(murphy);
        then:
            answer.size() == 4;
            answer.get(0).getPos() == new Position(10, 9);
            answer.get(1).getPos() == new Position(10, 11);
            answer.get(2).getPos() == new Position(9, 10);
            answer.get(3).getPos() == new Position(11, 10);
    }

    def "Updating blocks"() {

        when:
            murphy.getPos().addX(1);
            display.update(murphy, new Position(position));
            List<Model> answer = display.getAura(murphy);

        then:
            answer[position.getX()][position.getY()] instanceof Base;
            answer[position.getX()+1][position.getY()] == murphy;
    }

    def "Getting Display Map"() {

        when:
            Configuration configuration = Configuration.getInstance();
            Model[][] map = display.getDisplayMap();

        then:
            map[0].length == configuration.getWidth();
            map.length == configuration.getHeight();
    }

    def "Getting Infotron Counter"() {

        expect:
            display.getInfotronCount() == 0;
    }

    def "Block Size"() {

        expect:
            display.getBlockSize() == new Position(5, 10);
    }
}