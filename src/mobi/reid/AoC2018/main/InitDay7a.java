package mobi.reid.AoC2018.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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

        for(int i = 0 ; i<split.length;i++){
            processCode =  split[i].charAt(5);
            step1 = steps.get(processCode);
            if(step1==null){
                step1 = new Step(processCode);
                steps.put(processCode,step1);
            }
            processCode =  split[i].charAt(36);
            step2 = steps.get(processCode);
            if(step2 == null){
                step2 = new Step(processCode);
                steps.put(processCode,step2);
            }
            step2.addDependency(step1);
        }
        ArrayList<Step> orderedStepsList = new ArrayList<>(steps.values());
        Collections.sort(orderedStepsList);

        for(Step step: orderedStepsList){
            System.out.print(step.name);
        }
        for(Step step: orderedStepsList){
            System.out.println();
            System.out.println((step.getHighestDependencyOrder()) + step.toString());
            System.out.println((step.getPriority()) + step.toString());
        }



    }

}
