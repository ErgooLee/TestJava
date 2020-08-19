package com.xiaowuzei.test.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MethodAreaOOM {
    //VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
    static class OOMObject {

    }

    private void oom() {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(objects, objects);
                }
            });
            enhancer.create();
        }
    }

    public static void test() {
        new MethodAreaOOM().oom();
    }
}
