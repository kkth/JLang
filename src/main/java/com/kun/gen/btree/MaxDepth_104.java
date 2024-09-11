package com.kun.gen.btree;

import com.kun.gen.utils.BTreeUtils;
import com.kun.gen.utils.BinaryTreePrinter;
import com.kun.gen.utils.TreeNode;

public class MaxDepth_104 {
    public static void main(String[] args) {
        Integer[] theArray = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = BTreeUtils.genTree(theArray);
        BinaryTreePrinter.printTree(root);

        MaxDepth_104 maxDepth104 = new MaxDepth_104();
        System.out.println(maxDepth104.maxDepthByRecursion(root));
    }

    public int maxDepthByRecursion(TreeNode root) {
       return getDepth(root);
    }
    public int getDepth(TreeNode node){
        if(node.left == null && node.right == null){
            return 0;
        }
        if(node.left == null){
            return getDepth(node.right)+1;
        }
        if(node.right == null){
            return getDepth(node.left)+1;
        }
        return Math.max(getDepth(node.left),getDepth(node.right))+1;
    }

    public int maxDepthByBFS(TreeNode root) {
        return 0;
    }
}
