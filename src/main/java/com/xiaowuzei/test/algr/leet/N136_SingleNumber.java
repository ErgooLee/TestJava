package com.xiaowuzei.test.algr.leet;

public class N136_SingleNumber {
    public static void main(String[] args) {
        System.out.println(new N136_SingleNumber().singleNumber(new int[]{1, 2, 1, 2, 4}));
    }

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret = ret ^ num;
        }
        return ret;
    }
}
