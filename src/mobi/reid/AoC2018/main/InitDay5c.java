package mobi.reid.AoC2018.main;
import java.nio.file.Files;
import java.io.File;
import java.util.EmptyStackException;
import java.util.Stack;


public class InitDay5c {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();
        byte[] bytes = Files.readAllBytes(new File("./resources/day5ainput.txt").toPath());

        Stack<Integer> stack = react(bytes);
        long timePart1 = System.currentTimeMillis();
        int part1 = stack.size();
        int smallest = Integer.MAX_VALUE;
        Object[] input = stack.toArray();
        int finalSize;
        for (char alpha = 'A'; alpha <= 'Z'; alpha++) {
            finalSize = react(input,alpha);
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

    @SuppressWarnings("Duplicates")
    public static Stack<Integer> react(byte[] input) {
        Stack<Integer> stack = new Stack<>();
        int current;
        int next;

        for (int i =0;i<input.length;i++){
            next = input[i];
            try {
                current = stack.peek();
                if ( (current ^ next) == 32) {
                    stack.pop();
                } else {
                    stack.push(next);
                }
            } catch (EmptyStackException e){
                stack.push(next);
                continue;
            }

        }
        return stack;
    }
    @SuppressWarnings("Duplicates")
    public static int react(Object[] input, char removeChar) {
        Stack<Integer> stack = new Stack<>();
        int current;
        int next;

        for (int i =0;i<input.length;i++){
            next = (Integer) input[i];
            if(Character.toUpperCase(next)==removeChar)continue;
            try {
                current = stack.peek();
                if ( (current ^ next) == 32) {
                    stack.pop();
                } else {
                    stack.push(next);
                }
            } catch (EmptyStackException e){
                stack.push(next);
                continue;
            }

        }
        return stack.size();
    }

}
