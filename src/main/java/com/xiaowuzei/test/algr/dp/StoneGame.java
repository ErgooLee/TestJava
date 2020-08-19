package com.xiaowuzei.test.algr.dp;

public class StoneGame {
    public static void main(String[] args) {
        System.out.println(new StoneGame().max(new int[]{3, 9, 1, 2}));
        System.out.println(new StoneGame().max2(new int[]{3, 9, 1, 2}));
    }

    public int max(int[] stones) {
        int N = stones.length;
        int[][][] dp = new int[N][N][2];
        int i, j, x, y, left, right;
        int[] pair;
        for (i = 0; i < N; i++) {
            pair = dp[i][i];
            pair[0] = stones[i];
            pair[1] = 0;
        }
        for (i = 1; i <= N - 1; i++) {
            for (j = 0; j <= N - 1 - i; j++) {
                x = j;
                y = j + i;
                pair = dp[x][y];
                left = stones[x] + dp[x + 1][y][1];
                right = stones[y] + dp[x][y - 1][1];
                if (left > right) {
                    pair[0] = left;
                    pair[1] = dp[x + 1][y][0];
                } else {
                    pair[0] = right;
                    pair[1] = dp[x][y - 1][0];
                }
            }
        }
        pair = dp[0][N - 1];
        return pair[0] - pair[1];
    }

    public int max2(int[] stones) {
        int N = stones.length;
        int[][] dp = new int[(N + 1) * N / 2][2];
        int i, j, x, y, left, right;
        int[] pair;

        for (i = 0; i < N; i++) {
            pair = dp[t(i, i, N)];
            pair[0] = stones[i];
            pair[1] = 0;
        }
        for (i = 1; i <= N - 1; i++) {
            for (j = 0; j <= N - 1 - i; j++) {
                x = j;
                y = j + i;
                pair = dp[t(x, y, N)];
                left = stones[x] + dp[t(x + 1, y, N)][1];
                right = stones[y] + dp[t(x, y - 1, N)][1];
                if (left > right) {
                    pair[0] = left;
                    pair[1] = dp[t(x + 1, y, N)][0];
                } else {
                    pair[0] = right;
                    pair[1] = dp[t(x, y - 1, N)][0];
                }
            }
        }
        pair = dp[t(0, N - 1, N)];
        return pair[0] - pair[1];
    }

    private int t(int x, int y, int n) {
        return (n + n - x + 1) * x / 2 + y - x;
    }
}
