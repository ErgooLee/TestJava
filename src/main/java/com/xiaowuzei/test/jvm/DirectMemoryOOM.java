package com.xiaowuzei.test.jvm;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectMemoryOOM {
    //VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
    private static final int _1MB = 1024 * 1024;

    private void oom() {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        try {
            Unsafe unsafe = (Unsafe) unsafeField.get(null);
            while (true) {
                unsafe.allocateMemory(_1MB);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        new DirectMemoryOOM().oom();

    }

}
