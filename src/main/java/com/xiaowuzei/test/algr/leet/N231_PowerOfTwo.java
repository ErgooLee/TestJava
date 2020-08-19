package com.xiaowuzei.test.algr.leet;

public class N231_PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new N231_PowerOfTwo().isPowerOfTwo(3));
        System.out.println(new N231_PowerOfTwo().isPowerOfTwo(1));
        System.out.println(new N231_PowerOfTwo().isPowerOfTwo(0));
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
