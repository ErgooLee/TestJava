package com.xiaowuzei.test.algr.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Util.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            System.out.println(Arrays.toString(arr1));
            HeapSort.sort(arr1);
            Arrays.sort(arr2);
            if (!Arrays.equals(arr1, arr2)) {
                succeed = false;
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
