package com.xiaowuzei.test.algr.dp;

public class KMP {
    int[][] dp;
    String pattern;

    public static void main(String[] args) {
        KMP pattern = new KMP("ababc");
        System.out.println(pattern.search("ababaababc"));

    }


    public KMP(String pattern) {
        this.pattern = pattern;

        dp = new int[pattern.length()][256];
        int x = 0;
        dp[0][pattern.charAt(0)] = 1;
        for (int i = 1; i < pattern.length(); i++) {
            for (char c = 0; c < 256; c++) {
                dp[i][c] = dp[x][c];
            }
            dp[i][pattern.charAt(i)] = i + 1;
            x = dp[x][pattern.charAt(i)];
        }
    }

    public int search(String text) {
        if (text == null) {
            return -1;
        }
        int state = 0;
        for (int i = 0; i < text.length(); i++) {
            state = dp[state][text.charAt(i)];
            if (state == pattern.length()) {
                return i - pattern.length() + 1;
            }
        }
        return -1;
    }
}
