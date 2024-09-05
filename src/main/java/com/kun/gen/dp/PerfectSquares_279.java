package com.kun.gen.dp;

/*
    https://leetcode.cn/problems/perfect-squares/
    dp[i] = min(dp[i-j*j] + dp[j*j]) for j in (1,lower_int(sqrt(i)))
    dp[j*j] is 1
    dp[i] = min(dp[i-j*j] + 1) for j in (1,lower_int(sqrt(i)))

 */
public class PerfectSquares_279 {

    public static void main(String[] args) {

    }
    public int numSquares(int n) {
        int []dp = new int[n+1];

        dp[0] = 0;//Used to represent the case that n itself is a square number
        dp[1] = 1;

        for(int i = 2;i<=n;i++){
            int minCount = -1;
            for (int j =1;j*j<=i;j++) {
                int currentCount = dp[i-j*j] +1;
                if (minCount == -1) {
                    minCount = currentCount;
                }else{
                    if(currentCount < minCount){
                        minCount = currentCount;
                    }
                }
            }
            dp[i] = minCount;
        }

        return dp[n];
    }
}
