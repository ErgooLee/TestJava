package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;
import java.util.Stack;

public class N581_ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(new N581_ShortestUnsortedContinuousSubarray().findUnsortedSubarray(
                new int[]{2, 6, 4, 8, 10, 9, 15}));

    }

    public int findUnsortedSubarray2(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted[i]) {
                if (start > i) {
                    start = i;
                }
                if (end < i) {
                    end = i;
                }
            }
        }
        if (start == nums.length) {
            return 0;
        }
        return end - start + 1;
    }

    public int findUnsortedSubarray1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int min = nums[len - 1];
        int max = nums[0];
        int begin = 0, end = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) {      //从左到右维持最大值，寻找右边界end
                end = i;
            } else {
                max = nums[i];
            }

            if (nums[len - i - 1] > min) {    //从右到左维持最小值，寻找左边界begin
                begin = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }
        return end - begin + 1;
    }


}
