import com.g801.supaplex.Model.Models.Sprite
import com.g801.supaplex.Model.Reader;
import spock.lang.Specification

class ReaderTest extends Specification {

    private Sprite bitmap;

    def setup() {
        bitmap = new Sprite();
    }

    def "Fill Base Block"() {

        when:
            Reader.fillSprite("Base", bitmap);

        then:
            for (int i = 0 ; i < bitmap.getBitmap().length ; i++) {
                for (int j = 0 ; j < bitmap.getBitmap()[i].length ; j++) {
                    assert bitmap.getBitmap()[i][j] == 'B';
                }
            }
    }

    def "Fill Chip Block"() {

        when:
            Reader.fillSprite("Chip", bitmap);

        then:
            bitmap.getBitmap()[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'B'
            0 | 2 | 'Y'
            1 | 2 | 'C'
            2 | 3 | 'A'
            2 | 6 | 'G'
    }

    def "Fill End Block"() {

        when:
            Reader.fillSprite("EndBlock", bitmap);

        then:
            bitmap[a][b] == c;

        where:
            a | b | c
            0 | 0 | 'O'
            0 | 2 | 'W'
            2 | 6 | 'W'
            2 | 7 | 'O'
            4 | 9 | 'O'
    }


}