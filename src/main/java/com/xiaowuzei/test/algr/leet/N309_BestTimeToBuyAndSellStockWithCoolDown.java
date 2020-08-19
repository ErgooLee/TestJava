package com.xiaowuzei.test.algr.leet;

public class N309_BestTimeToBuyAndSellStockWithCoolDown {
    public static void main(String[] args) {
        System.out.println(new N309_BestTimeToBuyAndSellStockWithCoolDown().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                if (i == 1) {
                    dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
                } else {
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
                }
            }
        }
        return dp[n - 1][0];
    }
}
