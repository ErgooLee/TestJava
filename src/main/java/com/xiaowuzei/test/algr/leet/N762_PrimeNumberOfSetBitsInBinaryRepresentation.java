package com.xiaowuzei.test.algr.leet;

public class N762_PrimeNumberOfSetBitsInBinaryRepresentation {
    public static void main(String[] args) {
        System.out.println(new N762_PrimeNumberOfSetBitsInBinaryRepresentation().countPrimeSetBits(6, 10));
        System.out.println(new N762_PrimeNumberOfSetBitsInBinaryRepresentation().countPrimeSetBits(10, 15));
    }

    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        boolean[] primes = new boolean[]{
                false, false, true, true, false, true, false, true,
                false, false, false, true, false, true, false, false,
                false, true, false, true, false, false, false, true,
                false, false, false, false, false, true, false, true
        };
        for (int i = L; i <= R; i++) {
            if (primes[Integer.bitCount(i)]) {
                count++;
            }
        }
        return count;
    }
}
