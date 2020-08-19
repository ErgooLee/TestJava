package com.xiaowuzei.test.algr.leet;

import java.util.ArrayList;
import java.util.List;

public class N448_FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        System.out.println(new N448_FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        int item;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            item = nums[i];
            if (item < 0) {
                item *= -1;
            }
            if (nums[item - 1] > 0) {
                nums[item - 1] *= -1;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
