package tools;

import javafx.scene.media.AudioClip;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer.Info;

// Boiler plate code for playing sound files.
// Was considering adding an option for selecting the output device, but I wanted to keep this simple. 

public class sound {
    
    public static void playSound(String filePath, boolean dontWait) {
        try {
            
            if (dontWait) {
                new Thread(new Runnable() {
                    public void run() {
                        File soundFile = new File(filePath);
                        AudioClip player = new AudioClip(soundFile.toURI().toString());
                        player.play();
                    }
                }).start();
            }

            playSound(filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playSound(String filePath) {
        try {

            Info[] mixerInfo =  AudioSystem.getMixerInfo();
            System.out.println(mixerInfo[0].getName());
            
            new Thread(new Runnable() {
                public void run() {
                    File soundFile = new File(filePath);
                    AudioClip player = new AudioClip(soundFile.toURI().toString());
                    player.play();
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}