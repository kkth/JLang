package com.kun;

import java.util.Arrays;

public class CoinChange_322 {
    public static void main(String[] args) {
        CoinChange_322 coinChange322 = new CoinChange_322();
        System.out.println(coinChange322.coinChange(new int[]{1,2,5},11));
        System.out.println(coinChange322.coinChange(new int[]{2},3));

    }
    public int coinChange(int[] coins, int amount) {
        if(coins == null)
            return -1;
        Arrays.sort(coins);
        if(amount <coins[0])
            return  -1;

        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1;i<=amount;i++){
            //Set current amount as invalid by default
            dp[i] = -1;
            for(int coin: coins){
                //This is the coin value itself!
                if(coin == i){
                    dp[i] = 1;
                    break;
                }else {
                    //Look back, remember to check it's a valid amount (remain value >=0)
                    if (i-coin >=0) {
                        int prevCount = dp[i - coin];
                        //Previous amount is valid
                        if (prevCount != -1) {
                            if (dp[i] == -1) { //Current count is not set yet
                                dp[i] = prevCount + 1;
                            } else if (prevCount + 1 < dp[i]) {//Get a solution with less coins
                                dp[i] = prevCount + 1;
                            }
                        }
                    }
                }

            }
        }

        return dp[amount];

    }
}
