package com.xiaowuzei.test.algr.leet;

import java.util.ArrayList;
import java.util.List;

public class N969_PancakeSorting {

    public static void main(String[] args) {
        System.out.println(new N969_PancakeSorting().pancakeSort(new int[]{4, 3, 2, 1, 7, 6, 5}));
        System.out.println(new N969_PancakeSorting().pancakeSort(new int[]{3, 2, 4, 1}));
        System.out.println(new N969_PancakeSorting().pancakeSort(new int[]{1, 2, 3}));
    }


    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int n = A.length;
        int index;
        int[] temp = new int[A.length];
        int[] tmp;
        while (n > 0) {
            index = 0;
            while (A[index] != n) {
                index++;
            }
            if (index != n - 1) {
                if (index != 0) {
                    result.add(index + 1);
                }
                result.add(n);
                for (int i = n - 1; i > index; i--) {
                    temp[n - i - 1] = A[i];
                }
                for (int i = n - index - 1; i < n - 1; i++) {
                    temp[i] = A[i + index + 1 - n];
                }
                tmp = temp;
                temp = A;
                A = tmp;
            }
            n--;
        }
        return result;
    }

}
