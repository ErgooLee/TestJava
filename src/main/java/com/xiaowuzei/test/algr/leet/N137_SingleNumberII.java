package com.xiaowuzei.test.algr.leet;

public class N137_SingleNumberII {
    public static void main(String[] args) {
        System.out.println(new N137_SingleNumberII().singleNumber(new int[]{2, 2, 2, 3}));
        System.out.println(new N137_SingleNumberII().singleNumber(new int[]{43, 16, 45, 89, 45, -2147483648, 45, 2147483646, -2147483647, -2147483648, 43, 2147483647, -2147483646, -2147483648, 89, -2147483646, 89, -2147483646, -2147483647, 2147483646, -2147483647, 16, 16, 2147483646, 43}));
    }

    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += num & 1;
                num = num >> 1;
            }
        }
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result += counts[i] % 3;
            if (i != 0) {
                result <<= 1;
            }
        }
        return result;
    }
}
