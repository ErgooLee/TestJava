package com.xiaowuzei.test.algr.leet;

public class N714_BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        System.out.println(new N714_BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        int tmp1;
        int tmp2;
        for (int i = 1; i < n; i++) {
            tmp1 = Math.max(dp_i_0, dp_i_1 + prices[i] - fee);
            tmp2 = Math.max(dp_i_1, dp_i_0 - prices[i]);
            dp_i_0 = tmp1;
            dp_i_1 = tmp2;
        }
        return dp_i_0;
    }

}
