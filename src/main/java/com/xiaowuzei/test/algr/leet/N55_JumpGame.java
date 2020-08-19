package com.xiaowuzei.test.algr.leet;

import java.util.LinkedList;
import java.util.Queue;

public class N55_JumpGame {

    public static void main(String[] args) {
        System.out.println(new N55_JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new N55_JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new N55_JumpGame().canJump(new int[]{0}));
        System.out.println(new N55_JumpGame().canJump(new int[]{0, 1}));
        System.out.println(new N55_JumpGame().canJump(new int[]{8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5}));
    }

    public boolean canJump2(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        boolean[] record = new boolean[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        record[0] = true;
        queue.add(0);
        int index;
        int newIndex;
        int i;
        int end = nums.length - 1;
        while (!queue.isEmpty()) {
            index = queue.poll();
            for (i = nums[index]; i >= 1; i--) {
                newIndex = index + i;
                if (newIndex >= end) {
                    return true;
                } else if (!record[newIndex]) {
                    queue.add(newIndex);
                    record[newIndex] = true;
                }
            }
        }
        return false;
    }

    public boolean canJump1(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        int lastIndex = nums.length - 1;
        canReach[0] = true;
        int length;
        for (int i = 0; i <= lastIndex; i++) {
            length = nums[i];
            if (canReach[i]) {
                if (i + length >= lastIndex) {
                    return true;
                }
                for (int j = i + length; j > i; j--) {
                    canReach[j] = true;
                }
            }
        }
        return canReach[nums.length - 1];
    }

    public boolean canJump0(int[] nums) {
        int lastIndex = nums.length - 1;
        int farthest = 0;
        for (int i = 0; i < lastIndex; i++) {
            if (farthest < nums[i] + i) {
                farthest = nums[i] + i;
            }
            if (farthest >= lastIndex) {
                return true;
            }
            if (farthest <= i) {
                return false;
            }
        }
        return true;
    }

    public boolean canJump(int[] nums) {
        int i = 0, max = 0, lastIndex = nums.length - 1;
        for (; i <= max; i++) {
            if (max < nums[i] + i) {
                max = nums[i] + i;
            }
            if (max >= lastIndex) {
                return true;
            }
        }
        return false;
    }

}
