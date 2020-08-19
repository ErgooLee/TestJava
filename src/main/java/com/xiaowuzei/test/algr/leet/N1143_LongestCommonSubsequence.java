package com.xiaowuzei.test.algr.leet;

public class N1143_LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(new N1143_LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
        System.out.println(new N1143_LongestCommonSubsequence().longestCommonSubsequence("abc", "abc"));
        System.out.println(new N1143_LongestCommonSubsequence().longestCommonSubsequence("abc", "def"));
        System.out.println(new N1143_LongestCommonSubsequence().longestCommonSubsequence("abc", "a"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length(), N = text2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][N];
    }


}
