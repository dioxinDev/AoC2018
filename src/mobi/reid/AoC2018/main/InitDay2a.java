package mobi.reid.AoC2018.main;

import mobi.reid.AoC2018.helper.Helper;

import java.util.HashMap;
import java.util.StringTokenizer;


public class InitDay2a {

    public static void main(String[] args) {
        String input = Helper.getStringfromFile("./resources/day2ainput.txt");
        StringTokenizer tokens = new StringTokenizer(input, "\n");

        int twiceSeenCount = 0;
        int thriceSeenCount = 0;
        int count;
        for (String token; tokens.hasMoreTokens(); ) {
            token = tokens.nextToken();
            HashMap<Character, Integer> letterCounts = Helper.generateLetterCounts(token);

            Boolean twiceSeen = false;
            Boolean thriceSeen = false;
            for (Character letter : letterCounts.keySet()) {
                if (letterCounts.get(letter) == 2 && !twiceSeen) {
                    twiceSeenCount++;
                    twiceSeen = true;
                }
                if (letterCounts.get(letter) == 3 && !thriceSeen) {
                    thriceSeenCount++;
                    thriceSeen = true;
                }
            }
        }


        System.out.println(twiceSeenCount * thriceSeenCount);

    }

}
