package com.xiaowuzei.test.jvm;

public class StackOverflow {
    //VM Args: -Xss144k
    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void test() {
        StackOverflow stackOverflow = new StackOverflow();
        try {
            stackOverflow.stackLeak();
        } catch (Throwable throwable) {
            System.out.println("stack length:" + stackOverflow.stackLength);
            throw throwable;
        }
    }
}
