package com.kun;

public class Stairs_70 {
    public static void main(String[] args){
       Stairs_70 stairs70 = new Stairs_70();
       System.out.println(stairs70.climbStairs(3));
    }

    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
