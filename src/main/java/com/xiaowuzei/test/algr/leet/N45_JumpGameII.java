package com.xiaowuzei.test.algr.leet;

public class N45_JumpGameII {

    public static void main(String[] args) {
        System.out.println(new N45_JumpGameII().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new N45_JumpGameII().jump(new int[]{0}));
        System.out.println(new N45_JumpGameII().jump(new int[]{1, 0}));
    }

    public int jump(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return 0;
        }
        int[] dp = new int[length];
        int max = 0;
        int nextMax;
        int newStep;
        for (int i = 0; i <= max; i++) {
            nextMax = i + nums[i];
            newStep = dp[i] + 1;
            if (nextMax >= length - 1) {
                return newStep;
            }
            for (int j = nextMax; j > max; j--) {
                dp[j] = newStep;
            }
            if (nextMax > max) {
                max = nextMax;
            }
        }
        return dp[length - 1];
    }


}
