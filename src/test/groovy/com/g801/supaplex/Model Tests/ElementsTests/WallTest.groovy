import com.g801.supaplex.Model.Elements.Wall
import com.g801.supaplex.Model.Models.Sprite;
import com.g801.supaplex.Model.Position;
import spock.lang.Specification;

class WallTest extends Specification {

    private Wall wallBlock;
    private int x = 10;
    private int y = 20;

    def setup() {
        wallBlock = new Wall(new Position(x, y));
    }

    def "Wall Block Position"() {
        expect:
        wallBlock.getPos() == new Position(x, y);
    }

    def "Wall Block Size"() {

        given:
            int height = wallBlock.getModel().getHeight();
            int width = wallBlock.getModel().getWidth();

        expect:
            height == Sprite.height;
            width == Sprite.width;
    }

    def "Wall Block Colors"() {

        given:
            char[][] bitmap = wallBlock.getModel().getBitmap();

        expect:
            bitmap[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'B'
            0 | 2 | 'Y'
            1 | 2 | 'C'
            2 | 3 | 'A'
            2 | 6 | 'G'
    }
}