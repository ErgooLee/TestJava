package com.xiaowuzei.test.algr.sort;

import java.util.Arrays;

public class BubbleSort {
    //交换排序
    //比较 + 交换
    //稳定 适合较为有序的情形 ,缺点 交换次数过多
    public static void test() {
//        int[] array = {1, 8, 5, 6, 9, 7, 4, 3, 2};
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};
//        int[] array = {4, 3, 2, 1, 5, 6, 7, 8, 10, 9};
        int[] array = {7, 6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        boolean sorted = true;
        int sortedBorder = array.length - 1;
        int tmp;
        int lastChangeIndex = sortedBorder;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < sortedBorder; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    sorted = false;
                    //最后一次发生交换的位置是有序区
                    lastChangeIndex = j;
                }
            }
            sortedBorder = lastChangeIndex;
            if (sorted) {
                //若一趟下来没有发生交换，说明已经有序。
                break;
            }
        }
    }
}
