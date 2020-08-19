package com.xiaowuzei.test.algr.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

//        int[] array = {1, 8, 5, 6, 9, 7, 4, 3, 2};
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};
        int[] array = {4, 3, 2, 1, 5, 6, 7, 8, 10, 9};
//        int[] array = {7, 6};
//        int[] array = {1, 2, 3, 4, 5, 7, 6, 8, 9, 10, 11};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        int[] leftPart = Arrays.copyOfRange(arr, start, mid + 1);
        int[] rightPart = Arrays.copyOfRange(arr, mid + 1, end + 1);
        int pl = 0, pr = 0, index = start, size = end - start + 1;
        while (index - start < size) {
            if (pr >= rightPart.length || (pl < leftPart.length && leftPart[pl] < rightPart[pr])) {
                arr[index++] = leftPart[pl++];
            } else {
                arr[index++] = rightPart[pr++];
            }
        }
    }
}
