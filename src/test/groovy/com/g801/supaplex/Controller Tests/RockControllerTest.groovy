import com.g801.supaplex.Controller.Display.RockController
import com.g801.supaplex.Game
import com.g801.supaplex.Model.Elements.Base
import com.g801.supaplex.Model.Elements.Movable
import com.g801.supaplex.Model.Elements.Rock
import com.g801.supaplex.Model.Level.Display
import com.g801.supaplex.Model.Models.Model
import com.g801.supaplex.Model.Position
import com.g801.supaplex.Viewer.GUI.GUI
import spock.lang.Specification

class RockControllerTest extends Specification {

    private Game game;
    private long time;
    private RockController rockController;
    private Display display;
    private Model[][] fake;
    private List<Rock> fakeRocks;

    def setup() {
        time = 9000;
        game = new Game();
        display = Mock(Display.class);
        fake = new Model[3][3];
        Position p = new Position(1, 1);
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                fake[i][j] = new Base(new Position(i, j));
            }
        }

        fakeRocks = new ArrayList<>();
        fakeRocks.push(new Rock(p));
        display.getMap() >> fake;
        display.getRockList() >> fakeRocks;
        rockController = new RockController(display);
    }

    def "Execute rock controller"() {

        when:
            rockController.execute(game, GUI.KEYACTION.LEFT, time);
        then:
            1 * display.updateRock(_);
    }

    def "Can move?"() {

        expect:
            rockController.canMove(new Rock(new Position(1, 1)));
    }

    def "Can Move Right?"() {

        expect:
            ! rockController.canMoveRight(new Movable());
    }
}