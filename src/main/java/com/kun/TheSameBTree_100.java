package com.kun;

import java.util.ArrayDeque;
import java.util.Queue;

public class TheSameBTree_100 {

    public static void main(String[] args) {

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
       if((p==null) && (q==null)){
           return true;
       }
       if((p==null) && (q!=null)){
           return false;
       }
       if((p!=null) && (q==null)){
           return false;
       }
        if(p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else {
            return false;
        }
    }
}
