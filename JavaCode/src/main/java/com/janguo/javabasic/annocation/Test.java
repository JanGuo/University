package com.janguo.javabasic.annocation;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        AnnoWithDefMethod annotation = AnnotatedClass.class.getAnnotation(AnnoWithDefMethod.class);
        System.out.println(annotation.value());
        System.out.println(Integer.toHexString(System.identityHashCode(annotation)));
        System.out.println(annotation.getClass());
        System.out.println(annotation.annotationType());
        System.out.println("---------");
        for (Method method : annotation.getClass().getDeclaredMethods()) {
            System.out.println(method.getName());
        }
    }
}
