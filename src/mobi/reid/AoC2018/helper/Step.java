package mobi.reid.AoC2018.helper;

import java.text.Collator;
import java.util.*;

public class Step implements Comparable {

    public Character name;
    int startTime;
    ArrayList<Step> dependencyList = new ArrayList<>();

    public Step(Character name) {
        this.name = name;
    }

    public void addDependency(Step dependency) {
        this.dependencyList.add(dependency);
    }


    public String toDependencyString(){
        ArrayList<String> tempArray =  new ArrayList();
        String returnValue = "";
        for (Step step : dependencyList) {
            returnValue +=step.toDependencyString();
        }
        returnValue +=""+this.name;
        Set<Character> dependencies = new HashSet();
        for (char letter : returnValue.toCharArray())
              { dependencies.add(letter);

        }
        returnValue = "";
        Character[] charArray = dependencies.toArray(new Character[0]);
        Arrays.sort(charArray);
        for (int i = charArray.length-1; i > -1 ; i--) {


            returnValue += charArray[i];

        }


        return returnValue;
    }

    @Override
    public int compareTo(Object o) {
        Collator collator = Collator.getInstance();
        return collator.compare(this.toDependencyString(),((Step) o).toDependencyString());
    }


    public ArrayList<Step> getDependencyList() {
        return dependencyList;
    }

    @Override
    public String toString() {
        return ""+this.name;
    }


    public int getProcessingTime(){
        return name-4;
    }

    public int getStartTime() {
        return startTime;
    }
    public void setStartTime(int startTime){
        this.startTime = startTime;
    }
}


