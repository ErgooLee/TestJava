package com.xiaowuzei.test.algr.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

//        int[] array = {1, 8, 5, 6, 9, 7, 4, 3, 2};
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};
//        int[] array = {4, 3, 2, 1, 5, 6, 7, 8, 10, 9};
//        int[] array = {3, 8, 7, 1, 9, 5, 0, 2, 4, 12};
        int[] array = {7, 6};
//        int[] array = {2, 3, 1};
//        int[] array = {1, 2, 3, 4, 5, 7, 6, 8, 9, 10, 11};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        buildHeap(arr);
        int tmp;
        for (int i = arr.length - 1; i >= 0; i--) {
            tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            maxHeapify(arr, 0, i);
        }
    }

    public static void buildHeap(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            maxHeapify(array, i, array.length);
        }
    }


    public static void maxHeapify(int[] array, int start, int end) {
        int tmp, leftChi, rightChi, max, index;
        tmp = array[start];
        index = start;
        while (2 * index + 1 < end) {
            leftChi = 2 * index + 1;
            rightChi = 2 * index + 2;
            if (rightChi < end && array[leftChi] < array[rightChi]) {
                max = rightChi;
            } else {
                max = leftChi;
            }
            if (tmp < array[max]) {
                array[index] = array[max];
            } else {
                break;
            }
            index = max;
        }
        array[index] = tmp;
    }
}
