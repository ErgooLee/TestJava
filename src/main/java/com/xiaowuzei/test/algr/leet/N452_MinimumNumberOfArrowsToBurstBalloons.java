package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;
import java.util.Comparator;

public class N452_MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        System.out.println(new N452_MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
