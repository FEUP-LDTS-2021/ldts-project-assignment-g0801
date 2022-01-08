import com.g801.supaplex.Controller.Action
import com.g801.supaplex.Model.Aura.Aura;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Position
import spock.lang.Specification;

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
            boolean result = aura.canMove(Action.Actions.MOVE_DOWN);
        then:
            result == false;
    }

    def "Can Move Right?"() {

        when:
            boolean result = aura.canMove(Action.Actions.MOVE_RIGHT);
        then:
            result == false;
    }

    def "Can Move Left?"() {

        when:
            boolean result = aura.canMove(Action.Actions.MOVE_LEFT);
        then:
            result == false;
    }

}