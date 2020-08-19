package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;

public class N167_TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N167_TwoSumIIInputArrayIsSorted().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new N167_TwoSumIIInputArrayIsSorted().twoSum(new int[]{2, 2}, 4)));
        System.out.println(Arrays.toString(new N167_TwoSumIIInputArrayIsSorted().twoSum(new int[]{2, 3}, 5)));

    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1, tmp;
        while (left < right) {
            tmp = numbers[left] + numbers[right];
            if (tmp == target) {
                return new int[]{left + 1, right + 1};
            } else if (tmp < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

}
