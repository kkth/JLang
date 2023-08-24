package com.kun.sort;

import java.util.Arrays;

public class QuickSort {
    //smaller on the left and bigger on the right
    void quickSort(int[] nums){
         quickSort(nums,0,nums.length-1);
    }
    void quickSort(int[] nums,int low, int high){
       if(low>=high)
           return;

       /*
       1.final layout:[smaller than first element, first element, bigger than first element]
       2.to make it simple, we assume the first element belongs to smaller part
       3.so it should be the first one of smaller part as initial value
        */
       int smallUpper = low;
       int midVal = nums[low];

       for(int cur = low+1;cur<=high;cur++){
           if(nums[cur] < midVal) {
               swap(nums, cur, smallUpper+1);
               smallUpper++;
           }
       }

       swap(nums,low,smallUpper);


       quickSort(nums,low,smallUpper-1);
       quickSort(nums,smallUpper+1,high);

    }

    void swap(int[] nums, int indexA, int indexB){
            int tmp = nums[indexA];
            nums[indexA] = nums[indexB];
            nums[indexB] = tmp;
    }
}
