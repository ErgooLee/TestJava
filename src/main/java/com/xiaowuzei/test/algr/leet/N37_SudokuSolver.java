package com.xiaowuzei.test.algr.leet;

import com.xiaowuzei.test.Utils;

public class N37_SudokuSolver {
    public static void main(String[] args) {
        new N37_SudokuSolver().solveSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
    }

    boolean[][] h = new boolean[9][9];
    boolean[][] v = new boolean[9][9];
    boolean[][] b = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        int tmp;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    tmp = board[i][j] - '1';
                    h[i][tmp] = true;
                    v[j][tmp] = true;
                    b[(i / 3) * 3 + j / 3][tmp] = true;
                }
            }
        }
        solveSudoku(board, 0);
        System.out.println(Utils.toString(board));
    }

    boolean solved = false;

    public void solveSudoku(char[][] board, int num) {
        if (num == 81) {
            solved = true;
            return;
        }
        int i = num / 9;
        int j = num % 9;
        if (board[i][j] != '.') {
            solveSudoku(board, num + 1);
        } else {
            for (char z = '1'; z <= '9' && !solved; z++) {
                if (valid(z, i, j)) {
                    board[i][j] = z;
                    record(z, i, j);
                    solveSudoku(board, num + 1);
                    if (!solved) {
                        clear(z, i, j);
                        board[i][j] = '.';
                    }
                }
            }
        }
    }

    boolean valid(char z, int i, int j) {
        int num = z - '1';
        return !h[i][num] && !v[j][num] && !b[(i / 3) * 3 + j / 3][num];
    }

    void record(char z, int i, int j) {
        int num = z - '1';
        h[i][num] = true;
        v[j][num] = true;
        b[(i / 3) * 3 + j / 3][num] = true;
    }


    void clear(char z, int i, int j) {
        int num = z - '1';
        h[i][num] = false;
        v[j][num] = false;
        b[(i / 3) * 3 + j / 3][num] = false;
    }

}
