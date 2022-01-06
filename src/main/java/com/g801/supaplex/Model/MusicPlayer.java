package com.g801.supaplex.Model;

import javax.sound.sampled.*;
import java.io.File;

public class MusicPlayer {
    private Clip backgroundMusic;

    public MusicPlayer(String fileName) {
        this.backgroundMusic = loadMusic(fileName);
    }

    private Clip loadMusic(String fileName) throws NullPointerException{
        try {
            File musicFile = new File(MusicPlayer.class.getResource("/music/" + fileName).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void startMusic() {
        backgroundMusic.setMicrosecondPosition(0);
        backgroundMusic.start();
        backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
