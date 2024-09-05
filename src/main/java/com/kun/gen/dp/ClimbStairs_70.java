package com.kun.gen.dp;

public class ClimbStairs_70 {
    public static void main(String[] args) {
        ClimbStairs_70 climbStairs70 = new ClimbStairs_70();
        System.out.println(climbStairs70.climbStairs(1));
        System.out.println(climbStairs70.climbStairs(2));
        System.out.println(climbStairs70.climbStairs(3));

    }
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3;i<=n;i++){
           dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
