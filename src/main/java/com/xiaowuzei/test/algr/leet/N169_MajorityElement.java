package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;

public class N169_MajorityElement {
    public static void main(String[] args) {
        System.out.println(new N169_MajorityElement().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new N169_MajorityElement().majorityElement(new int[]{3}));
        System.out.println(new N169_MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
