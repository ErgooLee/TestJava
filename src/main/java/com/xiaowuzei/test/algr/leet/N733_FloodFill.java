package com.xiaowuzei.test.algr.leet;

import com.xiaowuzei.test.Utils;

import java.util.*;

public class N733_FloodFill {

    public static void main(String[] args) {
        System.out.println(Utils.toString(new N733_FloodFill().floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
        System.out.println(Utils.toString(new N733_FloodFill().floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 2)));
        System.out.println(Utils.toString(new N733_FloodFill().floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1)));
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        Queue<Node> queue = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        Node tmp = new Node(sr, sc);
        queue.add(tmp);
        visited[sr][sc] = true;
        int x, y;
        int oldColor = image[sr][sc];
        int[][] selections = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                x = tmp.x + selections[i][0];
                y = tmp.y + selections[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n && image[x][y] == oldColor && !visited[x][y]) {
                    queue.add(new Node(x, y));
                    visited[x][y] = true;
                }
            }
            image[tmp.x][tmp.y] = newColor;
        }
        return image;
    }
}
