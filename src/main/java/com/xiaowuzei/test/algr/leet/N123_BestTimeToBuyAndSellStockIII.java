package com.xiaowuzei.test.algr.leet;

public class N123_BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        System.out.println(new N123_BestTimeToBuyAndSellStockIII().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(new N123_BestTimeToBuyAndSellStockIII().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new N123_BestTimeToBuyAndSellStockIII().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    //2次交易
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 2);
    }

    //k次交易 k>n/2次浪费内存
    public int maxProfit(int[] prices, int k) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[][][] dp = new int[n][k][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    dp[i][j][0] = Math.max(0, Integer.MIN_VALUE + prices[i]);
                    dp[i][j][1] = Math.max(Integer.MIN_VALUE, -prices[i]);
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    if (j == 0) {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], - prices[i]);
                    } else {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                    }
                }
            }
        }
        return dp[n - 1][k - 1][0];
    }
}
