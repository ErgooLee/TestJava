package com.xiaowuzei.test.algr.leet;

public class N213_HouseRobberII {

    public static void main(String[] args) {
        System.out.println(new N213_HouseRobberII().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new N213_HouseRobberII().rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new N213_HouseRobberII().rob(new int[]{2, 1, 1, 2}));
        System.out.println(new N213_HouseRobberII().rob(new int[]{2, 1, 1, 8, 1}));
        System.out.println(new N213_HouseRobberII().rob(new int[]{2, 1}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    public int rob(int[] nums, int start, int end) {
        //dp[x] 表示抢劫钱n家能获取的最大收益
        int dp_i_2 = 0, dp_i_1 = 0, dp_i = 0;
        for (int i = start; i <= end; i++) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
