package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;

public class N322_CoinChange {
    //dp
    public static void main(String[] args) {
        System.out.println(new N322_CoinChange().coinChange2(new int[]{1, 2, 5}, 11));
        System.out.println(new N322_CoinChange().coinChange(new int[]{1, 2, 5}, 11));

        System.out.println(new N322_CoinChange().coinChange2(new int[]{5, 7}, 6));
        System.out.println(new N322_CoinChange().coinChange2(new int[]{5, 6, 7}, 6));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        } else {
            return dp[amount];
        }
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        } else {
            return dp[amount];
        }
    }

}
