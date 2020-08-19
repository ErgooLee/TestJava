package com.xiaowuzei.test.algr.swordoffer;

public class N53_MissingNumber {
    public static void main(String[] args) {
        System.out.println(new N53_MissingNumber().missingNumber(new int[]{0, 1, 2, 3, 4, 5, 7}));
        System.out.println(new N53_MissingNumber().missingNumber(new int[]{1}));
        System.out.println(new N53_MissingNumber().missingNumber(new int[]{0, 1}));
        System.out.println(new N53_MissingNumber().missingNumber(new int[]{0, 2}));
        System.out.println(new N53_MissingNumber().missingNumber(new int[]{0}));
    }

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == nums.length) {
            return left;
        } else {
            return nums[left] - 1;
        }
    }
}
