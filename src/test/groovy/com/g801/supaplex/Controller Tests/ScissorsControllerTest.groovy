import com.g801.supaplex.Controller.Display.ScissorController
import com.g801.supaplex.Game
import com.g801.supaplex.Model.Elements.Base
import com.g801.supaplex.Model.Elements.Murphy
import com.g801.supaplex.Model.Elements.Scissors
import com.g801.supaplex.Model.Level.Display
import com.g801.supaplex.Model.Models.Model
import com.g801.supaplex.Model.Position
import com.g801.supaplex.Viewer.GUI.GUI
import spock.lang.Specification;

class ScissorsControllerTest extends Specification {

    private ScissorController scissorController;
    private Scissors scissors;
    private Game game;
    private long time = 9000;
    private Display display;
    private List<Scissors> fake;
    private Model[][] fakeMap;

    def setup() {
        game = new Game();
        display = Mock(Display.class);
        display.getMurphy() >> new Murphy(new Position(1, 2));
        scissors = Mock(Scissors.class);
        fake = new ArrayList<>();
        fake.push(scissors);
        fakeMap = new Model[3][3];
        Position p = new Position(1, 1);
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                fake[i][j] = new Base(new Position(i, j));
            }
        }
        display.getScissorList() >> fake;
        display.getMap() >> fakeMap;
        scissors.getPos() >> new Position(1, 2);
        scissorController = new ScissorController(display);
    }

    def "Scissors execute"() {

        given:
            scissors.getDirection() >> Scissors.Direction.LEFT;
        when:
            scissorController.execute(game, GUI.KEYACTION.LEFT, time);
        then:
            display.updateScissor(scissors);
    }

    def "Scissors can move Down?"() {

        given:
            scissors.getDirection() >> Scissors.Direction.DOWN;
        expect:
            scissorController.canMove(scissors, game);
    }

    def "Scissors can move Up?"() {

        given:
            scissors.getDirection() >> Scissors.Direction.UP;
        expect:
            scissorController.canMove(scissors, game);
    }

    def "Scissors can move Left?"() {

        given:
            scissors.getDirection() >> Scissors.Direction.LEFT;
        expect:
            scissorController.canMove(scissors, game);
    }

    def "Scissors can move Right?"() {

        given:
            scissors.getDirection() >> Scissors.Direction.RIGHT;
        expect:
            scissorController.canMove(scissors, game);
    }
}