package com.g801.supaplex
import com.g801.supaplex.Model.Level.LoadLevelBuild
import spock.lang.Specification;

class LoadLevelBuildTest extends Specification {

    private int level = 10;
    private Character[][] map;

    def setup() {
        map = LoadLevelBuild.getLevelMap(level);
    }

    def "Configuration of Loader"() {

        expect:
            map.length == 10;
            map[0].length == 43;
    }

    def "Map colors"() {

        expect:
            map[a][b] == c

        where:
            a | b | c
            0 | 0 | 'W'
            1 | 1 | 'G'
            3 | 10 | 'W'
            9 | 42 | 'W'
            8 | 1 | 'G'
    }
}