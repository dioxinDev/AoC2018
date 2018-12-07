package mobi.reid.AoC2018.main;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import mobi.reid.AoC2018.helper.ChronalNode;
import mobi.reid.AoC2018.helper.Helper;

//              --- Day 6: Chronal Coordinates ---
//        The device on your wrist beeps several times, and once again you feel like you're falling.
//
//        "Situation critical," the device announces. "Destination indeterminate. Chronal interference detected. Please specify new target coordinates."
//
//        The device then produces a list of coordinates (your puzzle input). Are they places it thinks are safe or dangerous? It recommends you check manual page 729. The Elves did not give you a manual.
//
//        If they're dangerous, maybe you can minimize the danger by finding the coordinate that gives the largest distance from the other points.
//
//        Using only the Manhattan distance, determine the area around each coordinate by counting the number of integer X,Y locations that are closest to that coordinate (and aren't tied in distance to any other coordinate).
//
//        Your goal is to find the size of the largest area that isn't infinite. For example, consider the following list of coordinates:
//
//        1, 1
//        1, 6
//        8, 3
//        3, 4
//        5, 5
//        8, 9
//        If we name these coordinates A through F, we can draw them on a grid, putting 0,0 at the top left:
//
//        ..........
//        .A........
//        ..........
//        ........C.
//        ...D......
//        .....E....
//        .B........
//        ..........
//        ..........
//        ........F.
//        This view is partial - the actual grid extends infinitely in all directions. Using the Manhattan distance, each location's closest coordinate can be determined, shown here in lowercase:
//
//        aaaaa.cccc
//        aAaaa.cccc
//        aaaddecccc
//        aadddeccCc
//        ..dDdeeccc
//        bb.deEeecc
//        bBb.eeee..
//        bbb.eeefff
//        bbb.eeffff
//        bbb.ffffFf
//        Locations shown as . are equally far from two or more coordinates, and so they don't count as being closest to any.
//
//        In this example, the areas of coordinates A, B, C, and F are infinite - while not shown here, their areas extend forever outside the visible grid. However, the areas of coordinates D and E are finite: D is closest to 9 locations, and E is closest to 17 (both including the coordinate's location itself). Therefore, in this example, the size of the largest area is 17.
//
//        What is the size of the largest area that isn't infinite?
public class InitDay6a {
    static int xOffset = Integer.MAX_VALUE;
    static int yOffset = Integer.MAX_VALUE;
    static int xMax = Integer.MIN_VALUE;
    static int yMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        String input = Helper.getStringfromFile("./resources/day6ainput.txt");
        StringTokenizer tokens = new StringTokenizer(input, "\n");
        List<ChronalNode> nodes = new ArrayList<>();
        ChronalNode currNode;
        int x;
        int y;
        for (String token = tokens.nextToken(); tokens.hasMoreTokens();token = tokens.nextToken() ) {
            x = Integer.parseInt((token.substring(0,token.indexOf(","))));
            System.out.println(token);
            System.out.println(":"+(token.substring(token.indexOf(",")))+":");
            y = Integer.parseInt((token.substring(token.indexOf(",")+1)));

        }

        //System.out.println(input);

    }

}
