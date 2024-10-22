package com.kun.gen.dp;

import com.kun.MaxSubArraySum_53;

import javax.security.auth.login.CredentialException;
import java.util.Arrays;

public class MaxSumSubArray_53 {
    public static void main(String[] args) {
       int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArraySum_53 maxSubArraySum53 = new MaxSubArraySum_53();
        System.out.println(maxSubArraySum53.maxSubArray(nums));

    }

    public int maxSubArray(int[] nums) {
        int maxVal = nums[0];
        int maxStart = 0;
        int maxEnd = 0;

        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int i = 0;i<n;i++){
            dp[i][i] = nums[i];
            for(int j = 0;j<i;j++){
                dp[j][i] = dp[j][i-1] + dp[i][i];
                if(dp[j][i] > maxVal){
                    maxVal = dp[j][i];
                    maxStart = j;
                    maxEnd = i;
                }
            }
        }

        int[] subArray = Arrays.copyOfRange(nums, maxStart,maxEnd);
        System.out.println(Arrays.toString(subArray));

        return maxVal;
    }
}
