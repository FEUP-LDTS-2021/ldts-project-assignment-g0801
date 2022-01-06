import com.g801.supaplex.Model.Level.GameMap
import spock.lang.Specification;

class GameMapTest extends Specification {

    private GameMap gameMap;
    private int level = 10;

    def setup() {
        gameMap = new GameMap(level);
    }

    def "Initial Configuration of GameMap"() {

        when:
            int x = gameMap.getXBound();
            int y = gameMap.getYBound();

        then:
            x == 0;
            y == 0;
    }

    def "Map constructor"() {

        when:
            Character[][] currentMap = gameMap.getMap();

        then:
            currentMap[0].length == 43;
            currentMap.length == 10;
    }

    def "Map colors"() {

        given:
            Character[][] currentMap = gameMap.getMap();

        expect:
            currentMap[a][b] == c

        where:
            a | b | c
            0 | 0 | 'W'
            1 | 1 | 'G'
            3 | 10 | 'W'
            9 | 42 | 'W'
            8 | 1 | 'G'
    }
}