package com.g801.supaplex;

import spock.lang.Specification;

class ViewerTest extends Specification {

    def "Start Viewer" () {

        given:
            int i = 1;
        when:
            i--;
        then:
            !i;
    }

}