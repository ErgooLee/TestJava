package com.xiaowuzei.test.algr.leet;

public class N268_MissingNumber {
    public static void main(String[] args) {
        System.out.println(new N268_MissingNumber().missingNumber(new int[]{3, 0, 1}));
        System.out.println(new N268_MissingNumber().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    public int missingNumber(int[] nums) {
        int n = (nums.length) * (nums.length + 1) / 2;
        for (int num : nums) {
            n -= num;
        }
        return n;
    }

    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
