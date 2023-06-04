package com.mygdx.game;

import com.sun.media.sound.SoftMixingClip;

public class AudioInputStream {
    public void start(){
        SoftMixingClip clip = null;
        if(clip.isRunning()){
            clip.stop();
        }
        clip.setFramePosition(0);
        clip.start();
    }
}
