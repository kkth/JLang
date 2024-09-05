package com.kun.gen.dp;

//https://leetcode.cn/problems/fibonacci-number/

//One dimension dp
/*
    dp[0] = 0
    dp[1] = 1
    dp[i] = dp[i-1}+dp[i-2]

 */
public class Fib_509 {
    public static void main(String[] args) {
        Fib_509 fib509 = new Fib_509();
        System.out.println(fib509.fib(0));
        System.out.println(fib509.fib(1));
        System.out.println(fib509.fib(2));
        System.out.println(fib509.fib(3));
        System.out.println(fib509.fib(4));
    }
    public int fib(int n) {
        if(n<0)
            return -1;

        int[] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];
    }
}
