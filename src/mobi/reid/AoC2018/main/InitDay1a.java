package mobi.reid.AoC2018.main;

import mobi.reid.AoC2018.helper.Helper;

import java.util.StringTokenizer;


public class InitDay1a {

    public static void main(String[] args) {
        String input = Helper.getStringfromFile("./resources/day1ainput.txt");

        StringTokenizer tokens = new StringTokenizer(input,"\n");
        int sum = 0;
        for(String token; tokens.hasMoreTokens();){
            token = tokens.nextToken();
            sum += Integer.parseInt(token);
        }


        System.out.println(sum);

    }

}
