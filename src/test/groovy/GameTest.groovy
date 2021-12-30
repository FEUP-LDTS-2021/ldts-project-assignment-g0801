import spock.lang.Specification;

class GameTest extends Specification {

    def "Start Game"() {
        given:
        Game game = new Game();
            int i = 0;
        when:
            i++;
        then:
            i == 1;
    }
}