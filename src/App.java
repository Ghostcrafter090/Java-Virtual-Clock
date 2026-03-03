import tools.clock;
import tools.sound;

import javafx.application.Application;
import javafx.stage.Stage;

import sections.chime.song;
import sections.chime.gong;

import java.util.List;

/*
Virtual Clock (Java Port)

This is a port of the virtual clock plugin from one of my longterm personal projects: https://github.com/Ghostcrafter090/Ghosts-Ambience-System-Deffered-Server
Ghost's Adaptive Ambience System is a serverside application that generates and streams dynamic log cabin ambience, 
changing according to the date, weather and time. It has a good 20 some odd plugins that do various things from chiming clocks to 
rain noises. It also streams in surround sound accross my entire house, and has a bunch of various speaker types for handling that 
(I.E. Clock Speaker, Fireplace Speaker, etc.).

- Joshua J 2026-03-03
*/

public class App extends Application {
    // Javafx has an aneurysm without this
    @Override
    public void start(Stage thePrimaryStage) {
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Starting Virtual Clock...");

        // Wanted to thread the 2 different pieces, this is how I do it in my Ambience System on a much grander scale 
        Thread aChimeHandlerThread = new Thread(() -> chimeHandler());
        Thread aTickingThread = new Thread(() -> tickingHandler());
        
        aChimeHandlerThread.start();
        aTickingThread.start();

    }

    // Chime handler, handles the quarter hour chime, and gong
    private static void chimeHandler() {
        song.playChimeSong(0);
        gong.playGong(clock.getDateTime().get(3));

        while (true) {
            List<Integer> aDateArray = clock.getDateTime();

            if ((aDateArray.get(4) % 15) == 0) {
                song.playChimeSong(song.getSongType(aDateArray.get(4)));
                if (song.getSongType(aDateArray.get(4)) == 0) {
                    gong.playGong(aDateArray.get(3));
                }
            }

            clock.timeout(60);
        }
    }

    // Ticking handler, handles the ticking noises
    private static void tickingHandler() {
        while (true) {
            sound.playSound(".\\resources\\ticking.mp3");
            clock.timeout(1800);
        }
    }
}
