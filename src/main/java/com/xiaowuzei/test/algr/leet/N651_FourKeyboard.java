package com.xiaowuzei.test.algr.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class N651_FourKeyboard {
    public static void main(String[] args) {
        System.out.println(new N651_FourKeyboard().maxA(0));
        System.out.println(new N651_FourKeyboard().maxA(1));
        System.out.println(new N651_FourKeyboard().maxA(2));
        System.out.println(new N651_FourKeyboard().maxA(3));
        System.out.println(new N651_FourKeyboard().maxA(4));
        System.out.println(new N651_FourKeyboard().maxA(5));
        System.out.println(new N651_FourKeyboard().maxA(6));
        System.out.println(new N651_FourKeyboard().maxA(7));
    }

    private static final class Key {
        int N, num, copy;

        public Key(int n, int num, int copy) {
            N = n;
            this.num = num;
            this.copy = copy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return N == key.N &&
                    num == key.num &&
                    copy == key.copy;
        }

        @Override
        public int hashCode() {
            return Objects.hash(N, num, copy);
        }
    }

    public int solve(int N) {
        return solve(N, 0, 0, new HashMap<>());
    }

    public int solve(int N, int num, int copy, Map<Key, Integer> map) {
        if (N <= 0) {
            return num;
        }
        Key key = new Key(N, num, copy);
        Integer value = map.get(key);
        if (value != null) {
            return value;
        }
        value = max(solve(N - 1, num + 1, copy, map),
                solve(N - 2, num, num, map),
                solve(N - 1, num + copy, copy, map));
        map.put(key, value);
        return value;
    }

    private int max(int a, int b, int c) {
        if (a < b) {
            a = b;
        }
        if (a < c) {
            a = c;
        }
        return a;
    }

    public int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }
}
