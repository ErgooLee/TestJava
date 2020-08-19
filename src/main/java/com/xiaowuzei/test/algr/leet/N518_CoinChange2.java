package com.xiaowuzei.test.algr.leet;

public class N518_CoinChange2 {

    public static void main(String[] args) {
        System.out.println(new N518_CoinChange2().change2(5, new int[]{1, 2, 5}));
//        System.out.println(new N518_CoinChange2().change2(10, new int[]{10}));
//        System.out.println(new N518_CoinChange2().change2(10, new int[]{9}));
//        System.out.println(new N518_CoinChange2().change2(0, new int[]{}));
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        int coin, tmp;
        for (int j = 0; j < coins.length + 1; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                tmp = j - coin;
                if (tmp >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][tmp];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        int coin, tmp;
        for (int i = 1; i <= coins.length; i++) {
            coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                tmp = j - coin;
                if (tmp >= 0) {
                    dp[j] = dp[j] + dp[tmp];
                }
            }
        }
        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }

}
