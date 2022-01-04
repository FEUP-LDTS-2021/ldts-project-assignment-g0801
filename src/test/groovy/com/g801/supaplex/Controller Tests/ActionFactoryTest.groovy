import com.g801.supaplex.Controller.Action
import com.g801.supaplex.Controller.ActionFactory
import com.g801.supaplex.Controller.MoveUp
import com.g801.supaplex.Model.Elements.Movable
import spock.lang.Specification

class ActionFactoryTest extends Specification {

    def "Interpreting an action"() {

        given:
        ActionFactory actionFactory = new ActionFactory(new Movable());
        when:
        Action action = actionFactory.factoryMethod(ActionFactory.Actions.MOVE_UP);
        then:
        action instanceof MoveUp;
    }

    // e um teste específico para cada uma das ações

}