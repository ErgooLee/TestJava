package com.xiaowuzei.test.algr.leet;

public class N70_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new N70_ClimbingStairs().climbStairs(1));
        System.out.println(new N70_ClimbingStairs().climbStairs(2));
        System.out.println(new N70_ClimbingStairs().climbStairs(3));
        System.out.println(new N70_ClimbingStairs().climbStairs(4));
    }

    public int climbStairs(int n) {
        int a = 1;
        int b = 0;
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = a + b;
            b = a;
            a = tmp;
        }
        return a;
    }
}
