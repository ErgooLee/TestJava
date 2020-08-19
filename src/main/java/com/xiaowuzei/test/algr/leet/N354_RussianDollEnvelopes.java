package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;

public class N354_RussianDollEnvelopes {

    public static void main(String[] args) {
//        System.out.println(new N354_RussianDollEnvelopes().maxEnvelopes(
//                new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));

        System.out.println(new N354_RussianDollEnvelopes().maxEnvelopes(
                new int[][]{{1, 8}, {2, 3}, {5, 6}, {5, 4}, {5, 2}, {6, 7}, {6, 4}}));

//        System.out.println(new N354_RussianDollEnvelopes().maxEnvelopes(
//                new int[][]{{10, 8}, {1, 12}, {6, 15}, {2, 18}}));

    }

    public int maxEnvelopes2(int[][] envelopes) {
        if (envelopes.length < 2) {
            return envelopes.length;
        }
        Arrays.sort(envelopes, (o1, o2) -> {
            int result = Integer.compare(o1[0], o2[0]);
            if (result == 0) {
                return Integer.compare(o1[1], o2[1]);
            }
            return result;
        });
        int maxCount = 1;
        int[] dp = new int[envelopes.length];
        int[] tmpi, tmpj;
        dp[0] = 1;
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            tmpi = envelopes[i];
            for (int j = i - 1; j >= 0; j--) {
                tmpj = envelopes[j];
                if (dp[i] < (dp[j] + 1) && tmpi[0] > tmpj[0] && tmpi[1] > tmpj[1]) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > maxCount) {
                        maxCount = dp[i];
                    }
                }
            }
        }
        return maxCount;
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length < 2) {
            return envelopes.length;
        }
        Arrays.sort(envelopes, (o1, o2) -> {
            int result = Integer.compare(o1[0], o2[0]);
            if (result == 0) {
                return Integer.compare(o2[1], o1[1]);
            }
            return result;
        });
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) {
            heights[i] = envelopes[i][1];
        }
        return lis(heights);
    }

    private int lis(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int insertPoint = Arrays.binarySearch(dp, 0, len, num);
            if (insertPoint < 0) {
                insertPoint = -(insertPoint + 1);
            }
            dp[insertPoint] = num;
            if (insertPoint == len) {
                len++;
            }
        }
        return len;
    }
}
