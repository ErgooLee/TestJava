package com.xiaowuzei.test.algr.leet;

import com.xiaowuzei.test.Utils;

import java.util.*;

public class N130_SurroundedRegions {
    public static void main(String[] args) {
        char[][] data = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        new N130_SurroundedRegions().solve(data);
        System.out.println(Utils.toString(data));

        data = new char[][]{
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
                {'O', 'X', 'O'}
        };
        new N130_SurroundedRegions().solve(data);
        System.out.println(Utils.toString(data));

        data = new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}};
        new N130_SurroundedRegions().solve(data);
        System.out.println(Utils.toString(data));

        data = new char[][]{
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}
        };
        new N130_SurroundedRegions().solve(data);
        System.out.println(Utils.toString(data));
    }


    public void solve2(char[][] board) {
        if (board.length < 1) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Set<Node> in = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        int[][] selections = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(0, 0);
        Node top;
        int tmpX, tmpY;
        boolean isBoard;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                node.x = i;
                node.y = j;
                isBoard = false;
                if (board[i][j] == 'O' && !visited.contains(node)) {
                    queue.add(new Node(i, j));
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        isBoard = true;
                    }
                    while (!queue.isEmpty()) {
                        top = queue.poll();
                        in.add(top);
                        visited.add(top);
                        for (int k = 0; k < 4; k++) {
                            tmpX = top.x + selections[k][0];
                            tmpY = top.y + selections[k][1];
                            node.x = tmpX;
                            node.y = tmpY;
                            if (tmpX >= 0 &&
                                    tmpX < m &&
                                    tmpY >= 0 &&
                                    tmpY < n &&
                                    board[tmpX][tmpY] == 'O' &&
                                    !visited.contains(node)) {
                                if (tmpX == 0 || tmpY == 0 || tmpX == m - 1 || tmpY == n - 1) {
                                    isBoard = true;
                                }
                                Node e = new Node(tmpX, tmpY);
                                queue.add(e);
                                visited.add(e);
                            }
                        }
                    }
                }
                if (!isBoard) {
                    for (Node node1 : in) {
                        board[node1.x][node1.y] = 'X';
                    }
                }
                in.clear();
            }
        }
    }

    static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public void solve1(char[][] board) {
        if (board.length < 1) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] selections = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        int[] top;
        int tmpX, tmpY;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    board[i][j] = '#';
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        top = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            tmpX = top[0] + selections[k][0];
                            tmpY = top[1] + selections[k][1];
                            if (tmpX >= 0 &&
                                    tmpX < m &&
                                    tmpY >= 0 &&
                                    tmpY < n &&
                                    board[tmpX][tmpY] == 'O') {
                                board[tmpX][tmpY] = '#';
                                queue.add(new int[]{tmpX, tmpY});
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j); // 上
        dfs(board, i + 1, j); // 下
        dfs(board, i, j - 1); // 左
        dfs(board, i, j + 1); // 右
    }
}
