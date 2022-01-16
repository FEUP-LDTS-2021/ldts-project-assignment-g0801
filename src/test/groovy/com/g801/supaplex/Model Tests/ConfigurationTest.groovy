package com.g801.supaplex

import com.g801.supaplex.Model.Elements.Murphy
import com.g801.supaplex.Model.Position
import spock.lang.Specification;
import com.g801.supaplex.Model.Configuration;

class ConfigurationTest extends Specification {

    private Configuration configuration;
    private Murphy murphy;
    private Position bounds;

    def setup() {
        configuration = Configuration.getInstance();
        murphy = Mock(Murphy.class);
        bounds = new Position(24, 15);
    }

    def "Initial configurations"() {

        given:
            configuration.setMapBounds(24, 15);

        expect:
            configuration.getCurrentLevel() == 1;
            configuration.getScreenLowerBound() != null;
            configuration.getMapBounds() == new Position(24, 15);
    }

    def "Murphy is in the middle of the map"() {

        given:
            murphy.getPos() >> new Position(11, 7);

        when:
            configuration.updateSettings(murphy);

        then:
            configuration.getXmin() == 4;
            configuration.getYmin() == 2;
    }

    def "Murphy is in the upper left corner"() {

        given:
            murphy.getPos() >> new Position(3, 2);

        when:
            configuration.updateSettings(murphy);

        then:
            configuration.getXmin() == 0;
            configuration.getYmin() == 0;
    }

    def "Murphy is in the upper right corner"() {

        given:
            murphy.getPos() >> new Position(22, 2);

        when:
            configuration.updateSettings(murphy);

        then:
            configuration.getXmin() == 9;
            configuration.getYmin() == 0;
    }

    def "Murphy is in the lower left corner"() {

        given:
            murphy.getPos() >> new Position(4, 12);

        when:
            configuration.updateSettings(murphy);

        then:
            configuration.getXmin() == 0;
            configuration.getYmin() == 5;
    }

    def "Murphy is in the lower right corner"() {

        given:
            murphy.getPos() >> new Position(24, 14);

        when:
            configuration.updateSettings(murphy);

        then:
            configuration.getXmin() == 9;
            configuration.getYmin() == 5;
    }

    def "Increasing current level"() {

        expect:
            while (a) {
                configuration.increaseCurrentLevel()
                a--;
            };
            configuration.getCurrentLevel() == b;
        where:
            a | b
            1 | 2
            2 | 4
            3 | 2
            1 | 3
    }

    def "Decreasing current level"() {

        expect:
            while (a) {
                configuration.lowerCurrentLevel()
                a--;
            };
            configuration.getCurrentLevel() == b;
        where:
            a | b
            1 | 2
            2 | 5
            3 | 2
            4 | 3
    }
}