import com.g801.supaplex.Model.Level.GameScreen
import com.g801.supaplex.Model.Models.Model
import com.g801.supaplex.Model.Models.Sprite
import com.g801.supaplex.Model.Models.SpriteFactory
import com.g801.supaplex.Model.Position
import spock.lang.Specification;
import com.g801.supaplex.Model.Level.Display;

class DisplayTest extends Specification {

    private SpriteFactory spriteFactory;
    private Display display;
    private Position position;

    def setup() {
        display = Display.getInstance();
        spriteFactory = new SpriteFactory();
        position = new Position(10, 10);
    }

    def "Getting Aura by Position"() {

        when:
            List<Model> answer = display.getAura(position);
        then:
            answer.size() == 4;
            answer.get(0).getPos() == new Position(10, 9); // cima
            answer.get(1).getPos() == new Position(10, 11); // baixo
            answer.get(2).getPos() == new Position(9, 10); // esquerda
            answer.get(3).getPos() == new Position(11, 10); // direita
    }

    def "Updating by Position"() {

        when:
            display.update(position);
        then:
            1 * display.updateMap(position);
            1 * display.updateState(position);
    }

}