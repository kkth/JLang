package com.kun;

import java.util.Arrays;

public class NextPermutation_31 {
    public static void main(String[] args) {
        NextPermutation_31 nextPermutation31 = new NextPermutation_31();

        int[] nums = new int[]{1,2,3};
        System.out.println(Arrays.toString(nums));
        nextPermutation31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2,3,1};
        System.out.println(Arrays.toString(nums));
        nextPermutation31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{3,2,1};
        System.out.println(Arrays.toString(nums));
        nextPermutation31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        if (nums != null){
            int len = nums.length;

            //Loop back, find the first one that is not in descend series
            int i = len -1;
            for(;i>0;i--){
                if(nums[i-1]<nums[i])
                    break;
            }

            //Unnecessary, just make it clear
            int r = len -1;
            int l = 0;

            //Start of descend series Still in array
            if(i>=1){
                l = i;
                //Find the index to swap
                for(int j=len-1;j>=i;j--){
                    //swap
                   if(nums[j]>nums[i-1]){
                       int tmp = nums[j];
                       nums[j] = nums[i-1];
                       nums[i-1] = tmp;
                       break;
                   }
                }
            }
            //else: all elements are sorted descend (like [3,2,1]), sort entire array to restart the loop

            //System.out.println(" " + l +"," + r);
            Arrays.sort(nums,l,r+1);

        }

    }
}

