package com.xiaowuzei.test.algr.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void test() {
        //选择排序
        //相比较冒泡排序 交换更少但是不稳定。
        int[] array = {1, 8, 5, 6, 9, 7, 4, 3, 2};
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};
//        int[] array = {4, 3, 2, 1, 5, 6, 7, 8, 10, 9};
//        int[] array = {7, 6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int minIndex;
        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                tmp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = tmp;
            }
        }

    }
}
