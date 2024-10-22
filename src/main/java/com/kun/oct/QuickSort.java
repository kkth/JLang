package com.kun.oct;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        QuickSort quickSort = new QuickSort();

        int[] nums = new int[]{4,5,6,7,1};
        System.out.println(Arrays.toString(nums));
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));

       nums = new int[]{4,1,5,6,7};
        System.out.println(Arrays.toString(nums));
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void sort(int[] nums){
        qsort(nums, 0, nums.length-1);

    }

    public void qsort(int[] nums, int start,int end){
       if(start >= end){
           return;
       }

       int middleVal = nums[start];
       int smallerTop = start;
       int cur = smallerTop +1;
       for(;cur<=end; cur++){
            if(nums[cur] <= middleVal){
               swap(nums,cur,smallerTop+1);
               smallerTop++;
            }
       }
       swap(nums,start,smallerTop);

       qsort(nums, start, smallerTop-1);
       qsort(nums, smallerTop+1,end);
    }

    public void swap(int[] nums, int p, int q){
       int tmp = nums[p];
       nums[p] = nums[q];
       nums[q] = tmp;
    }
}

