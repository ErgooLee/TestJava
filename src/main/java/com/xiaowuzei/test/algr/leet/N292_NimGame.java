package com.xiaowuzei.test.algr.leet;

public class N292_NimGame {

    public static void main(String[] args) {
        N292_NimGame game = new N292_NimGame();
        System.out.println(game.canWinNim(4));
        System.out.println(game.canWinNim(1));
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
