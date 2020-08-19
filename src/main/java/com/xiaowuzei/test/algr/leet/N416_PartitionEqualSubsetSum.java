package com.xiaowuzei.test.algr.leet;

public class N416_PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(new N416_PartitionEqualSubsetSum().canPartition2(new int[]{1, 5, 11, 5}));
        System.out.println(new N416_PartitionEqualSubsetSum().canPartition2(new int[]{1, 5, 11, 7}));
        System.out.println(new N416_PartitionEqualSubsetSum().canPartition2(new int[]{1, 2, 5}));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int half = sum / 2;
        if (half * 2 != sum) {
            return false;
        }
        int[][] dp = new int[nums.length + 1][half + 1];
        int num, tmp;
        for (int j = 0; j < nums.length + 1; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            num = nums[i - 1];
            for (int j = 1; j <= half; j++) {
                tmp = j - num;
                if (tmp >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][tmp];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][half] != 0;
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int half = sum / 2;
        if (half * 2 != sum) {
            return false;
        }
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        int num;
        for (int i = 1; i <= nums.length; i++) {
            num = nums[i - 1];
            for (int j = half; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[half];
    }


}
