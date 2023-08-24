package com.kun;

import java.util.jar.JarEntry;

public class Majority_169 {
/*
    public static void main(String[] args){
        int[] nums = new int[]{1,2,1,2,1,2,1};
        Majority_169 majority169 = new Majority_169();
        System.out.println(majority169.majorityElement(nums));
    }


    public int majorityElement(int[] nums) {

    }

    Result getLocalMajority(int[] nums, int start, int end){
        Result ret = new Result();
        if(start == end){ //Now a single element
            ret.getIt = true;
            ret.val = nums[start];
        }else{//split it
            Result left = getLocalMajority(nums,start, (start + end)/2);
            Result right = getLocalMajority(nums,(start+end)/2+1,end);
            if(left.getIt && right.getIt){
                if(left.val == right.val){
                    ret.getIt = true;
                    ret.val = left.val;
                }else if(){}

            }
        }

        return ret;
    }

    class Result{
        Boolean getIt = false;
        int val = 0;
    }
 */
}
