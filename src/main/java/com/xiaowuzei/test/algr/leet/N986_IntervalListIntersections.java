package com.xiaowuzei.test.algr.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N986_IntervalListIntersections {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new N986_IntervalListIntersections().intervalIntersection(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {5, 26}})));
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) {
            return new int[][]{};
        }
        int n1 = A.length;
        int n2 = B.length;
        int i = 0, j = 0;
        int a1, b1, a2, b2;
        int[] tmp1, tmp2;
        List<int[]> result = new ArrayList<>();
        while (i < n1 && j < n2) {
            tmp1 = A[i];
            a1 = tmp1[0];
            b1 = tmp1[1];
            tmp2 = B[j];
            a2 = tmp2[0];
            b2 = tmp2[1];
            if (b1 >= b2) {
                if (b2 >= a1) {
                    tmp2[0] = Math.max(a1, a2);
                    result.add(tmp2);
                }
                j++;
            } else {
                if (b1 >= a2) {
                    tmp1[0] = Math.max(a1, a2);
                    result.add(tmp1);
                }
                i++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
