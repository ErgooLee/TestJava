package com.xiaowuzei.test.algr.sort;

import java.util.Arrays;

public class CockTailSort {

    public static void test() {
//        int[] array = {1, 8, 5, 6, 9, 7, 4, 3, 2};
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};
//        int[] array = {4, 3, 2, 1, 5, 6, 7, 8, 10, 9};
//        int[] array = {7, 6};
        int[] array = {1, 2, 3, 4, 5, 7, 6, 8, 9, 10, 11};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        int tmp = 0;
        //记录右侧最后一次交换的位置
        int lastRightExchangeIndex = 0;
        //记录左侧最后一次交换的位置
        int lastLeftExchangeIndex = 0;

        //无序数列的右边界，每次比较只需要比到这里为止
        int rightSortBorder = array.length - 1;

        //无序数列的左边界，每次比较只需要比到这里为止
        int leftSortBorder = 0;

        while (leftSortBorder < rightSortBorder) {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for (int j = leftSortBorder; j < rightSortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    lastRightExchangeIndex = j;
                }
            }
            rightSortBorder = lastRightExchangeIndex;

            if (isSorted) {
                break;
            }
            //偶数轮之前，重新标记为true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int j = rightSortBorder; j > leftSortBorder; j--) {
                if (array[j] < array[j - 1]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    lastLeftExchangeIndex = j;
                }
            }
            leftSortBorder = lastLeftExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }
}
