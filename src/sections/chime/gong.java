package sections.chime;

import tools.clock;
import tools.sound;

public class gong {
    // Converts theCurrentHour into a usable format and than gongs the correct number of hours
    public static void playGong(int theCurrentHour) {
        if (theCurrentHour > 12) {
            theCurrentHour = theCurrentHour - 12;
        }
        if (theCurrentHour == 0) {
            theCurrentHour = 12;
        }

        int anIndex = 0;
        while (anIndex < theCurrentHour) {
            System.out.println("Playing Gong Sound...");
            sound.playSound(".\\resources\\gong.mp3");
            clock.timeout(2);
            anIndex = anIndex + 1;
        }
    }
}
