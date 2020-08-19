package com.xiaowuzei.test.algr.leet;

public class N80_RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        System.out.println(new N80_RemoveDuplicatesFromSortedArrayII().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int leftIndex = 0;
        int left = nums[leftIndex];
        int item;
        for (int i = 1; i < nums.length; i++) {
            item = nums[i];
            if (left != item || leftIndex == 0 || nums[leftIndex - 1] != left){
                leftIndex++;
                left = item;
                nums[leftIndex] = left;
            }
        }
        return leftIndex + 1;
    }
}
