package com.kun;

import java.util.Arrays;

public class MaxSubArraySum_53 {
    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        MaxSubArraySum_53 maxSubArraySum53 = new MaxSubArraySum_53();
        int val = maxSubArraySum53.maxSubArray(nums);
        System.out.println(val);
    }

    public int maxSubArray(int[] nums) {
        int _start = 0;
        int _end = 0;
        int maxSum = nums[0];

        int len = nums.length;
        int[][] dp = new int[len][len];
        for(int i = 0;i<len;i++){
            dp[i][i] = nums[i];//Only contains itself
            if(nums[i] >maxSum) {
                maxSum = nums[i];
            }

            for(int j = i-1;j>=0;j--){
                int newSum = dp[i][i] + dp[j][i-1];
                dp[j][i] = newSum;
                if(newSum >maxSum){
                    maxSum = newSum;
                    _start = j;
                    _end = i;
                }
            }
        }

        int[] seq = Arrays.copyOfRange(nums,_start,_end+1);
        System.out.println(Arrays.toString(seq));

        return maxSum;
    }

}
