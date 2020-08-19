package com.xiaowuzei.test.algr.backtrack;

import java.util.Arrays;

public class NQueen {
    private static int total = 0;

    public static void main(String[] args) {
        new NQueen().solve(8);
        System.out.println(total);
    }


    public void solve(int n) {
        int[] checkerBoard = new int[n];
        boolean[] visited = new boolean[n];
        findK(checkerBoard, visited, 0);

    }

    public void findK(int[] checkerBoard, boolean[] visited, int k) {
        if (k == checkerBoard.length) {
            total++;
            System.out.println(Arrays.toString(checkerBoard));
        }
        for (int i = 0; i < checkerBoard.length; i++) {
            if (!visited[i] && check(checkerBoard, k, i)) {
                visited[i] = true;
                checkerBoard[k] = i;
                findK(checkerBoard, visited, k + 1);
                visited[i] = false;
            }
        }
    }

    public boolean check(int[] checkerBoard, int i, int j) {
        for (int z = 0; z < i; z++) {
            if (checkerBoard[z] + z == i + j || (j - i == checkerBoard[z] - z)) {
                return false;
            }
        }
        return true;
    }
}
