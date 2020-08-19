package com.xiaowuzei.test.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonitorThread {
    private void busyThread() {
        new Thread(() -> {
            while (true) ;
        }, "testBusyThread").start();
    }

    private void lockThread(final Object lock) {
        new Thread(()->{
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "testLockThread").start();
    }

    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        MonitorThread monitorThread = new MonitorThread();
        monitorThread.busyThread();
        br.readLine();
        monitorThread.lockThread(new Object());

    }
}
