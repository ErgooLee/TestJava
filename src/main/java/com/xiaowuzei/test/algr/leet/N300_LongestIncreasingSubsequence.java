package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;

public class N300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new N300_LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new N300_LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9}));
        System.out.println(new N300_LongestIncreasingSubsequence().lengthOfLIS(new int[]{9, 10, 11}));
        System.out.println(new N300_LongestIncreasingSubsequence().lengthOfLIS(new int[]{9, 1, 11}));
        System.out.println(new N300_LongestIncreasingSubsequence().lengthOfLIS(new int[]{3, 2, 1}));
        System.out.println("--------------");

        System.out.println(new N300_LongestIncreasingSubsequence().lengthOfLIS2(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new N300_LongestIncreasingSubsequence().lengthOfLIS2(new int[]{10, 9}));
        System.out.println(new N300_LongestIncreasingSubsequence().lengthOfLIS2(new int[]{9, 10, 11}));
        System.out.println(new N300_LongestIncreasingSubsequence().lengthOfLIS2(new int[]{9, 1, 11}));
        System.out.println(new N300_LongestIncreasingSubsequence().lengthOfLIS2(new int[]{3, 2, 1}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLength = 1, tmp;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tmp = dp[j] + 1;
                    if (dp[i] < tmp) {
                        dp[i] = tmp;
                        if (maxLength < tmp) {
                            maxLength = tmp;
                        }
                    }
                }
            }
        }
        return maxLength;
    }


    public int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;
        int tmp;
        int left, right;
        for (int num : nums) {
            tmp = num;
            left = 0;
            right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] < tmp) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = tmp;
        }
        return piles;
    }

}
