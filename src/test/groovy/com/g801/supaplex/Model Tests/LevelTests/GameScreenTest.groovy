package com.g801.supaplex
import com.g801.supaplex.Model.Configuration
import com.g801.supaplex.Model.Elements.Murphy
import com.g801.supaplex.Model.Level.GameScreen
import com.g801.supaplex.Model.Position
import spock.lang.Specification;

class GameScreenTest extends Specification {

    private GameScreen gameScreen;
    private int level = 10;

    def setup() {
        Murphy murphy = Murphy.getInstance();
        murphy.setPos(new Position(10, 20));
        Configuration configuration = Configuration.getInstance();
        gameScreen = new GameScreen();
    }

    def "Initial Configuration of GameScreen"() {

        expect:
            gameScreen.getConfigs().x == 5;
            gameScreen.getConfigs().y == 3;
            gameScreen.getConfigs().yMin == 2;
            gameScreen.getConfigs().xMin == 8;
            gameScreen.getConfigs().yMax == 8;
            gameScreen.getConfigs().xMax == 19;
    }

    def "Getting all map"() {

        given:
            Character[][] map = gameScreen.getMap();
        expect:
            map.length == 10;
            map[0].length == 43;
    }

    def "Getting visible screen"() {

        given:
            Character[][] screen = gameScreen.getMap();
        expect:
            screen.length == 50;
            screen[0].length == 100;
    }

    def "Getting map bounds"() {

        given:
            Position upperBounds = gameScreen.getUpperBounds();
        expect:
            upperBounds.getY() == 2;
            upperBounds.getX() == 9;
    }

    def "Getting lower bounds"() {

        given:
            Position lowerBounds = gameScreen.getLowerBounds();
        expect:
            lowerBounds.getX() == 19;
            lowerBounds.getY() == 8;
    }

    def "Murphy new position consequences - Up/Down Move"() {

        given:
            Configuration oldConfig = gameScreen.getConfigs();
            Murphy.getInstance().setPos(new Position(14, 9))
            gameScreen.update()
            Configuration newConfig = gameScreen.getConfigs();

        expect:
            newConfig.yMin == 3;
            newConfig.yMax == 10;
            newConfig.xMin == oldConfig.xMin;
            newConfig.xMax == oldConfig.xMax;
    }

    def "Murphy new position consequences - Right/Left Move"() {

        given:
            Configuration oldConfig = gameScreen.getConfigs();
            gameScreen.update(new Position(2, 5))
            Configuration newConfig = gameScreen.getConfigs();

        expect:
            newConfig.yMin == oldConfig.yMin;
            newConfig.yMax == oldConfig.yMax;
            newConfig.xMin == 0;
            newConfig.xMax == 10;
    }

    def "Murphy new position consequences - Corner Move"() {

        given:
            gameScreen.update(new Position(2, 2))
            Configuration newConfig = gameScreen.getConfigs();

        expect:
            newConfig.yMin == 0;
            newConfig.yMax == 7;
            newConfig.xMin == 0;
            newConfig.xMax == 11;
    }
}