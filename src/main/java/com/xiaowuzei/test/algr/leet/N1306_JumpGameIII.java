package com.xiaowuzei.test.algr.leet;

import java.util.LinkedList;
import java.util.Queue;

public class N1306_JumpGameIII {

    public static void main(String[] args) {
        System.out.println(new N1306_JumpGameIII().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println(new N1306_JumpGameIII().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
        System.out.println(new N1306_JumpGameIII().canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }

    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        int length = arr.length;
        boolean[] visited = new boolean[length];
        int[] selections = new int[]{1, -1};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int index;
        int nextIndex;
        int jumpLength;
        while (!queue.isEmpty()) {
            index = queue.poll();
            jumpLength = arr[index];
            if (jumpLength == 0) {
                return true;
            }
            for (int selection : selections) {
                nextIndex = index + jumpLength * selection;
                if (nextIndex >= 0 && nextIndex < length && !visited[nextIndex]) {
                    queue.add(nextIndex);
                    visited[nextIndex] = true;
                }
            }
        }
        return false;
    }
}
