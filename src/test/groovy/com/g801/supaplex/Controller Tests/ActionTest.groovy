import com.g801.supaplex.Controller.Action
import com.g801.supaplex.Model.Aura.Aura
import com.g801.supaplex.Model.Configuration
import com.g801.supaplex.Model.Elements.Movable
import com.g801.supaplex.Model.Elements.Murphy
import com.g801.supaplex.Model.Position
import spock.lang.Specification

class ActionTest extends Specification {

    private Action a;
    private Aura aura;
    private Configuration config;

    def setup() {
        config = new Configuration().getInstance();
        Murphy m = Murphy.getInstance();
        m.setPos(new Position(10, 20));
        aura = Mock(Aura.class);
        m.setAura(aura);
        aura.canMove(_) >> true;
        a = new Action()
    }

    def "solve"() {

        expect:
            a.getMovable() != null;
            a.getMovable() instanceof Murphy;
    }

    def "init"() {

        when:
            a.factory(Action.Actions.MOVE_UP);
        then:
            1 * Murphy.getInstance().canMove(Action.Actions.MOVE_UP);

    }
}