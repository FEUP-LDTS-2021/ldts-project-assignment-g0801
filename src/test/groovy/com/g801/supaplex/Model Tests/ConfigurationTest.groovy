import com.g801.supaplex.Model.Elements.Murphy
import com.g801.supaplex.Model.Position
import spock.lang.Specification;
import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.ScreenSettings;

class ConfigurationTest extends Specification {

    private Configuration configuration;

    def setup() {
        configuration = Configuration.getInstance();
    }

    def "Initial configurations"() {

        expect:
            configuration.getCurrentLevel() == 1;
            configuration.getScreenLowerBound() != null;
            configuration.getScreenSettings() != null;
            configuration.getScreenSettings().x == ScreenSettings.x;
            configuration.getScreenSettings().y == ScreenSettings.y;
    }

    def "Updating settings"() {

        given:
            Murphy mockedMurphy = Mock(Murphy.class);
            mockedMurphy.getPos() >> new Position(10, 20);
            Position mockedPosition = Mock(Position.class);

        when:
            configuration.updateSettings(mockedMurphy, mockedPosition);

        then:
            2 * mockedMurphy.getPos();
            1 * mockedPosition.getY();
            1 * mockedPosition.getX();
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