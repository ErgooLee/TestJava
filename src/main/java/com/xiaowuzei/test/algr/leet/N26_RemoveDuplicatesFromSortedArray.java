package com.xiaowuzei.test.algr.leet;

public class N26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
//        System.out.println(new N26_RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(new N26_RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int leftIndex = 0;
        int leftNum = nums[0];
        int item;
        for (int i = 1; i < nums.length; i++) {
            item = nums[i];
            if (item != leftNum) {
                leftNum = item;
                leftIndex++;
                nums[leftIndex] = leftNum;
            }
        }
        return leftIndex + 1;
    }

}
