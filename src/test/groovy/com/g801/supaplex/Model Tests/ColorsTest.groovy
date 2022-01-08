import com.g801.supaplex.Model.Colors;
import spock.lang.Specification

class ColorsTest extends Specification {

    private int colorsNumber = 11;
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

        expect:
            b == colors.getColorString((Character)a);

        where:
              a | b
            'B' | "#000000"
            'W' | "#FFFFFF"
            'R' | "#FF0000"
            'G' | "#00FF00"
            'F' | null
            'A' | "#0000FF"
            'O' | "#FF9933"
            'P' | "#FF66CC"
            'Z' | null
            'Y' | "#FFFF00"
            'D' | "#336600"
            'C' | "#919183"
            'K' | "#525151"
            'T' | null
    }
}