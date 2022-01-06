import com.g801.supaplex.Controller.MenuController
import com.g801.supaplex.Game
import com.g801.supaplex.Model.Menu.MainMenu
import com.g801.supaplex.Viewer.GUI.GUI;
import com.g801.supaplex.Model.Models.Model
import spock.lang.Specification;

class MenuControllerTest extends Specification {

    private MenuController menuController;
    private MainMenu mainMenu;
    private Game game;
    private time = 900000;

    def setup() {
        mainMenu = Mock(MainMenu.class);
        menuController = new MenuController(mainMenu);
        game = Mock(Game.class);
    }

    def "init"() {

        when:
            menuController.execute(game, GUI.KEYACTION.DOWN, time);
        then:
            1 * mainMenu.downButton();

    }
}