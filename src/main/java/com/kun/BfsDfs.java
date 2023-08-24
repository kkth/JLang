package com.kun;

import java.util.*;

public class BfsDfs {
    public static void main(String[] args){
       TreeNode root = BTrees.getTree();
       BfsDfs bfsDfs = new BfsDfs();
       bfsDfs.printArray(bfsDfs.bfs(root));
       bfsDfs.printArray(bfsDfs.dfs(root));
    }


    ArrayList bfs(TreeNode root){
        if(root == null)
            return null;

        ArrayList<Integer> theList = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.pop();
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }

            theList.add(cur.val);
        }
        return theList;
    }

    ArrayList dfs (TreeNode root){
        if(root == null)
            return null;

        ArrayList<Integer> theList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }

            theList.add(cur.val);
        }
        return theList;
    }



    void printArray(ArrayList<Integer> theList){
        StringBuffer sb = new StringBuffer();

        Iterator ite = theList.iterator();
        while(ite.hasNext()){
            sb.append(ite.next());
            if(ite.hasNext()){
                sb.append(",");
            }
        }

        System.out.println(sb.toString());
    }
}
