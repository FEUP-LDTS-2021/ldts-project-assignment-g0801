import com.g801.supaplex.Controller.Action
import com.g801.supaplex.Model.Elements.Movable
import com.g801.supaplex.Model.Elements.Murphy
import com.g801.supaplex.Model.Position
import spock.lang.Specification

class ActionTest extends Specification {

    private Movable mockMovable;
    private Action mockAction;

    def setup() {
        this.mockMovable = Mock(Movable.class);
        mockMovable.getPos() >> new Position(10, 20);
        this.mockAction = Mock(Action.class);
        this.mockAction.getMovable() >> mockMovable;
        Murphy m = Murphy.getInstance();
        m.setPos(new Position(10, 20));
    }

    /*
    def "Move up"() {

        when:
            Action.factory(Action.Actions.MOVE_UP);

        then:
            1 * Action.up();
    }
    */
}