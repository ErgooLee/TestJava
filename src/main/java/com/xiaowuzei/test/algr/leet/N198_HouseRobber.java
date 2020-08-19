package com.xiaowuzei.test.algr.leet;

public class N198_HouseRobber {
    public static void main(String[] args) {
        System.out.println(new N198_HouseRobber().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new N198_HouseRobber().rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new N198_HouseRobber().rob(new int[]{2, 1, 1, 2}));
    }

    //过于细节
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][1] = nums[i];
                dp[i][0] = 0;
            } else {
                if (i == 1) {
                    dp[i][1] = nums[i];
                } else {
                    dp[i][1] = Math.max(dp[i - 2][1] + nums[i], dp[i - 2][0] + nums[i]);
                }
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //dp[x] 表示抢劫钱n家能获取的最大收益
        int n = nums.length;
        int dp_i_2 = 0, dp_i_1 = 0, dp_i = 0;
        for (int num : nums) {
            dp_i = Math.max(dp_i_1, num + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
