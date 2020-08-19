package com.xiaowuzei.test.algr.leet;

import java.util.Map;
import java.util.Objects;

public class N887_SuperEggDrop {

    public static void main(String[] args) {
//        int K = 20;
//        int N = 50;
        N887_SuperEggDrop t = new N887_SuperEggDrop();
//        int[][] ret = new int[K + 1][N + 1];
//        for (int k = 1; k <= K; k++) {
//            for (int n = 1; n <= N; n++) {
//                ret[k][n] = t.superEggDrop(k, n);
//            }
//        }
//        System.out.println();

        System.out.println(t.superEggDrop(10, 10000));
        System.out.println(t.superEggDrop0(10, 10000));


    }


    public int superEggDrop(int K, int N) {
        int[] dp = new int[N + 1];
        int[] dpTmp = new int[N + 1];
        int i, j, z, min, tmp1;
        int[] tmp;
        for (i = 1; i <= N; i++) {
            dp[i] = i;
        }
        for (i = 2; i <= K; i++) {
            for (j = 1; j <= N; j++) {
                if (j <= i) {
                    dpTmp[j] = dp[j];
                } else {
                    min = Integer.MAX_VALUE;
                    for (z = 1; z <= j; z++) {
                        tmp1 = Math.max(dp[z - 1], dpTmp[j - z]) + 1;
                        if (tmp1 < min) {
                            min = tmp1;
                        }
                    }
                    dpTmp[j] = min;
                }
            }
            tmp = dp;
            dp = dpTmp;
            dpTmp = tmp;
        }
        return dp[N];
    }

    public int superEggDrop0(int K, int N) {
        int[] dp = new int[N + 1];
        int[] dpTmp = new int[N + 1];
        int i, j, broken, notBroken, dropFloor = 1, left, right;
        int[] tmp;
        for (i = 1; i <= N; i++) {
            dp[i] = i;
        }
        for (i = 2; i <= K; i++) {
            for (j = 1; j <= N; j++) {
                if (j <= i) {
                    dpTmp[j] = dp[j];
                } else {
                    left = 1;
                    right = j;
                    while (left <= right) {
                        dropFloor = left + (right - left) / 2;
                        broken = dp[dropFloor - 1];
                        notBroken = dpTmp[j - dropFloor];
                        if (broken == notBroken) {
                            break;
                        } else if (broken > notBroken) {
                            right = dropFloor - 1;
                        } else {
                            left = dropFloor + 1;
                        }
                    }
                    dpTmp[j] = Math.max(dp[dropFloor - 1], dpTmp[j - dropFloor]) + 1;
                }
            }
            tmp = dp;
            dp = dpTmp;
            dpTmp = tmp;
        }
        return dp[N];
    }

    private static class Pair {
        int K;
        int N;

        public Pair(int k, int n) {
            K = k;
            N = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return K == pair.K &&
                    N == pair.N;
        }

        @Override
        public int hashCode() {
            return Objects.hash(K, N);
        }
    }

    public int superEggDrop1(int K, int N, Map<Pair, Integer> map) {
        if (N == 0) {
            return 0;
        }
        if (K == 1) {
            return N;
        }
        Pair key = new Pair(K, N);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            min = Math.min(min, Math.max(superEggDrop1(K - 1, i - 1, map), superEggDrop1(K, N - i, map)) + 1);
        }
        map.put(key, min);
        return min;
    }

    public int superEggDrop2(int K, int N, Map<Pair, Integer> map) {
        if (N == 0) {
            return 0;
        }
        if (K == 1) {
            return N;
        }
        Pair key = new Pair(K, N);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int min = Integer.MAX_VALUE, left = 1, right = N, mid, broken, notBroken;
        while (left <= right) {
            mid = left + (right - left) / 2;
            broken = superEggDrop2(K - 1, mid - 1, map);
            notBroken = superEggDrop2(K, N - mid, map);
            if (broken > notBroken) {
                right = mid - 1;
                min = Math.min(min, broken + 1);
            } else {
                left = mid + 1;
                min = Math.min(min, notBroken + 1);
            }
        }
        map.put(key, min);
        return min;
    }


}
