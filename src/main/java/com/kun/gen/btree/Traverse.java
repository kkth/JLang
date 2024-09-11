package com.kun.gen.btree;

import com.kun.gen.utils.BTreeUtils;
import com.kun.gen.utils.BinaryTreePrinter;
import com.kun.gen.utils.TreeNode;

import java.util.*;

public class Traverse {
    public static void main(String[] args) {
        Traverse traverse = new Traverse();
        Integer[] theArray = new Integer[]{41,22,58,15,33,50,null,13,null,null,37,42,53};
        TreeNode root = BTreeUtils.genTree(theArray);
        BinaryTreePrinter.printTree(root);


        System.out.println("Pre order by recursion \n" + traverse.preorderTraversal(root));
        System.out.println("Pre order by stack \n" + traverse.preOrderByStack(root));
        System.out.println("In order by recursion \n" + traverse.inorderTraversal(root));
        System.out.println("In order by stack \n" + traverse.inOrderByStack(root));
        System.out.println("Post order by recursion \n" + traverse.postorderTraversal(root));
        System.out.println("Post order by stack \n" + traverse.postOrderByStack(root));


    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root,result);
        return  result;
    }

    public void preOrder(TreeNode cur, List<Integer> result){
        if(cur == null)
            return;
        result.add(cur.val);
        preOrder(cur.left,result);
        preOrder(cur.right,result);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    public void inOrder(TreeNode node, List<Integer> result){
       if(node == null)
           return;
       inOrder(node.left,result);
       result.add(node.val);
       inOrder(node.right,result);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
       postOrder(root,result);
       return result;
    }

    public void postOrder(TreeNode node, List<Integer> result){
       if(node == null)
           return;
       postOrder(node.left,result);
       postOrder(node.right,result);
       result.add(node.val);
    }

    public List<Integer> inOrderByStack(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();

        stack.push(root);
        while(!stack.isEmpty()){
            //Just get the object
            TreeNode cur = stack.peek();

            //Push left
            if(cur.left != null && !visited.contains(cur.left)){
                stack.push(cur.left);
                continue;
            }

            TreeNode visit = stack.pop();
            visited.add(visit);
            result.add(visit.val);

            if(visit.right != null && !visited.contains(cur.right)){
                stack.push(visit.right);
            }
        }

        return result;
    }

    public List<Integer> preOrderByStack(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode visit = stack.pop();
            result.add(visit.val);
            visited.add(visit);

            if(visit.right != null && !visited.contains(visit.right)){
                stack.push(visit.right);
            }
            if(visit.left != null && !visited.contains(visit.left)){
                stack.push(visit.left);
            }

        }

        return result;
    }

    public List<Integer> postOrderByStack(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();

        stack.push(root);
        while(!stack.isEmpty()){
           TreeNode curTop = stack.peek();
           boolean canPopMySelf = true;
           if(curTop.right != null && !visited.contains(curTop.right)){
               stack.push(curTop.right);
               canPopMySelf =false;
           }
           if(curTop.left!= null && !visited.contains(curTop.left)){
               stack.push(curTop.left);
               canPopMySelf = false;
           }

          if(canPopMySelf) {
              TreeNode cur = stack.pop();
              result.add(cur.val);
              visited.add(cur);
          }

        }

        return result;
    }
}
