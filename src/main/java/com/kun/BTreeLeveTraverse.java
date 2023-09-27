package com.kun;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BTreeLeveTraverse {
    public static void main(String[] args){
        TreeNode root = BTrees.buildFromBFS(new Integer[]{3,9,20,null,null,15,7});
        BTreeLeveTraverse bTreeLeveTraverse = new BTreeLeveTraverse();
        List<List<Integer>> val = bTreeLeveTraverse.levelOrder(root);
        System.out.println(val);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root != null){
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int layerLen = queue.size();
                List<Integer> curLayer = new ArrayList<>();
                for(int i = 0;i<layerLen;i++){
                    TreeNode node = queue.pop();
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                    }

                    curLayer.add(node.val);
                }
                ret.add(curLayer);
            }
        }

        return ret;
    }
}
