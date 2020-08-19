package com.xiaowuzei.test.algr.leet;

import com.xiaowuzei.test.Utils;

import java.util.*;

public class N77_Combinations {

    public static void main(String[] args) {
        System.out.println(Utils.toString(new N77_Combinations().combine(4, 2)));
    }

    int n;
    int k;
    int[] array;
    List<List<Integer>> all;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        all = new ArrayList<>();
        array = new int[k];
        backTrack(0, 1);
        return all;
    }

    public void backTrack(int index, int start) {
        if (index == k) {
            List<Integer> list = new ArrayList<>();
            for (int num : array) {
                list.add(num);
            }
            all.add(list);
            return;
        }
        int end = n - k + index + 1;
        for (int i = start; i <= end; i++) {
            array[index] = i;
            backTrack(index + 1, i + 1);
        }
    }
}
