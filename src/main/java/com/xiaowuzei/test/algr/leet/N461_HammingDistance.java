package com.xiaowuzei.test.algr.leet;

public class N461_HammingDistance {
    public static void main(String[] args) {
        System.out.println(new N461_HammingDistance().hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        return Integer.bitCount(n);
    }
}
