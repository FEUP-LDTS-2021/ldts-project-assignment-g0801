package com.g801.supaplex

import com.g801.supaplex.Game
import spock.lang.Specification;

class GameTest extends Specification {

    private Game game;

    def setup() {
        game = new Game();
    }

    def "Initial configuration of game"() {

        expect:
            game.getConfiguration() != null;
    }

    def "Start Game"() {

        when:
            game.run();

        then:
            0 * game.close();
    }
}