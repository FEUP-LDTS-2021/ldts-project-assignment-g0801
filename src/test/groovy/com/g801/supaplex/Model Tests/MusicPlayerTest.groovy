package com.g801.supaplex
import com.g801.supaplex.Model.MusicPlayer;
import spock.lang.Specification

import javax.sound.sampled.Clip;

class MusicPlayerTest extends Specification {

    private MusicPlayer musicPlayer;
    private String fileName = "MusicTest.wav";

    def setup() {
        musicPlayer = Mock(MusicPlayer.class);
        musicPlayer.setMusic(fileName);
    }

    def "Initial configuration of MusicPlayer"() {

        expect:
            fileName == musicPlayer.getClip();
    }

    def "Play continuously music"() {

        when:
            musicPlayer.startMusic();

        then:
            1 * musicPlayer.getClip().setMicrosecondPosition(0);
            1 * musicPlayer.getClip().start();
            1 * musicPlayer.getClip().loop(Clip.LOOP_CONTINUOUSLY);
    }
}