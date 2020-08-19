package com.xiaowuzei.test.algr.leet;

public class N72_EditDistance {

    public static void main(String[] args) {
        System.out.println(new N72_EditDistance().minDistance("horse", "ros"));
        System.out.println(new N72_EditDistance().minDistance("horse", ""));
        System.out.println(new N72_EditDistance().minDistance("", "tr"));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        int i, j;
        for (i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    private int min(int a, int b, int c) {
        if (a > b) {
            a = b;
        }
        if (a > c) {
            a = c;
        }
        return a;
    }
}
