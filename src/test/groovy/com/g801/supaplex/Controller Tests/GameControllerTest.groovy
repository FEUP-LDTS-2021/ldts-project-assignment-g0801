import com.g801.supaplex.Controller.GameController
import com.g801.supaplex.Game;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Viewer.GUI.GUI;
import spock.lang.Specification;

class GameControllerTest extends Specification {

    private GameController gameController;
    private Display display;
    private Game game;
    private int time = 10000;

    def setup() {
        game = Mock(Game.class);
        display = Mock(Display.class);
        gameController = new GameController(display);
    }

    def "Pause the Game"() {

        when:
            gameController.execute(game, GUI.KEYACTION.PAUSE, time);
        then:
            1 * game.pushState(_);
    }
}