package com.kun;

import java.util.Arrays;

public class RemoveDuplicates_26 {

    public static void main(String[] args) {
        RemoveDuplicates_26 removeDuplicates26 = new RemoveDuplicates_26();
        int[] nums = new int[]{1,1,2};
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicates26.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicates26.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

    public int removeDuplicates(int[] nums) {
        int p =0;
        int q = 0;
        for(;q<nums.length;q++){
            if(nums[q] != nums[p]){
               nums[p+1] = nums[q];
               p++;
            }
        }
        return p;
    }
}
