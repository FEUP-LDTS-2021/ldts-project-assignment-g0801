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
            char[][] currentMap = gameMap.getMap();

        then:
            x == 0;
            y == 0;
            currentMap != null;
            1 * gameMap.createGameMap();
            1 * gameMap.loadMap(new File(_));
    }

}