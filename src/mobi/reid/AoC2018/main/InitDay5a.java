package mobi.reid.AoC2018.main;

import mobi.reid.AoC2018.helper.Helper;

import java.util.ArrayList;


public class InitDay5a {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String input = Helper.getStringfromFile("./resources/day5ainput.txt");

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add("" + input.charAt(i));

        }

        list = react(list);
        int part1 = list.size();
        long timePart1 = System.currentTimeMillis();

        ArrayList<String> currentList;
        int smallest = Integer.MAX_VALUE;
        int finalSize = 0;
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            currentList = new ArrayList<>(list);
            for (int i = 0; i < currentList.size(); i++) {
                if (currentList.get(i).toUpperCase().equals(("" + alphabet))) {
                    currentList.remove(i);
                    i--;
                }
            }
            finalSize = react(currentList).size();
            if (smallest > finalSize) {
                smallest = finalSize;
            }

        }
        long finishTime = System.currentTimeMillis();
        System.out.println("part1:" + part1);
        System.out.println("Time:"+(timePart1-startTime));
        System.out.println("part2:" + smallest);
        System.out.println("Time:"+(finishTime-startTime));

    }

    public static ArrayList<String> react(ArrayList<String> list) {
        String current;
        String next;
        list = new ArrayList<>(list);
        for (int i = 0; i < list.size() - 1; ) {
            current = list.get(i);
            next = list.get(i + 1);
            if (current.toUpperCase().equals(next.toUpperCase()) && !(current.equals(next))) {
                list.remove(i);
                list.remove(i);
                i--;
                if (i < 0) i = 0;
            } else i++;
        }
        return list;
    }

}
