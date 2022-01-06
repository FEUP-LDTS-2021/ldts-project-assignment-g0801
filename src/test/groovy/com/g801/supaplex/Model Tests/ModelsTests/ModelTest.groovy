import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Model.Models.Model
import spock.lang.Specification

class ModelTest extends Specification {

    private Position position;
    private Model model;

    def setup() {
        model = new Model();
        position = new Position(10, 20);
    }

    def "Initial configuration of Model"() {

        expect:
            model.getModel() == null;
            model.getPos() == null;
    }

    def "New Position of Model"() {

        given:
            model.setPos(position);
        expect:
            model.getPos() == new Position(10, 20);
    }
}