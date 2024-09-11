package com.kun.gen.btree;

import com.kun.gen.utils.BTreeUtils;
import com.kun.gen.utils.TreeNode;

import java.util.*;

public class VerifyBST_98 {
    public static void main(String[] args) {
        //TreeNode root =  BTreeUtils.genTree(new Integer[]{5,1,4,null,null,3,6});
        TreeNode root =  BTreeUtils.genTree(new Integer[]{5,4,6,null,null,3,7});
        VerifyBST_98 verifyBST98 = new VerifyBST_98();
        System.out.println(verifyBST98.isValidBST_fail(root));
        System.out.println(verifyBST98.isValidByTraverse(root));
        System.out.println(verifyBST98.isValidBST(root));

    }

    /*
    It does not work.
    The BST requires (ALL values on the left) < current and (All values on the right > current)
    rather than (left child) < current and (right child) > current
    for example, {5,4,6,null,null,3,7}
     */
    public boolean isValidBST_fail(TreeNode root) {
        if(root.left == null && root.right == null){
           return true;
        }
        if(root.left != null&& root.right != null){
            return isValidBST_fail(root.left) && isValidBST_fail(root.right) && root.val > root.left.val && root.val < root.right.val;
        }else if(root.left != null){
            return isValidBST_fail(root.left) && root.val > root.left.val;
        }
        return isValidBST_fail(root.right) && root.val < root.right.val;
    }

    class Boundary{
        int lower;
        int upper;
        boolean isBST;
    }

    public boolean isValidBST(TreeNode root) {
        Boundary boundary = check(root);
        return boundary.isBST;
    }

    Boundary check(TreeNode cur){
        Boundary ret = new Boundary();
        if(cur.left != null && cur.right != null){
            Boundary boundaryLeft = check(cur.left);
            Boundary boundaryRight = check(cur.right);
            if(boundaryLeft.isBST && boundaryRight.isBST){
                if(cur.val > boundaryLeft.upper && cur.val < boundaryRight.lower){
                    ret.isBST = true;
                    ret.lower = boundaryLeft.lower;
                    ret.upper = boundaryRight.lower;
                } else{
                  ret.isBST = false;
                }
            }else{
                ret.isBST = false;
            }
        }else if(cur.left != null){
            Boundary boundaryLeft = check(cur.left);
            if(boundaryLeft.isBST){
               if(cur.val > boundaryLeft.upper){
                  ret.isBST = true;
                  ret.lower = boundaryLeft.lower;
                  ret.upper = cur.val;
               } else{
                   ret.isBST = false;
               }
            }else{
                ret.isBST = false;
            }
        }else if(cur.right != null){
            Boundary boundaryRight = check(cur.right);
            if(boundaryRight.isBST){
                if(cur.val < boundaryRight.lower){
                    ret.isBST = true;
                    ret.lower = cur.val;
                    ret.upper = boundaryRight.upper;
                } else{
                    ret.isBST = false;
                }
            }else{
                ret.isBST = false;
            }

        }else{
           ret.isBST = true;
           ret.upper = cur.val;
           ret.lower = cur.val;
        }

        return ret;
    }



    public boolean isValidByTraverse(TreeNode root){
        List<Integer> sorted = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();

        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(cur.left!= null && !visited.contains(cur.left)){
                stack.push(cur.left);
                continue;
            }
            TreeNode popped = stack.pop();
            sorted.add(popped.val);
            visited.add(popped);

            if(cur.right != null && !visited.contains(cur.right)){
                stack.push(cur.right);
            }
        }

        System.out.println(Arrays.toString(sorted.toArray()));

        boolean ascend = true;
        for(int i = 0;i<sorted.size()-1;i++){
            if(sorted.get(i) > sorted.get(i+1)){
                ascend = false;
                break;
            }
        }

        return ascend;
    }


}
