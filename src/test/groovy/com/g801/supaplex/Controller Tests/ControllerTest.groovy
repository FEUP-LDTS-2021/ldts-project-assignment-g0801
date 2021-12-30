package com.g801.supaplex;

import spock.lang.Specification;

class ControlerTest extends Specification {

    def "Start Controller" () {

        given:
            int i = 1;
        when:
            i--;
        then:
            !i;
    }

}