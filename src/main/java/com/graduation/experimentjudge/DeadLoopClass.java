package com.graduation.experimentjudge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeadLoopClass {
    interface IHello {
        void sayHello();
        int sayHi(String s);
    }

    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("hello world");
        }

        @Override
        public int sayHi(String s) {
            System.out.println(s);
            return 1;
        }
    }

    static class DynamicProxy implements InvocationHandler {
        Object originalObj;
        Object bind(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),
                    originalObj.getClass().getInterfaces(), this);
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            Object obj = method.invoke(originalObj, args);
            System.out.println("bye");
            return obj;
        }
    }

    public static void main(String[] args) {
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
        Integer tmp = hello.sayHi("你好");
        System.out.println(tmp);
    }
}
