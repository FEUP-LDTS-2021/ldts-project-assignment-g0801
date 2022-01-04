import com.g801.supaplex.Model.Colors;
import spock.lang.Specification

class ColorsTest extends Specification {

    private int colorsNumber = 10;
    private Colors colors;

    def setup() {
        colors = Colors.getInstance();
    }

    def "Read all colors"() {
        expect:
            colors.getColors().size() == colorsNumber;
    }

    def "HashMap formating"() {

        given:
            def alphabet = [];
            for (int i = 64 ; i < 91 ; i++) alphabet.add((char) i);

        alphabet.every() { Character letter ->

            when:
                String color = colors.getColors().get(letter);
            then:
                if (color != null) {
                    color.length() == 7;
                    color.charAt(0) == '#';
            }
        }
    }

    def "Letter to Hexadecimal Code"() {

        given:
            def pairs = [["B", "#000000"]];

        pairs.every() {
            HashMap<Character, String> clone = colors.getColors();
            Character letter = 'B';
            String test = clone.get(letter);
            assert test == it[1]
        }
    }
}