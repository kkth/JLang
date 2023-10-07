package com.kun;

import java.util.Arrays;

public class PartitionEqual_416 {
    public static void main(String[] args) {
        PartitionEqual_416 partitionEqual416 = new PartitionEqual_416();
        System.out.println(partitionEqual416.canPartition(new int[]{1,5,11,5}));
        System.out.println(partitionEqual416.canPartition(new int[]{1,2,3,5}));
    }
    public boolean canPartition(int[] nums) {
        if(nums == null|| nums.length <2)
            return false;

        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum%2 != 0)
            return false;

        sum /= 2;

        int len = nums.length;
        boolean[][] dp = new boolean[len][sum+1];
        //Initial column for value 0: all are true
        for(int i = 0;i<len;i++)
            dp[i][0] =  true;

        //Initial first line, that is, the solution for only single first value from nums (nums[0])
        for(int j = 1;j<sum+1;j++)
            dp[0][j] = (nums[0] == j);

        for(int j = 1;j<sum+1;j++){
            for(int i = 1;i<len;i++) {
                if (nums[i] > j) {//larger than current number, impossible to insert current element. Just keep the result of previous solution(0~nums[i-1])
                    dp[i][j] = dp[i-1][j];
                } else {
                    //Down scale the problem to try to fill in package with elements from 0 ~ nums[i-1] and
                    //package length to j- nums[i]
                    //2 success scenarios
                    //1.There's solution for fill package with length j-nums[i] by elements 0 ~ nums[i-1]: add current element (nums[i])
                    //2.There's solution for fill package with length j by elements 0~ nums[i]: they can fill, unecessary to add current element(nums[i])
                    dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j];
                }
            }
        }
        for(boolean[] line: dp){
            System.out.println(Arrays.toString(line));
        }
        System.out.println("===================");
        return dp[len-1][sum];
    }
}
