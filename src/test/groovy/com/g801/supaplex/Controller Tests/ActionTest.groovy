import com.g801.supaplex.Controller.Action
import com.g801.supaplex.Model.Aura.Aura
import com.g801.supaplex.Model.Elements.Murphy
import com.g801.supaplex.Model.Position
import spock.lang.Specification

class ActionTest extends Specification {

    private Action action;
    private Aura aura;

    def setup() {
        Murphy m = Murphy.getInstance();
        m.setPos(new Position(10, 20));
        aura = Mock(Aura.class);
        aura.canMove(_) >> true;
        m.setAura(aura);
        action = new Action()
    }

    def "Murphy lives in Action too!"() {

        expect:
            action.getMovable() != null;
            action.getMovable() instanceof Murphy;
    }

    def "Murphy goes Up"() {

        when:
            action.factory(Action.Actions.MOVE_UP);
        then:
            1 * Murphy.getInstance().moveUp();
    }

    def "Murphy goes Down"() {

        when:
            action.factory(Action.Actions.MOVE_DOWN);
        then:
            1 * Murphy.getInstance().moveDown();
    }

    def "Murphy turn Right"() {

        when:
            action.factory(Action.Actions.MOVE_RIGHT);
        then:
            1 * Murphy.getInstance().moveRight();
    }

    def "Murphy turn Left"() {

        when:
            action.factory(Action.Actions.MOVE_LEFT);
        then:
            1 * Murphy.getInstance().moveLeft();
    }

    // explosions and eating later
}