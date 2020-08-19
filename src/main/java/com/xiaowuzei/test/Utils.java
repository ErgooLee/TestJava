package com.xiaowuzei.test;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static String toString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] array : matrix) {
            sb.append(Arrays.toString(array));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static String toString(char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (char[] array : matrix) {
            sb.append(Arrays.toString(array));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static String toString(List<List<Integer>> matrix) {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> array : matrix) {
            sb.append(Arrays.toString(array.toArray()));
            sb.append('\n');
        }
        return sb.toString();
    }
}
