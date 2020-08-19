package com.xiaowuzei.test.algr.leet;

import com.xiaowuzei.test.Utils;

public class N885_SpiralMatrixIII {

    public static void main(String[] args) {
        System.out.println(Utils.toString(new N885_SpiralMatrixIII().spiralMatrixIII(5, 6, 1, 4)));
        System.out.println(Utils.toString(new N885_SpiralMatrixIII().spiralMatrixIII(1, 1, 0, 0)));
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int count = 0;
        int MAX = R * C;
        int round = 1;
        int roundCount;
        int length;
        int direction;
        int[][] result = new int[MAX][2];
        result[count][0] = r0;
        result[count][1] = c0;
        count++;
        int[][] selection = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int i = r0, j = c0;
        while (count < MAX) {
            roundCount = 0;
            length = (round + 1) / 2;
            direction = round % 4;
            while (roundCount < length) {
                i = i + selection[direction][0];
                j = j + selection[direction][1];
                if (i >= 0 && i < R && j >= 0 && j < C) {
                    result[count][0] = i;
                    result[count][1] = j;
                    count++;
                }
                roundCount++;
            }
            round++;
        }
        return result;
    }


}
