package com.xiaowuzei.test.algr;

import java.util.Arrays;

public class Prime {

    public static void main(String[] args) {
        System.out.println(new Prime().countPrimes(2));
        System.out.println(new Prime().countPrimes(3));
        System.out.println(new Prime().countPrimes(4));
        System.out.println(new Prime().countPrimes(5));
        System.out.println(new Prime().countPrimes(6));
        System.out.println(new Prime().countPrimes(7));
        System.out.println(new Prime().countPrimes(8));
    }

    int countPrimes(int n) {
        boolean[] isPrim = new boolean[n + 1];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i <= n; i++)
            if (isPrim[i])
                for (int j = i * i; j <= n; j += i)
                    isPrim[j] = false;
        int count = 0;
        for (int i = 2; i <= n; i++)
            if (isPrim[i]) count++;
        return count;
    }
}
