package com.xiaowuzei.test.algr.leet;

import java.util.*;

public class N1345_JumpGameIV {
    public static void main(String[] args) {
//        System.out.println(new N1345_JumpGameIV().minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
//        System.out.println(new N1345_JumpGameIV().minJumps(new int[]{7}));
//        System.out.println(new N1345_JumpGameIV().minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
//        System.out.println(new N1345_JumpGameIV().minJumps(new int[]{6, 1, 9}));
//        System.out.println(new N1345_JumpGameIV().minJumps(new int[]{7, 7, 7, 7, 7, 11}));
//        System.out.println(new N1345_JumpGameIV().minJumps(new int[]{7, 7, 11}));
//        System.out.println(new N1345_JumpGameIV().minJumps(new int[]{7, 7, 7, 11}));
        System.out.println(new N1345_JumpGameIV().minJumps(new int[]{11, 7, 7, 7}));
    }

    public int minJumps(int[] arr) {
        int arraySize = arr.length;
        if (arraySize < 2) {
            return 0;
        }
        if (arraySize > 3) {
            arraySize = 3;
            for (int i = 3; i < arr.length; i++) {
                if (arr[arraySize - 1] != arr[i]) {
                    arr[arraySize++] = arr[i];
                }
            }
        }
        Map<Integer, List<Integer>> neighborMap = new HashMap<>();
        for (int i = 0; i < arraySize; i++) {
            neighborMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arraySize];
        queue.add(0);
        visited[0] = true;
        int jumps = 0;
        int levelSize = 1;
        int nextLevelSize;
        Integer index;
        int value;
        List<Integer> neighbors;
        while (!queue.isEmpty()) {
            nextLevelSize = 0;
            while (levelSize > 0) {
                index = queue.poll();
                value = arr[index];
                neighbors = neighborMap.get(value);
                neighbors.add(index + 1);
                neighbors.add(index - 1);
                for (Integer neighbor : neighbors) {
                    if (neighbor == arraySize - 1) {
                        return jumps + 1;
                    }
                    if (neighbor >= 0 && neighbor < arraySize && !visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                        nextLevelSize++;
                    }
                }
                levelSize--;
            }
            jumps++;
            levelSize = nextLevelSize;
        }
        return jumps;
    }
}
