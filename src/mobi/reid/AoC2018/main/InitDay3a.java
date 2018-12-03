package mobi.reid.AoC2018.main;

import mobi.reid.AoC2018.helper.Helper;
import mobi.reid.AoC2018.helper.Patch;


public class InitDay3a {

    public static void main(String[] args) {
        String input = Helper.getStringfromFile("./resources/day2ainput.txt");

        //System.out.println(input);
            createPatchfromInput("#17 @ 258,382: 10x26");
    }


    public static Patch createPatchfromInput(String input){
      //#17 @ 258,382: 10x26
      String offSets = input.substring(input.indexOf("@")+1,input.indexOf(":"));
      String span    = input.substring(input.indexOf(":")+1);
      int xOffset = 0;
        System.out.println(":"+offSets);
        System.out.println(":"+span);
        return null;
    }



}
