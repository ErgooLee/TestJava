package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;

public class N645_SetMismatch {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N645_SetMismatch().findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(new N645_SetMismatch().findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(new N645_SetMismatch().findErrorNums(new int[]{2, 2})));
        System.out.println(Arrays.toString(new N645_SetMismatch().findErrorNums(new int[]{3, 2, 2})));
    }

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int item;
        int index;
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            item = nums[i];
            item = item > 0 ? item : -item;
            index = nums[item - 1];
            if (index < 0) {
                result[0] = item;
            } else {
                nums[item - 1] = -index;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1;
                break;
            }
        }
        return result;
    }
}
