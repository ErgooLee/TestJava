package com.xiaowuzei.test.algr.sort;

import java.util.Arrays;

public class InsertSort {

    public static void test() {
//        int[] array = {1, 8, 5, 6, 9, 7, 4, 3, 2};
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};
//        int[] array = {4, 3, 2, 1, 5, 6, 7, 8, 10, 9};
//        int[] array = {7, 6};
        int[] array = {6, 6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int tmp;
        int j;
        for (int i = 1; i < array.length; i++) {
            j = i;
            tmp = array[j];
            for (; j > 0; j--) {
                if (tmp < array[j - 1]) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = tmp;
        }

    }
}
