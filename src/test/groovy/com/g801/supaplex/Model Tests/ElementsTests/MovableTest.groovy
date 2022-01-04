import com.g801.supaplex.Model.Elements.Movable;
import com.g801.supaplex.Model.Models.Model
import com.g801.supaplex.Model.Position;
import spock.lang.Specification

class MovableTest extends Specification {

    private Movable movable;
    private x = 10;
    private y = 5;

    def setup () {
        movable = new Movable();
        movable.setPos(10, 10);
    }

    def "Move Left"() {

        when:
            movable.moveLeft();
        then:
            movable.getPos() == new Position(0, 10);

    }
}