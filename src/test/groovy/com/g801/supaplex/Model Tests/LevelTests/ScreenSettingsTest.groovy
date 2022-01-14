package com.g801.supaplex

import com.g801.supaplex.Model.Level.ScreenSettings
import com.g801.supaplex.Model.Position
import spock.lang.Specification

class ScreenSettingsTest extends Specification {

    private ScreenSettings screenSettings;

    def setup() {
        screenSettings = new ScreenSettings();
    }

    def "Initialization"() {

        expect:
            screenSettings.getWidth() == 15;
            screenSettings.getHeight() == 15;
            screenSettings.getMapBounds() == null;
            screenSettings.getXmin() == 0;
            screenSettings.getYmin() == 0;
    }

    def "Screen Map Bounds"() {

        when:
            screenSettings.setMapBounds(120, 240);
        then:
            screenSettings.getMapBounds().getX() == 120;
            screenSettings.getMapBounds().getY() == 240;
    }

    def "Screen set Y min"() {

        when:
            screenSettings.setYmin(10);
        then:
            screenSettings.getDisplayTopLeft().getY() == 10;
    }

    def "Screen set X min"() {

        when:
            screenSettings.setXmin(17);
        then:
            screenSettings.getDisplayTopLeft().getX() == 17;
    }

    def "Screen set Top Left"() {

        when:
            screenSettings.setDisplayTopleft(new Position(23, 67));
        then:
            screenSettings.getYmin() == 67;
            screenSettings.getXmin() == 23;
    }
}