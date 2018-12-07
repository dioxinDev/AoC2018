package mobi.reid.AoC2018.helper;

import java.util.ArrayList;
import java.util.Collections;

public class Step implements Comparable {

    public Character name;
    ArrayList<Step> dependencyList = new ArrayList<>();

    public Step(Character name){
        this.name = name;
    }

    public void addDependency(Step dependency){
        this.dependencyList.add(dependency);
    }

    @Override
    public String toString() {
        String string = "["+name+"]";
        Collections.sort(dependencyList);
        for(Step step: dependencyList){

            string += ":" +step.name ;
        }

        return string;
    }

    @Override
    public int compareTo(Object o) {
        Step compare = (Step) o;
        return (  this.getPriority() - compare.getPriority());
    }

    public int getPriority(){
        int prio = 0;
    return (getHighestDependencyOrder()*100)+(this.name-64);
    }

public ArrayList<Step> getDependencyList(){
        return dependencyList;
}

public int getHighestDependencyOrder(){
        int order = this.name-64;
        int dependencyOrder = 0;
    for(Step step: dependencyList){
        dependencyOrder = step.getHighestDependencyOrder();
        if(step.name-64>dependencyOrder){order=step.name;}
        if(dependencyOrder>order){order=dependencyOrder;}
    }

        return order; }


public int getPosition(){
        return this.name+getHighestDependencyOrder();
    }
}
