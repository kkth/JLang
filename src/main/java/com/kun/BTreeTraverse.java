package com.kun;

import java.util.*;

public class BTreeTraverse {
    public static void main(String[] args){
        List<Integer> ret = BTreeTraverse.inTraverse(BTrees.getTree());
        System.out.println(Arrays.toString(ret.toArray()));
        ret = BTreeTraverse.postOrder(BTrees.getTree());
        System.out.println(Arrays.toString(ret.toArray()));
    }

    static List<Integer> inTraverse(TreeNode root){
        if(root == null){
            return null;
        }
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.peek();
            if(root.left != null && !visited.contains(root.left)){
               stack.push(root.left);
               continue;
            }
            root = stack.pop();
            ret.add(root.val);
            visited.add(root);
            if(root.right != null && !visited.contains(root.right)){
               stack.push(root.right);
            }
        }
        return ret;
    }

    static List<Integer> postOrder(TreeNode root){
        if(root == null)
            return null;
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.peek();
            if(root.left != null && !visited.contains(root.left)){
                stack.push(root.left);
                continue;
            }
            if(root.right != null && !visited.contains(root.right)){
                stack.push(root.right);
                continue;
            }
            root = stack.pop();
            ret.add(root.val);
            visited.add(root);
        }
        return ret;

    }
}
