package com.xiaowuzei.test.jvm;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {
    //VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
    //永久代（方法区）-> 元数据区（方法区）
    //java 1.8 Vm Args:-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
    //intern字符串只存在于堆中，字符串常量池只引用，所以既要限制方法区大小，又要限制堆大小，结果是堆溢出。无法在1.8之后复现
    private void oom() {
        List<String> list = new ArrayList<>();
        long i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    public static void test() {
        new RuntimeConstantPoolOOM().oom();
    }
}
