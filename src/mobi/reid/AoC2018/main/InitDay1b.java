package mobi.reid.AoC2018.main;

import mobi.reid.AoC2018.helper.Helper;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class InitDay1b {

    public static void main(String[] args) {
        String input = Helper.getStringfromFile("./resources/day1ainput.txt");
        Set<Integer> set = new HashSet<>();

        int sum = 0;
        boolean incomplete = true;
        while(incomplete) {
            StringTokenizer tokens = new StringTokenizer(input,"\n");
            for (String token; tokens.hasMoreTokens(); ) {
                token = tokens.nextToken();
                sum += Integer.parseInt(token);
                if (set.contains(sum)) {
                    System.out.println(sum);
                    incomplete=false;
                    break;
                } else {
                    set.add(sum);
                }
            }
        }

        System.out.println("final:"+sum);

    }

}
