package com.xiaowuzei.test.algr.dp;

import com.xiaowuzei.test.Utils;

public class BB_01 {
    //dp   0/1背包问题
    public static void main(String[] args) {
        System.out.println(new BB_01().knapsack(new int[]{2, 1, 3}, new int[]{4, 2, 3}, 4));
    }

    public int knapsack(int[] wt, int[] val, int W) {
        int N = wt.length;
        int[][] dp = new int[N + 1][W + 1];
        int weight, tmp;
        for (int i = 1; i <= N; i++) {
            weight = wt[i - 1];
            for (int w = 1; w <= W; w++) {
                tmp = w - weight;
                if (tmp < 0) {
                    //这种情况下只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    //装入或者不装入背包，择优
                    dp[i][w] = Math.max(dp[i - 1][tmp] + val[i - 1], dp[i - 1][w]);
                }
            }
        }
        System.out.println(Utils.toString(dp));
        return dp[N][W];
    }
}
