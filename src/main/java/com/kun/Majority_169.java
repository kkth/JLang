package com.kun;

import java.util.jar.JarEntry;

public class Majority_169 {

    public static void main(String[] args){
        Majority_169 majority169 = new Majority_169();

        int[] nums = new int[]{1,2,1,2,1,2,1};
        System.out.println(majority169.getLocalMajority(nums,0,nums.length-1));
         nums = new int[]{1,2,1,1,2,2,1};
        System.out.println(majority169.getLocalMajority(nums,0,nums.length-1));
    }



    int getLocalMajority(int[] nums, int start, int end){
        if(start == end){ //Now a single element
            return nums[start];
        }else{//split it
            int left = getLocalMajority(nums,start, (start + end)/2);
            int right = getLocalMajority(nums,(start+end)/2+1,end);
            if(left == right){//In both sides
                return left;
            }else{
                //
                int leftCount = 0;
                for(int i = start; i<=(start+end)/2;i++){
                    if(nums[i] == left){
                        leftCount++;
                    }
                }

                int rightCount = 0;
                for(int i=(start+end)/2+1;i<end;i++){
                    if(nums[i] == right){
                        rightCount++;
                    }
                }

                if(leftCount > rightCount)
                    return left;
                else
                    return right;
            }

        }

    }

}
