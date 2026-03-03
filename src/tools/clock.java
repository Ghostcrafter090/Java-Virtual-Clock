package tools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// When I'm withing my personal projects, I like to keep data formats consistent accross languages, this is what I am doing here
// For example, in python have a module I built called "pytools", from which I'd get a "dateArray" by calling "pytools.clock.getDateTime()"
// The consistency simply helps me streamline development in my projects that require multiple languages.

public class clock {
    public static List<Integer> getDateTime() {
        List<Integer> aDateArray = new ArrayList<>();

        aDateArray.add(Calendar.getInstance().getTime().getYear() + 1900);
        aDateArray.add(Calendar.getInstance().getTime().getMonth());
        aDateArray.add(Calendar.getInstance().getTime().getDate());
        aDateArray.add(Calendar.getInstance().getTime().getHours());
        aDateArray.add(Calendar.getInstance().getTime().getMinutes());
        aDateArray.add(Calendar.getInstance().getTime().getSeconds());

        return aDateArray;
    }

    public static void timeout(double theSecondsToWait) {
        try {
            Thread.sleep((long)(theSecondsToWait * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
