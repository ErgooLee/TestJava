package com.xiaowuzei.test.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
    static class GrandFather {
        void thinking() {
            System.out.println("I am grandfather");
        }
    }

    static class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println("I am father");
        }
    }

    static class Son extends Father {
        @Override
        void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle methodHandle = MethodHandles.lookup().findSpecial(GrandFather.class,
                        "thinking", mt, getClass());
                methodHandle.invoke(this);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void test() {
        new Son().thinking();
    }
}
