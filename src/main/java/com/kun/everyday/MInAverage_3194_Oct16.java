package com.kun.everyday;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MInAverage_3194_Oct16 {
    public static void main(String[] args) {
        MInAverage_3194_Oct16 mInAverage3194Oct16 = new MInAverage_3194_Oct16();
        int[] nums = new int[]{7,8,3,4,15,13,4,1};
        System.out.println(mInAverage3194Oct16.minimumAverage(nums));
    }

    public double minimumAverage(int[] nums) {
        qsort(nums);
        PriorityQueue<Double> queue = new PriorityQueue<Double>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1.compareTo(o2);
            }
        });
        for(int i = 0;i<nums.length/2;i++){
            queue.add((double) ((nums[i] + nums[nums.length-1-i])/2.0F));
        }

        return  queue.poll();
    }

    public void qsort(int[] nums){
      qsort(nums,0, nums.length-1);
      System.out.println(Arrays.toString(nums));
    }
    public void qsort(int[] nums,int start,int end){
        if(start >= end){
            return;
        }

        int middleVal = nums[start];
        int lowerUpper = start;
        int cur = lowerUpper+1;
        for(;cur<= end;cur++){
           if(nums[cur] < middleVal){
               swap(nums,cur,lowerUpper+1);
               lowerUpper++;
           }
        }

        swap(nums,start,lowerUpper);
        qsort(nums, start, lowerUpper-1);
        qsort(nums, lowerUpper+1, end);
    }

    public void swap(int[] nums, int p, int q){
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
}
