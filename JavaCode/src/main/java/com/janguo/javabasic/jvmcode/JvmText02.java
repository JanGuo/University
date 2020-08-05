package com.janguo.javabasic.jvmcode;

public class JvmText02 {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("java.lang.Class");
        System.out.println(clazz.getClassLoader());
    }
}
