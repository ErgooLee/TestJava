package com.xiaowuzei.test.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("hello world");
        }
    }

    static class DynamicProxy implements InvocationHandler {
        Object origin;

        Object bind(Object origin) {
            this.origin = origin;
            return Proxy.newProxyInstance(origin.getClass().getClassLoader(), origin.getClass().getInterfaces(),
                    this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
            System.out.println("welcome dynamic proxy");
            return method.invoke(origin, args);
        }
    }

    public static void test() {
        Hello hello = new Hello();
        IHello iHello = (IHello) new DynamicProxy().bind(hello);
        iHello.sayHello();
    }

}
