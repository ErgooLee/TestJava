package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;

public class N283_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new N283_MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0, 0, 0, 0, 0};
        new N283_MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 2, 3, 4, 5};
        new N283_MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int zeroAreaStart = -1;
        int item;
        for (int i = 0; i < length; i++) {
            item = nums[i];
            if (item == 0 && zeroAreaStart == -1) {
                zeroAreaStart = i;
            } else if (item != 0 && zeroAreaStart != -1) {
                nums[zeroAreaStart++] = item;
                nums[i] = 0;
            }
        }
    }
}
