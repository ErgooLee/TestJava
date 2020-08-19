package com.xiaowuzei.test.algr.leet;

public class N191_NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(new N191_NumberOf1Bits().hammingWeight(3));
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
