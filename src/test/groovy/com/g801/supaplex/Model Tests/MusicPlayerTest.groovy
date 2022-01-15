package com.g801.supaplex

import com.g801.supaplex.Model.MusicPlayer;
import spock.lang.Specification
import javax.sound.sampled.Clip;

class MusicPlayerTest extends Specification {

    private MusicPlayer musicPlayer;
    private String fileName = "jam_backingTrack.wav";

    def setup() {
        musicPlayer = new MusicPlayer(fileName);
    }

    def "Initial configuration of MusicPlayer"() {

        expect:
            fileName == musicPlayer.getFile();

        when:
            musicPlayer.setFile("Testing.wav");
        then:
            musicPlayer.getFile() == "Testing.wav";
    }

    def "Play continuously music"() {

        when:
            musicPlayer.startMusic();

        then:
            _ * musicPlayer.getClip().setMicrosecondPosition(0);
            _ * musicPlayer.getClip().start();
            _ * musicPlayer.getClip().loop(Clip.LOOP_CONTINUOUSLY);
    }
}