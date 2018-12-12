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
    static int xSpan;
    static int ySpan;

    public static void main(String[] args) {
        String input = Helper.getStringfromFile("./resources/day6ainput.txt");
        StringTokenizer tokens = new StringTokenizer(input, "\n");
        List<ChronalNode> nodes = new ArrayList<>();
        ChronalNode currNode;
        ArrayList<ChronalNode> contention = new ArrayList<>();
        int part2Area = 0;
        int x;
        int y;
        String token = null;
        while (tokens.hasMoreTokens()){
            token = tokens.nextToken();
            x = Integer.parseInt((token.substring(0, token.indexOf(","))).trim());
            y = Integer.parseInt((token.substring(token.indexOf(",") + 1)).trim());
            currNode = new ChronalNode((x + "," + y), x, y);
            nodes.add(currNode);
            contention.add(currNode);
            System.out.println(currNode.name);
            if (xOffset > x) xOffset = x;
            if (yOffset > y) yOffset = y;
            if (xMax < x) xMax = x;
            if (yMax < y) yMax = y;

        }
        System.out.println("Contention"+contention.size());
        System.out.println("nodes"+nodes.size());
        System.out.println(xOffset + "->" + xMax + " ,  " + yOffset + "->" + yMax);
        xSpan = xMax - xOffset+1;
        ySpan = yMax - yOffset+1;
        //xOffset -=1;
        //yOffset -=1;
        int minimumDistance = 0;
        int nodeDistance = 0;
        ChronalNode nearestNode = null;
        String[][] grid = new String[xSpan][ySpan];
        int cumulativeDistance = 0;
        for (x = 0; x < xSpan; x++) {
            for (y = 0; y < ySpan; y++) {
                cumulativeDistance = 0;
                minimumDistance = Integer.MAX_VALUE;
                for (ChronalNode node : nodes) {
                    nodeDistance = node.getDistance(x + xOffset, y + yOffset);
                    cumulativeDistance+=nodeDistance;
                    if (minimumDistance >= nodeDistance) {
                        if (minimumDistance == nodeDistance) {
                            nearestNode = null;

                        } else {
                            nearestNode = node;
                            minimumDistance = nodeDistance;

                        }
                    }
                }
                    if (nearestNode != null) {
                        nearestNode.incrementArea();
                        grid[x][y] = nearestNode.name;
                    }
                    if(x==0 || y == 0 || x == (xSpan-1) || y == (ySpan-1)){
                        contention.remove(nearestNode);
                    }
                    if((cumulativeDistance<10000)){
                        if(cumulativeDistance<0) System.out.println("SHIT");
                        part2Area++;
                        grid[x][y] = ".";
                    } else {
                        grid[x][y] = "0";
                    }
                    if(minimumDistance==0){
                        //part2Area++;
                    }

            }

        }

int maxArea = Integer.MIN_VALUE;
        String nearest = "";
        for (ChronalNode node : contention) {
            if(node.areaCovered>maxArea){
                maxArea = node.areaCovered;
                nearest = node.name + " :";
            }
        }

        for (x = 0; x < xSpan; x++) {
            for (y = 0; y < ySpan; y++) {
                //System.out.print(grid[x][y]);
            }
            //System.out.println();
        }
        System.out.println(nearest + maxArea);
        System.out.println("Part2 Area:"+part2Area);
        System.out.println(nodes.size());





    }
}
