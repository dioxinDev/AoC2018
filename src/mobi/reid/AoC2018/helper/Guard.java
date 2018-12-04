package mobi.reid.AoC2018.helper;

import java.util.ArrayList;

public class Guard {

    public String name;
    public ArrayList<String> log;
    public int asleepDuration;
    private int[] sleepTracker;

    public Guard(String name){
        this.name = name;
        this.log = new ArrayList<>();
        this.asleepDuration = 0;
        sleepTracker = new int[60];

    }


    public void appendLog(String token) {
        log.add(token);
    }

    public void parseLog() {
       int fallAsleepMinute = -1;
       int awakeMinute = -1;
       int currMinute = -1;
        for (String logLine: log) {
            currMinute = Integer.parseInt(logLine.substring(logLine.indexOf(":")+1,logLine.indexOf("]")));
            if(logLine.contains("asleep")){
                fallAsleepMinute = currMinute;
            } else if (logLine.contains("wakes")){
                awakeMinute = currMinute;
                int minute = fallAsleepMinute;
                while(minute!=awakeMinute){
                    if(minute==59){minute=0;}
                    sleepTracker[minute] += 1;
                    asleepDuration++;
                    minute++;
                }
            }

        }

    }

    public int freqMinute() {
        int mostAsleepMinute = -1;
        int mostAmountofSleep = -1;
        for (int i = 0; i < sleepTracker.length ; i++) {
            if (sleepTracker[i]>mostAmountofSleep) {
                mostAmountofSleep = sleepTracker[i];
                mostAsleepMinute = i;
            }
            }
        return mostAsleepMinute;
    }
}
