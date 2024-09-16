package com.kun.gen.btree;


import com.kun.gen.utils.BTreeUtils;
import com.kun.gen.utils.TreeNode;

import java.util.*;

public class BSTRangeSearch {
    public static void main(String[] args) {
        Integer [] theTree = new Integer[]{12,10,15,8,null,13,20,6,9};
        TreeNode root = BTreeUtils.genTree(theTree);

        BSTRangeSearch bstRangeSearch = new BSTRangeSearch();
        List<Integer> result = bstRangeSearch.search(root, 7,15);
        System.out.println(Arrays.toString(result.toArray()));
    }


    List<Integer> search(TreeNode root, int low, int high){

        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curTop = stack.peek();
            if(curTop.left != null && !visited.contains(curTop.left)){
                if(curTop.left.val < low){
                    //mark as visited and skip it
                   visited.add(curTop.left);
                   continue;
                }
               stack.push(curTop.left);
               continue;
            }

            TreeNode cur = stack.pop();
            visited.add(cur);
            result.add(cur.val);

            if(curTop.right != null && !visited.contains(curTop.right)){
                if(curTop.right.val > high){
                    //mark as visited and skip it
                    visited.add(curTop.right);
                    continue;
                }
                stack.push(curTop.right);
            }
        }

        return result;
    }

}
