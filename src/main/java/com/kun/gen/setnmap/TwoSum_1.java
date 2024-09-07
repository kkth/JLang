package com.kun.gen.setnmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public static void main(String[] args) {
        TwoSum_1 twoSum1 = new TwoSum_1();
        int[] nums1 = new int[]{2,7,11,15};
        int[] nums2 = new int[]{3,2,4};
        System.out.println(Arrays.toString(twoSum1.twoSum(nums1,9)));
        System.out.println(Arrays.toString(twoSum1.twoSum(nums2,6)));
    }
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i= 0;i<nums.length;i++){
            if(indexMap.containsKey(target-nums[i])) {
                ret[0] = indexMap.get(target - nums[i]);
                ret[1] = i;
                break;
            }else{
                indexMap.put(nums[i],i);
            }
        }

        return ret;
    }
}
