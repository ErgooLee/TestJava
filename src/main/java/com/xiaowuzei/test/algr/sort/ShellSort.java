package com.xiaowuzei.test.algr.sort;

import java.util.Arrays;

public class ShellSort {

    public static void test() {
//        int[] array = {1, 8, 5, 6, 9, 7, 4, 3, 2};
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};
//        int[] array = {5, 8, 6, 3, 9, 2, 1, 7};
        int[] array = {4, 3, 2, 1, 5, 6, 7, 8, 10, 9};
//        int[] array = {7, 6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int gap = array.length / 2;
        int tmp;
        int i, j, k;
        while (gap > 0) {
            for (i = 0; i < gap; i++) {
                for (j = i + gap; j < array.length; j = j + gap) {
                    tmp = array[j];
                    for (k = j; k >= i + gap; k = k - gap) {
                        if (array[k - gap] > tmp) {
                            array[k] = array[k - gap];
                        } else {
                            break;
                        }
                    }
                    array[k] = tmp;
                }
            }
            gap = gap / 2;
        }
    }

}
