package com.xiaowuzei.test.algr.sort;

import java.util.Arrays;

public class QuickSort {
    public static void test() {
//        int[] array = {1, 8, 5, 6, 9, 7, 4, 3, 2};
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};
//        int[] array = {4, 3, 2, 1, 5, 6, 7, 8, 10, 9};
//        int[] array = {1, 3, 2};
//        int[] array = {7, 6};
//        int[] array = {6, 6};
//        int[] array = {6};
//        int[] array = {1, 2, 3, 4, 5};
        int[] array = {3, 1, 3, 2, 2, 4, 5, 9, 5, 7, 6};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition2(array, start, end);
        sort(array, start, index - 1);
        sort(array, index + 1, end);
    }


    private static int partition(int[] array, int start, int end) {
        int left = start;
        int right = end;
        int first = array[left];
        while (left < right) {
            while (left <= right && first <= array[right--]) ;
            right++;
            array[left] = array[right];
            left++;
            while (left <= right && first >= array[left++]) ;
            left--;
            array[right] = array[left];
            right--;
        }
        array[left] = first;
        return left;
    }

    private static int partition2(int[] array, int start, int end) {
        int first = array[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left <= right && first <= array[right--]) ;
            right++;
            while (left <= right && first >= array[left++]) ;
            left--;
            swap(array, left, right);
        }
        swap(array, start, left);
        return left;
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
