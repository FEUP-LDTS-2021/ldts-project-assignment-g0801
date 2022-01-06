import com.g801.supaplex.Controller.Action
import com.g801.supaplex.Model.Aura.Aura;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Elements.Wall;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Level.GameScreen;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Position
import org.jetbrains.annotations.NotNull;
import spock.lang.Specification

class AuraTest extends Specification {

    private Aura auraMock;
    private Display display;
    private List<Model> modelsList;

    def setup() {
        auraMock = Mock(Aura.class);
        display = Mock(Display.class);
        modelsList = new ArrayList<Model>(4);
        for (int i = 0 ; i < 4 ; i++) modelsList.push(new Wall(new Position(10, 20)));
        display.getAura(_) >> modelsList;
    }

    def "Aura Size"() {

        expect:
            auraMock.aura.size() == 4;
    }

    def "Can Move Up? "() {

        when:
            display.getAura(_).get(0) >> new Wall(new Position(10, 20));
            boolean withWall = auraMock.canMove(Action.Actions.MOVE_UP);
            display.getAura(_).get(0) >> new Wall(new Position(10, 20));
            boolean withoutWall = auraMock.canMove(Action.Actions.MOVE_UP)
        then:
            withWall == false;
            withoutWall== true;
    }

    def "Can Move Down with Wall?"() {

        when:
        boolean result = auraMock.canMove(Action.Actions.MOVE_UP);
        then:
        result == false;
    }

    def "Can Move Right?"() {

        when:
        boolean result = auraMock.canMove(Action.Actions.MOVE_UP);
        then:
        result == false;
    }

    def "Can Move Left?"() {

        when:
        boolean result = auraMock.canMove(Action.Actions.MOVE_UP);
        then:
        result == false;
    }

}