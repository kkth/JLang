package com.kun.gen.sort;

import com.kun.gen.utils.SortUtils;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] origin = SortUtils.genRandom(100,10);
        System.out.println(Arrays.toString(origin));
        quickSort.sort(origin);
        System.out.println(Arrays.toString(origin));

    }

    public void sort(int[] nums){
        sort(nums,0,nums.length-1);
    }

    public void sort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }

        int middleVal = nums[left];
        int smallUpper = left;
        for(int cur = left +1; cur<=right;cur++){
            if(nums[cur] < middleVal){
               swap(nums,cur, smallUpper+1);
               smallUpper++;
            }
        }
        swap(nums,left, smallUpper);

        sort(nums, left,smallUpper-1);
        sort(nums, smallUpper+1,right);

    }

    public void swap(int[] nums, int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] =  temp;
    }
}
