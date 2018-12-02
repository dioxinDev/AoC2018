package mobi.reid.AoC2018.main;

import mobi.reid.AoC2018.helper.Helper;

import java.util.HashMap;
import java.util.StringTokenizer;


public class InitDay2b {

    public static void main(String[] args) {
        String input = Helper.getStringfromFile("./resources/day2ainput.txt");
        String[] split = input.split("\n");

        int count=0;
        int compareCount = 0;
        String result="";
        String compare1 = "";
        String compare2 = "";
        System.out.println(split.length);
        int diffCount = 0;
        while(true) {
            compare1 = split[compareCount];
            for (int i = ++compareCount; i < split.length; i++) {
                diffCount = 0;
                compare2 = split[i];
                System.out.println("COMPARING");
                System.out.println(compare1);
                System.out.println(compare2);
                System.out.println();
                for (int x = 0; x < compare1.length(); x++) {
                    if (compare1.charAt(x) != compare2.charAt(x)) {
                        diffCount++;
                        if (diffCount > 1) break;
                    }
                }count++;
                if (diffCount == 1) {
                    System.out.println(compare1);
                    System.out.println(compare2);
                    for (int x = 0; x < compare1.length(); x++) {
                        if (compare1.charAt(x) == compare2.charAt(x)) {
                            result += Character.toString(compare1.charAt(x));
                        }
                    }
                    break;
                }
                System.out.println("diffcount"+diffCount);
                System.out.println("comparecount"+compareCount);
                System.out.println("count"+count);



            }
            if (diffCount == 1) break;
        }
        System.out.println(compare1);
        System.out.println("Result:"+result);
        System.out.println(compareCount);




    }




}
