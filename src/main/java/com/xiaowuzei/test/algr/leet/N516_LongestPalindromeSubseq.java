package com.xiaowuzei.test.algr.leet;

public class N516_LongestPalindromeSubseq {
    public static void main(String[] args) {
        System.out.println(new N516_LongestPalindromeSubseq().longestPalindromeSubseq("bbbab"));
        System.out.println(new N516_LongestPalindromeSubseq().longestPalindromeSubseq("cbbq"));

    }

    public int longestPalindromeSubseq(String s) {
        int M = s.length();
        int[][] dp = new int[M + 1][M + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= M; j++) {
                if (s.charAt(i - 1) == s.charAt(M - j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][M];
    }

    public int longestPalindromeSubseq2(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

}
