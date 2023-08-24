package com.kun;

import java.util.ArrayList;
import java.util.Arrays;

public class RangeSum_938 {
    public static void main(String[] args){
        TreeNode root = BTrees.getTree();
        RangeSum_938 rangeSum938 = new RangeSum_938();
        System.out.println( rangeSum938.rangeSumBST(root, 7,15));
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ret = -1;
        Result result = inOrderTraverse(root, low, high);
        if(result.get){
           ret = result.sum;
           System.out.println(Arrays.toString(result._values.toArray()));
        }
        return  ret;
    }

    Result inOrderTraverse(TreeNode cur,int low, int high){
        Result left = new Result();
        if(cur.left != null){
           left = inOrderTraverse(cur.left,low,high);
        }

        Result right = new Result();
        if(cur.right != null){
            right = inOrderTraverse(cur.right,low,high);
        }

        Result curResult = new Result();

        if(cur.val >=low && cur.val <=high){
                curResult.sum = cur.val;
                curResult.get = true;
                curResult._values.add(cur.val);
        }

        if(left.get){
            curResult.get = true;
            curResult.sum += left.sum;
            curResult._values.addAll(left._values);
        }
        if(right.get){
            curResult.get = true;
            curResult.sum += right.sum;
            curResult._values.addAll(left._values);
        }

        System.out.println(curResult);

        return  curResult;
    }

    class Result{
       boolean get = false;
       int sum = 0;
       ArrayList<Integer> _values = new ArrayList<>();

        @Override
        public String toString() {
            return "Result{" +
                    "get=" + get +
                    ", sum=" + sum +
                    ", values=" + _values +
                    '}';
        }
    }

}
