package mobi.reid.AoC2018.main;

import mobi.reid.AoC2018.helper.Guard;
import mobi.reid.AoC2018.helper.Helper;

import java.util.*;


public class InitDay4a {

    public static void main(String[] args) {
        String input = Helper.getStringfromFile("./resources/day4ainput.txt");
        StringTokenizer tokens = new StringTokenizer(input, "\n");
        ArrayList<String> rosterLog = new ArrayList();
        while(tokens.hasMoreTokens()){
        rosterLog.add(tokens.nextToken());
        }
        Collections.sort(rosterLog);
        HashMap<String,Guard> guards = new HashMap<>();
        Guard currGuard = null;
        String guardName;
        for (String logEntry: rosterLog) {
                if(logEntry.contains("#")){
                    guardName = logEntry.substring(logEntry.indexOf("#"),logEntry.indexOf("b")).trim();
                    currGuard = guards.get(guardName);
                    if(currGuard== null){
                        currGuard = new Guard(guardName);
                        guards.put(currGuard.name,currGuard);
                    }
                } else {
                    currGuard.appendLog(logEntry);
                }


        }

        System.out.println(currGuard.name + ":" +currGuard.log);
        Guard longestSleeper = new Guard("null");
        for (Guard guard: guards.values()) {
            guard.parseLog();
            System.out.println("AsleepTime" + guard.asleepDuration);
            if(guard.asleepDuration > longestSleeper.asleepDuration){
                longestSleeper = guard;
            }

        }
        System.out.println("longestSleepTime" + longestSleeper.asleepDuration);
        int digest = (Integer.parseInt(longestSleeper.name.substring(1))*longestSleeper.freqMinute());
        System.out.println("LongestSleeper:" + longestSleeper.name + ":" + digest);
    }

}
