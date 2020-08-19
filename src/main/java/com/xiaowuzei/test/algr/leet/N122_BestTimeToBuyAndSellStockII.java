package com.xiaowuzei.test.algr.leet;

public class N122_BestTimeToBuyAndSellStockII {

    //无限次交易
    public static void main(String[] args) {
        System.out.println(new N122_BestTimeToBuyAndSellStockII().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new N122_BestTimeToBuyAndSellStockII().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new N122_BestTimeToBuyAndSellStockII().maxProfit(new int[]{1, 2}));
        System.out.println(new N122_BestTimeToBuyAndSellStockII().maxProfit(new int[]{2, 1}));
        System.out.println(new N122_BestTimeToBuyAndSellStockII().maxProfit(new int[]{2}));
        System.out.println(new N122_BestTimeToBuyAndSellStockII().maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
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

}
