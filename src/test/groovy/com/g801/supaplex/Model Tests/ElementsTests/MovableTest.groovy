import com.g801.supaplex.Model.Elements.Movable;
import com.g801.supaplex.Model.Position;
import spock.lang.Specification

class MovableTest extends Specification {

    private Movable movable;
    private x = 10;
    private y = 5;
    private originalX = 10;
    private originalY = 10;

    def setup () {
        movable = new Movable();
        movable.setPos(originalX, originalY);
    }

    def "initial state"() {

        then:
            movable.getPos() == new Position(originalX, originalX);
            movable.getModel() == null;
    }

    def "Move Left"() {

        when:
            movable.moveLeft();
        then:
            movable.getPos() == new Position(originalX - x, originalY);

    }
    def "Move Right"() {

        when:
            movable.moveRight();
        then:
            movable.getPos() == new Position(originalX + x, originalY);

    }

    def "Move Up"() {

        when:
            movable.moveLeft();
        then:
            movable.getPos() == new Position(originalX, originalY - y);

    }

    def "Move Down"() {

        when:
            movable.moveLeft();
        then:
            movable.getPos() == new Position(originalX, originalY + y);

    }

}