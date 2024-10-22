package com.kun.oct;

public class ZeroOnePackage {
    public static void main(String[] args) {
        int[][] wv = new int[][]{{6,30},{3,14},{4,16},{2,9}};
        ZeroOnePackage zeroOnePackage = new ZeroOnePackage();
        System.out.println(zeroOnePackage.solution(wv,10));
    }


    public int solution(int[][] wv, int capacity){
        int maxValue = 0;
        int goodsCount = wv.length;
        int[][] dp = new int[goodsCount+1][capacity+1];

        //Init
        for(int j = 0;j<capacity +1;j++){
            dp[0][j] = 0;
        }
        for(int i = 0;i< goodsCount; i++){
           dp[i][0] = 0;
        }

        int mvWeightIndex = 0;
        int mvValueIndex = 1;

        for(int i = 1;i <= goodsCount;i++){
            int mvIndex = i-1;
            for(int j = 1;j<= capacity;j++){
                if(j>=wv[mvIndex][mvWeightIndex]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wv[mvIndex][mvWeightIndex]] + wv[mvIndex][mvValueIndex]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        maxValue = dp[goodsCount][capacity];
        return maxValue;
    }

}
