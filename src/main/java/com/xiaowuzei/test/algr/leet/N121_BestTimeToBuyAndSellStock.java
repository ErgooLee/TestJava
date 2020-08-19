package com.xiaowuzei.test.algr.leet;

public class N121_BestTimeToBuyAndSellStock {

    //一次交易
    public static void main(String[] args) {
        System.out.println(new N121_BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new N121_BestTimeToBuyAndSellStock().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new N121_BestTimeToBuyAndSellStock().maxProfit(new int[]{1,2}));
        System.out.println(new N121_BestTimeToBuyAndSellStock().maxProfit(new int[]{2,1}));
        System.out.println(new N121_BestTimeToBuyAndSellStock().maxProfit(new int[]{2}));
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0, tmp = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                tmp = prices[j] - prices[i];
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice)
                minprice = price;
            else if (price - minprice > maxprofit)
                maxprofit = price - minprice;
        }
        return maxprofit;
    }
}
