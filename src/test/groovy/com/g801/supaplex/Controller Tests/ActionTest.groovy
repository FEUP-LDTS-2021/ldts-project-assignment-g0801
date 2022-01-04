import com.g801.supaplex.Controller.Action
import com.g801.supaplex.Model.Elements.Movable
import com.g801.supaplex.Model.Position
import spock.lang.Specification

class ActionTest extends Specification {

    private Movable mockMovable;

    def setup() {
        this.mockMovable = Mock(Movable.class);
        mockMovable.getPos() >> new Position(10, 20);
    }

    def "Make an Action"() {

        given:
            Action action1 = new Action();
            Action action2 = new Action(new Movable());
            Action action3 = new Action(mockMovable);

        expect:
            action1.getMovable() == null;
            action2.getMovable() != null;
            action2.getMovable().getModel() == null;
            action2.getMovable().getPos() == null;
            action3.getMovable().getPos() == new Position(10, 20);
            action3.getMovable().getModel() == null;
    }
}