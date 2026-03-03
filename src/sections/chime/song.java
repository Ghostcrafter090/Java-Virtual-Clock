package sections.chime;

import tools.clock;
import tools.sound;

public class song {
    // Selects and plays the correct song for the current quarter hour
    public static void playChimeSong(int theChimeSongType) {
        switch (theChimeSongType) {
            case 0:
                System.out.println("Playing Hour Chime Song...");
                sound.playSound(".\\resources\\hcs.mp3");
                clock.timeout(21);
                return;
            case 1:
                System.out.println("Playing Quarter Hour Chime Song...");
                sound.playSound(".\\resources\\qhcs.mp3");
                clock.timeout(4);
                return;
            case 2:
                System.out.println("Playing Half Hour Chime Song...");
                sound.playSound(".\\resources\\hhcs.mp3");
                clock.timeout(9);
                return;
            case 3:
                System.out.println("Playing Third Quarter Hour Chime Song...");
                sound.playSound(".\\resources\\tqhcs.mp3");
                clock.timeout(14);
                return;
        }
    }

    // Deturmines the current quarter hour type
    public static int getSongType(int theCurrentMinute) {
        if (theCurrentMinute < 14) {
            return 0;
        }
        if (theCurrentMinute < 29) {
            return 1;
        }
        if (theCurrentMinute < 44) {
            return 2;
        }
        return 3;
    }
}
