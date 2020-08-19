package com.xiaowuzei.test.algr.leet;

public class N319_BulbSwitcher {
    public static void main(String[] args) {
        System.out.println(new N319_BulbSwitcher().bulbSwitch(3));
    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
