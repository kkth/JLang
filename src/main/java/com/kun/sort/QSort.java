package com.kun.sort;

public class QSort {
    public static void main(String[] args) {
        QSort qSort = new QSort();
        //
        int[] nums = SortUtils.generate(10);
        SortUtils.print(nums);
        qSort.quickSort(nums);
        SortUtils.print(nums);
        //
        nums = SortUtils.generate(1);
        SortUtils.print(nums);
        qSort.quickSort(nums);
        SortUtils.print(nums);
        //
        nums = SortUtils.generate(2);
        SortUtils.print(nums);
        qSort.quickSort(nums);
        SortUtils.print(nums);
    }

    void quickSort(int[] nums){
        if(nums != null) {
            quickSort(nums, 0, nums.length - 1);
        }
    }

    void quickSort(int[] nums, int l, int r){
        if(l >= r)
            return;

        int midVal = nums[l];

        int smallerUpper = l;//midVal itself

        for(int i = l+1;i<=r;i++){
          if(nums[i] < midVal){
             swap(nums,i,smallerUpper+1);
             smallerUpper++;
          }
        }

        swap(nums,l,smallerUpper);

        quickSort(nums, l, smallerUpper-1);
        quickSort(nums,smallerUpper+1,r);
    }

    void swap(int[] nums, int x, int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
