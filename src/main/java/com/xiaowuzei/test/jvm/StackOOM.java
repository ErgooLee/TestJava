package com.xiaowuzei.test.jvm;

public class StackOOM {
    //VM Args: -Xss2M
    private void alwaysRunning() {
        while (true) {

        }
    }

    private void stackOOMByThread() {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    alwaysRunning();
                }
            }).start();
        }
    }

    public static void test() {
        StackOOM stackOOM = new StackOOM();
        stackOOM.stackOOMByThread();
    }
}
