package com.xiaowuzei.test.algr.leet;

public class N188_BestTimeToBuyAndSellStockIV {

    public static void main(String[] args) {
        System.out.println(new N188_BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(new N188_BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(new N188_BestTimeToBuyAndSellStockIV().maxProfit(0, new int[]{1, 3}));
    }

    //n次交易
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k == 0) {
            return 0;
        }
        int n = prices.length;
        if (k > n / 2) {
            int dp_i_0 = 0;
            int dp_i_1 = -prices[0];
            int tmp1;
            int tmp2;
            for (int i = 1; i < n; i++) {
                tmp1 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                tmp2 = Math.max(dp_i_1, dp_i_0 - prices[i]);
                dp_i_0 = tmp1;
                dp_i_1 = tmp2;
            }
            return dp_i_0;
        }
        int[][][] dp = new int[n][k][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    dp[i][j][0] = Math.max(0, Integer.MIN_VALUE + prices[i]);
                    dp[i][j][1] = Math.max(Integer.MIN_VALUE, -prices[i]);
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    if (j == 0) {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], -prices[i]);
                    } else {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                    }
                }
            }
        }
        return dp[n - 1][k - 1][0];
    }
}
