package com.xiaowuzei.test.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MonitorMemory {
    //VM Args: -Xms100m -Xmx100m -XX:+UseSerialGC
    private static class OOMObject {
        public byte[] placeHolder = new byte[64 * 1024];
    }

    private void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            TimeUnit.MILLISECONDS.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void test() throws InterruptedException {
        new MonitorMemory().fillHeap(1000);
    }
}
