package com.kun.gen.utils;

import com.kun.gen.utils.TreeNode;

public class BTreeUtils {
    static TreeNode genTree(Integer[] array) {
        int len = array.length;

        TreeNode[] theNodes = new TreeNode[len];

        //First traverse: build the nodes
        for(int i = 0;i<len;i++) {
            if(array[i] == null){
                theNodes[i] = null;
            }else{
                theNodes[i] = new TreeNode(array[i]);
            }
        }

        //Second traverse: build the tree
        int childSetIndex = 1;
        for(int i = 0;i<len;i++){
           if(array[i] == null) {
               continue;
           }else {
               if (childSetIndex * 2 - 1 < len) {
                   theNodes[i].left = theNodes[childSetIndex * 2 - 1];
               }
               if (childSetIndex * 2 < len)
                   theNodes[i].right = theNodes[childSetIndex * 2];
                }
                   childSetIndex++;
           }

        return theNodes[0];
    }



}
