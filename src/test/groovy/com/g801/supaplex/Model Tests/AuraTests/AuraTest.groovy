import com.g801.supaplex.Controller.Action
import com.g801.supaplex.Model.Aura.Aura;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Elements.Wall;
import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Level.GameScreen;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Position
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field
import java.lang.reflect.Modifier
import spock.lang.Specification;

class GroovySingletonTool<T> {
    private Class<T> clazz

    GroovySingletonTool(Class<T> clazz) {
        this.clazz = clazz
    }

    void setSingleton(T instance) {
        // Make 'instance' field non-final
        Field field = clazz.getDeclaredField("instance")
        field.modifiers &= ~Modifier.FINAL
        // Only works if singleton instance was unset before
        field.set(clazz.instance, instance)
    }

    void unsetSingleton() {
        setSingleton(null)
    }

    void reinitialiseSingleton() {
        // Unset singleton instance, otherwise subsequent constructor call will fail
        unsetSingleton()
        setSingleton(clazz.newInstance())
    }
}

class AuraTest extends Specification {

    private Aura aura;
    private List<Model> modelsList;

    def setup() {

        Murphy murphy = Murphy.getInstance();
        murphy.setPos(new Position(10, 10));
        aura = new Aura();
        modelsList = new ArrayList<Model>(4);
        for (int i = 0 ; i < 4 ; i++) { modelsList.push(new Model()); }
    }

    def "Aura Initial Size"() {

        expect:
            aura.aura.size() == 0;
    }

    // Dependem de mocks de singletons, a investigar como fazer.
    /*

    def "Can Move Up? "() {

        when:
            boolean withWall = aura.canMove(Action.Actions.MOVE_UP);
            boolean withoutWall = aura.canMove(Action.Actions.MOVE_UP)
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

    */

}