package com.g801.supaplex

import com.g801.supaplex.Model.Level.LoadLevelBuild
import spock.lang.Specification;

class LoadLevelBuildTest extends Specification {

    private int level = 1; // testar com um nível final e adaptar os testes
    private ArrayList<String> map;

    def setup() {
        LoadLevelBuild loadLevelBuild = new LoadLevelBuild(level);
        map = loadLevelBuild.getLevelMap();
    }

    def "Configuration of Loader"() {

        expect:
            map.size() == 17;
            map[0].size() == 17;
    }

    def "Map colors"() {

        expect:
            map[a][b] == c

        where:
            a | b | c
            0 | 0 | 'W'
            1 | 1 | ' '
            3 | 4 | ' '
            9 | 4 | ' '
            8 | 1 | ' '
    }
}