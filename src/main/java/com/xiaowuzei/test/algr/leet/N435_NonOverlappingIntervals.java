package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;
import java.util.Comparator;

public class N435_NonOverlappingIntervals {
    public static void main(String[] args) {
        System.out.println(new N435_NonOverlappingIntervals()
                .eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(new N435_NonOverlappingIntervals()
                .eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(new N435_NonOverlappingIntervals()
                .eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
        System.out.println(new N435_NonOverlappingIntervals()
                .eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
