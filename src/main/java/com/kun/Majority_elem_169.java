package com.kun;

public class Majority_elem_169 {
    public static void main(String[] args) {
        Majority_elem_169 majorityElem169 = new Majority_elem_169();

        int[] nums = new int[]{1,2,3,4,1,2,1,1};
        System.out.println(majorityElem169.majorityElement(nums));
        nums = new int[]{3,2,3};
        System.out.println(majorityElem169.majorityElement(nums));
        nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElem169.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        if(nums == null)
            return -1;

        int major = nums[0];
        int majorCount = 1;
        for(int i = 1; i<nums.length;i++){
           //Start a new major assumption
            if(majorCount == 0){
                major = nums[i];
                majorCount = 1;
            }else{
               if(nums[i] == major){
                   //Add itself
                   majorCount ++;
               } else{
                   //Just counteract
                   majorCount --;
               }
            }
        }

        if(majorCount != 0)
            return major;
        else
            return -1;
    }
}
