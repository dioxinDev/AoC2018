package mobi.reid.AoC2018.main;

import mobi.reid.AoC2018.helper.Helper;

import java.util.ArrayList;


public class InitDay5b {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer(Helper.getStringfromFile("./resources/day5ainput.txt"));
        int part1 = react(buffer).length();
        long timePart1 = System.currentTimeMillis();
        StringBuffer currentBuffer;
        int smallest = Integer.MAX_VALUE;
        int finalSize;
        for (char alpha = 'A'; alpha <= 'Z'; alpha++) {
            currentBuffer = new StringBuffer(buffer);

            finalSize = react(currentBuffer,alpha).length();
            if (smallest > finalSize) {
                smallest = finalSize;
            }

        }
        long finishTime = System.currentTimeMillis();
        System.out.println("part1" + part1);
        System.out.println("Time:"+(timePart1-startTime));
        System.out.println("part2" + smallest);
        System.out.println("Time:"+(finishTime-startTime));

    }

    private static StringBuffer react(StringBuffer currentBuffer, char alpha) {
        char current;
        char next;
        for (int i = 0; i < currentBuffer.length() - 1; ) {

            current = currentBuffer.charAt(i);
            if(Character.toUpperCase(current)==alpha){
                currentBuffer.deleteCharAt(i);
                i--;
                if (i < 0) i = 0;
                continue;
            }
            next = currentBuffer.charAt(i + 1);
            if ( (current ^ next) == 32) {
                currentBuffer.delete(i,i+2);
                i--;
                if (i < 0) i = 0;

            } else i++;
        }
        return currentBuffer;
    }


    public static StringBuffer react(StringBuffer currentBuffer) {
        char current;
        char next;
        for (int i = 0; i < currentBuffer.length() - 1; ) {
            current = currentBuffer.charAt(i);
            next = currentBuffer.charAt(i + 1);
            if ( (current ^ next) == 32) {
                currentBuffer.delete(i,i+2);
                i--;
                if (i < 0) i = 0;
            } else i++;
        }
        return currentBuffer;
    }

}
