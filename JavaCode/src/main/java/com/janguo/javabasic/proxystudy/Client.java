package com.janguo.javabasic.proxystudy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        RealSubject realSubject = new RealSubject();
        DynamicSubject dynamicSubject = new DynamicSubject(realSubject);

        Class<? extends RealSubject> aClass = realSubject.getClass();

        Subject subject = (Subject) Proxy.
                newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), dynamicSubject);
        subject.request();
        subject.toString();
        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}
