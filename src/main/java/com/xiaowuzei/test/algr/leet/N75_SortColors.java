package com.xiaowuzei.test.algr.leet;


import java.util.Arrays;

public class N75_SortColors {

    public static void test() {
//        int[] array = {2, 0, 2, 1, 1, 0};
//        int[] array = {1, 0, 2, 0, 0, 1, 2, 0, 0, 2, 1, 0, 1};
//        int[] array = {0, 2, 0};
//        int[] array = {0, 0, 0, 1, 1, 2, 2};
//        int[] array = {2, 2, 1, 1, 0, 0};
//        int[] array = {1, 0, 2, 0, 0};
//        int[] array = {1, 0, 0};
        int[] array = {1, 2, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    //思想主移p0 逻辑复杂 无无用交换 效率更高
    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int p0 = 0;
        int p1 = nums.length - 1;
        int p2 = nums.length - 1;
        int tmp = 0;
        while (p0 <= p1 && p0 <= p2) {
            while (nums[p0++] == 0) {
                if (p0 > p1) {
                    return;
                }
            }
            p0--;
            while (p0 <= p1 && nums[p1] != 0) {
                if (nums[p1] == 2) {
                    tmp = nums[p2];
                    nums[p2] = nums[p1];
                    nums[p1] = tmp;
                    p2--;
                }
                p1--;
            }
            if (p0 <= p1) {
                if (nums[p0] == 1) {
                    nums[p1] = 1;
                    nums[p0] = 0;
                } else {
                    nums[p2] = 2;
                    if (p1 != p2) {
                        nums[p1] = 1;
                    }
                    nums[p0] = 0;
                    p2--;
                }
                p0++;
                p1--;
            }
        }
    }

    //思想主移动p1,逻辑简单 交换次数过多
    public static void sort2(int[] nums) {
        int p0 = 0, p1 = 0;
        int p2 = nums.length - 1;
        int tmp;
        while (p1 <= p2) {
            if (nums[p1] == 0) {
                tmp = nums[p0];
                nums[p0++] = nums[p1];
                nums[p1++] = tmp;
            } else if (nums[p1] == 2) {
                tmp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2--] = tmp;
            } else {
                p1++;
            }
        }
    }
}
