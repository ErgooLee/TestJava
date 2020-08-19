package com.xiaowuzei.test.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    // VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
    private void heapOOM() {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    static class OOMObject {

    }

    public static void test() {
        new HeapOOM().heapOOM();
    }
}
