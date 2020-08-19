package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;
import java.util.Comparator;

public class N1340_JumpGameV {

    public static void main(String[] args) {
        System.out.println(new N1340_JumpGameV().maxJumps(new int[]{3, 3, 3, 3, 3}, 1));
        System.out.println(new N1340_JumpGameV().maxJumps(new int[]{7, 6, 5, 4, 3, 2, 1}, 1));
        System.out.println(new N1340_JumpGameV().maxJumps(new int[]{7, 1, 7, 1, 7, 1}, 2));
        System.out.println(new N1340_JumpGameV().maxJumps(new int[]{66}, 1));
        System.out.println(new N1340_JumpGameV().maxJumps(new int[]{59, 8, 74, 27, 92, 36, 95, 78, 73, 54, 75, 37, 42, 15, 59, 84, 66, 25, 35, 61, 97, 16, 6, 52, 49, 18, 22, 70, 5, 59, 92, 85}, 20));
    }
    public int maxJumps(int[] arr, int d) {
        int size = arr.length;
        Entry[] entries = new Entry[size];
        for (int i = 0; i < size; i++) {
            entries[i] = new Entry(arr[i], i);
        }
        Arrays.sort(entries, Comparator.comparingInt(o -> o.value));
        int value;
        int index;
        int maxJumps = 1;
        int[] dp = new int[size];
        int count;
        int i;
        for (Entry entry : entries) {
            index = entry.index;
            value = entry.value;
            dp[index] = 1;
            for (i = index + 1; i <= index + d; i++) {
                if (i < size && arr[i] < value) {
                    count = dp[i] + 1;
                    if (dp[index] < count) {
                        dp[index] = count;
                        if (maxJumps < count) {
                            maxJumps = count;
                        }
                    }
                } else {
                    break;
                }
            }
            for (i = index - 1; i >= index - d; i--) {
                if (i >= 0 && arr[i] < value) {
                    count = dp[i] + 1;
                    if (dp[index] < count) {
                        dp[index] = count;
                        if (maxJumps < count) {
                            maxJumps = count;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return maxJumps;
    }

    private static class Entry {
        int value;
        int index;

        public Entry(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

}
