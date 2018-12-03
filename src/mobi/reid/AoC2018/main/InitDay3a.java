package mobi.reid.AoC2018.main;

import mobi.reid.AoC2018.helper.Helper;
import mobi.reid.AoC2018.helper.Patch;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class InitDay3a {
    static int xOffset = Integer.MAX_VALUE;
    static int yOffset = Integer.MAX_VALUE;
    ;
    static int xSpan = Integer.MIN_VALUE;
    static int ySpan = Integer.MIN_VALUE;

    public static void main(String[] args) {
        String input = Helper.getStringfromFile("./resources/day3ainput.txt");

        //System.out.println(input);
        StringTokenizer tokens = new StringTokenizer(input, "\n");
        List<Patch> patchList = new ArrayList<>();
        Patch patch;
        int diffTotal = 0;
        for (String token; tokens.hasMoreTokens(); ) {
            token = tokens.nextToken();
            patch = createPatchfromInput(token);
            patchList.add(patch);
            if (patch.xOffSet < xOffset) {
                xOffset = patch.xOffSet;
            }
            if (patch.yOffSet < yOffset) {
                yOffset = patch.yOffSet;
            }
            if (patch.xOffSet + patch.xSpan > xOffset + xSpan) {
                xSpan = patch.xSpan;
            }
            if (patch.yOffSet + patch.ySpan > yOffset + ySpan) {
                ySpan = patch.ySpan;
            }

        }
        //int[][] grid = new int[xOffset+xSpan][yOffset+ySpan];
        int[][] grid = new int[1200][1200];
        int count = 0;
        for (Patch currPatch : patchList) {
        int xStart = (currPatch.xOffSet-xOffset);
        int yStart = (currPatch.yOffSet-yOffset);
        int xEnd =(xStart+currPatch.xSpan);
        int yEnd =(yStart+currPatch.ySpan);
        count++;
            System.out.println("xStart"+xStart);
            System.out.println("xEnd"+xEnd);
            for (int x = xStart; x < xEnd; x++) {
                for (int y = yStart; y < yEnd; y++) {

                    if(grid[x][y]==2){

                    } else if (grid[x][y]==1){
                        grid[x][y] = 2;
                        diffTotal++;
                    } else {
                        grid[x][y] = 1;
                    }
                }
            }
        }
//        for(int y = 0; y < yOffset + ySpan;y++){
//            for(int x = 0; x < yOffset + ySpan;x++){
//                System.out.print(grid[x][y]);
//
//            }
//            System.out.println();
//        }
        for (Patch currPatch : patchList) {
            int xStart = (currPatch.xOffSet-xOffset);
            int yStart = (currPatch.yOffSet-yOffset);
            int xEnd =(xStart+currPatch.xSpan);
            int yEnd =(yStart+currPatch.ySpan);
            count++;
            Boolean clear = true;
        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {

                if(grid[x][y]==2){
clear = false;
                }
            }
        } if(clear) {
                System.out.println(currPatch.xOffSet + ":" + currPatch.yOffSet + "  " + currPatch.xSpan + "x" + currPatch.ySpan);
            }

    }

        System.out.println("Count:" + count);
        System.out.println("DiffTotal:" + diffTotal);

    }


    public static Patch createPatchfromInput(String input) {
        //#17 @ 258,382: 10x26
        String offSets = input.substring(input.indexOf("@") + 1, input.indexOf(":"));
        String span = input.substring(input.indexOf(":") + 1);
        int xOffset = Integer.parseInt(input.substring(input.indexOf("@") + 2, input.indexOf(",")));
        int yOffset = Integer.parseInt(input.substring(input.indexOf(",") + 1, input.indexOf(":")));
        int xSpan = Integer.parseInt(input.substring(input.indexOf(":") + 2, input.indexOf("x")));
        int ySpan = Integer.parseInt(input.substring(input.indexOf("x") + 1));
        return new Patch(xOffset, yOffset, xSpan, ySpan);
    }


}
