package mobi.reid.AoC2018.helper;

import java.util.ArrayList;

public class MetaNode {

    ArrayList<MetaNode> children = new ArrayList<>();
    ArrayList<Integer> metaData = new ArrayList<>();

public MetaNode(){
}

public int getMetaSumIncludingDependents(){
    int returnSum = 0;
    for(MetaNode child: children){
        returnSum += child.getMetaSumIncludingDependents();
    }
    for (Integer metaValue: metaData){
        returnSum += metaValue;
    }
    return returnSum;

}

public void addChild(MetaNode child){
    children.add(child);

}

public void addMeta(int metaValue){
    metaData.add(metaValue);
}

    public int getMetaValue() {
        int returnValue = 0;
        if (children.isEmpty()) {
            returnValue = getMetaSumIncludingDependents();
        } else {
            for (int metaIndex : metaData) {
                metaIndex -= 1;
                if (metaIndex < children.size()) {
                    returnValue += children.get(metaIndex).getMetaValue();
                }
            }
        }
            return returnValue;
    }




}
