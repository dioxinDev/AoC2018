package mobi.reid.AoC2018.main;

import mobi.reid.AoC2018.helper.Helper;
import mobi.reid.AoC2018.helper.MetaNode;
import mobi.reid.AoC2018.helper.Step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class InitDay8a {
    static MetaNode grandDaddyNode;
    static Stack<Integer> data;
    static int childCount = 0;

    public static void main(String[] args) {
        String input = Helper.getStringfromFile("./resources/day8ainput.txt");
        String[] split = input.split(" ");
        data = new Stack<>();
        for (int i = split.length-1; i > -1 ; i--){
            data.push(Integer.parseInt(split[i]));
        }


        grandDaddyNode = createChild();
        System.out.println(grandDaddyNode.getMetaSumIncludingDependents());
        System.out.println(grandDaddyNode.getMetaValue());






    }

    static MetaNode createChild(){
        MetaNode node = new MetaNode();
        int childrenOfNode = data.pop();
        int metaQuantity = data.pop();
        for (int i = 0; i < childrenOfNode; i++) {
            node.addChild(createChild());
        }
        for (int i = 0; i < metaQuantity; i++) {
            node.addMeta(data.pop());
        }
        return node;
    }
}
