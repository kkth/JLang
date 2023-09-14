package com.kun;

import com.kun.sort.SortUtils;

public class BinarySearch {
    public static void main(String[] args){
        //int[] nums = SortUtils.generate(0,100,10);
        int[] nums = new int[]{1,5,20,30,31,50,100};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.find(nums,1));
        System.out.println(binarySearch.find(nums,5));
        System.out.println(binarySearch.find(nums,20));
        System.out.println(binarySearch.find(nums,30));
        System.out.println(binarySearch.find(nums,31));
        System.out.println(binarySearch.find(nums,50));
        System.out.println(binarySearch.find(nums,100));
        System.out.println(binarySearch.find(nums,101));
    }

    int find(int[] nums,int target){
        int pos = -1;
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                pos = mid;
                break;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return pos;
    }
}
