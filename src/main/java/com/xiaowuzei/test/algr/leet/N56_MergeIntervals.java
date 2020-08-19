package com.xiaowuzei.test.algr.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class N56_MergeIntervals {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new N56_MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(new N56_MergeIntervals().merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(new N56_MergeIntervals().merge(new int[][]{{1, 4}})));
        System.out.println(Arrays.deepToString(new N56_MergeIntervals().merge(new int[][]{{1, 4}, {0, 4}})));
        System.out.println(Arrays.deepToString(new N56_MergeIntervals().merge(new int[][]{{1, 4}, {2, 3}})));
        System.out.println(Arrays.deepToString(new N56_MergeIntervals().merge(new int[][]{{1, 4}, {2, 3}})));
        System.out.println(Arrays.deepToString(new N56_MergeIntervals().merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}})));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        int index = 0;
        int[] tmp;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                tmp = intervals[index++];
                tmp[0] = start;
                tmp[1] = end;
                result.add(tmp);
                start = intervals[i][0];
                end = intervals[i][1];
            } else if (intervals[i][1] > end) {
                end = intervals[i][1];
            }
        }
        tmp = intervals[index];
        tmp[0] = start;
        tmp[1] = end;
        result.add(tmp);
        return result.toArray(new int[result.size()][2]);
    }
}
