package com.xiaowuzei.test.algr.leet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N239_SlidingWindowMaximum {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new N239_SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(new N239_SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ret = new int[n - k + 1];
        MQueue queue = new MQueue();
        for (int i = 0; i < k - 1; i++) {
            queue.push(nums[i]);
        }
        for (int i = 0; i < n - k + 1; i++) {
            queue.push(nums[i + k - 1]);
            ret[i] = queue.max();
            queue.pop(nums[i]);
        }
        return ret;
    }

    public static class MQueue {
        LinkedList<Integer> queue = new LinkedList<>();

        public void push(int n) {
            while (!queue.isEmpty() && queue.peekLast() < n) {
                queue.pollLast();
            }
            queue.offer(n);
        }

        public void pop(int n) {
            if (!queue.isEmpty() && queue.peek() == n) {
                queue.poll();
            }
        }

        public Integer max() {
            return queue.peek();
        }
    }
}
