package com.mygdx.game;

import static jdk.internal.net.http.common.Utils.close;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class playSound {
    public AudioInputStream stream = null;
    private Clip clip = null;

    public playSound(File file) {
        try {
            stream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open();
        } catch (Exception e) {
            e.printStackTrace();
            close();
        }

    }
}
