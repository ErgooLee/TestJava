package com.xiaowuzei.test.algr.leet;

import java.util.Random;

public class N398_RandomPickIndex {

    public static void main(String[] args) {
        N398_RandomPickIndex pickIndex = new N398_RandomPickIndex(new int[]{1, 2, 3, 3, 3});
        System.out.println(pickIndex.pick(1));
        System.out.println(pickIndex.pick(2));
        System.out.println(pickIndex.pick(3));
        System.out.println(pickIndex.pick(3));
        System.out.println(pickIndex.pick(3));
        System.out.println(pickIndex.pick(3));
        System.out.println(pickIndex.pick(3));
        System.out.println(pickIndex.pick(3));
        System.out.println(pickIndex.pick(3));
        System.out.println(pickIndex.pick(3));
        System.out.println(pickIndex.pick(3));
        System.out.println(pickIndex.pick(3));
        System.out.println(pickIndex.pick(3));
        System.out.println(pickIndex.pick(3));
    }

    int[] nums;

    public N398_RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int count = 0;
        int result = 0;
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                if (random.nextInt(++count) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }

}
