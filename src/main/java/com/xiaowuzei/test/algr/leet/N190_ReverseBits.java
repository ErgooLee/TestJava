package com.xiaowuzei.test.algr.leet;

public class N190_ReverseBits {
    public static void main(String[] args) {
        System.out.println(new N190_ReverseBits().reverseBits(43261596));
    }

    public int reverseBits(int n) {
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            bits[i] = (n >> i) & 1;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += bits[i];
            if (i != 31) {
                result <<= 1;
            }
        }
        return result;
    }
}
