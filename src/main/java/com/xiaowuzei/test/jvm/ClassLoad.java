package com.xiaowuzei.test.jvm;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoad {
    //VM Args:-XX:+TraceClassLoading
    //-Xlog:class+load=info
    public static void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println(SubClass.value);
        SubClass[] cta = new SubClass[10];
        new ClassLoad().classLoader();
    }

    private void classLoader() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf('.') + 1) + ".class";
                    InputStream is = ClassLoad.this.getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        Object object = myLoader.loadClass("com.xiaowuzei.test.jvm.ClassLoad").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof ClassLoad);

    }
}

class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}


