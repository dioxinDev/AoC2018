package mobi.reid.AoC2018.main;

import java.util.*;

import mobi.reid.AoC2018.helper.Helper;
import mobi.reid.AoC2018.helper.Step;

public class InitDay7a {

    public static void main(String[] args) {
        String input = Helper.getStringfromFile("./resources/day7ainput.txt");
        String[] split = input.split("\n");
        HashMap<Character, Step> steps = new HashMap<>();
        Step step1;
        Step step2;
        char processCode;

        for (int i = 0; i < split.length; i++) {
            processCode = split[i].charAt(5);
            step1 = steps.get(processCode);
            if (step1 == null) {
                step1 = new Step(processCode);
                steps.put(processCode, step1);
            }
            processCode = split[i].charAt(36);
            step2 = steps.get(processCode);
            if (step2 == null) {
                step2 = new Step(processCode);
                steps.put(processCode, step2);
            }
            step2.addDependency(step1);
        }
        ArrayList<Step> orderedStepsList = new ArrayList<>(steps.values());
        Collections.sort(orderedStepsList);
        String result = "";
        for (Step step : orderedStepsList) {
            result += "" + step.name;
        }
        System.out.println("Result:" + result);
        for (Step step : orderedStepsList) {
            System.out.println("["+step.name+"]"+" "+ step.toDependencyString());
        }
        int threadCount = 5;
        HashMap<Integer, Stack<Step>> stackMap = new HashMap<>();
        Stack<Step> stack = new Stack<>();;
        for (int i = 0; i < threadCount; i++) {
            stack = new Stack<>();
            Step newStep = new Step((char)4);
            stack.push(newStep);
            stack.push(new Step((char)4));
            System.out.println(stack.size());
            stack.peek().setStartTime(0);
            System.out.println(stack.size());
            stackMap.put(i,new Stack<>());
        }
        System.out.println("Size"+stackMap.size());
        System.out.println(stackMap.get(1).peek().name);
        int earliestEntry=0;
        for (Step step : orderedStepsList) {
            earliestEntry = findEarliestEntry(step);
            System.out.println("Step"+step+" :"+earliestEntry);
            int bestStartTime=Integer.MAX_VALUE;
            for(Stack<Step> currentStack:stackMap.values()){
                System.out.println("CurrentStackSize:"+currentStack.size());
                if(currentStack.peek().getStartTime()>=earliestEntry){
                    System.out.println("CurrentStack:"+currentStack.peek().getStartTime());
                    if(currentStack.peek().getStartTime()<bestStartTime){
                        stack=currentStack;
                        bestStartTime=stack.peek().getStartTime();
                    }
                }

            }
            if(bestStartTime<earliestEntry){
                stack.push(new Step(((char)-4)));
                stack.peek().setStartTime(earliestEntry);
            }
            step.setStartTime(stack.peek().getStartTime());
            stack.push(step);



        }

    }

    private static int findEarliestEntry(Step step) {
        int result = 0;
        for (Step dependentStep: step.getDependencyList()) {
             if((dependentStep.getStartTime()+dependentStep.getProcessingTime()) > result ){
                 result = (dependentStep.getStartTime()+dependentStep.getProcessingTime());
             }

        }
        return result;
    }

}
