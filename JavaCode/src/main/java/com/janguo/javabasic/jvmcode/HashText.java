package com.janguo.javabasic.jvmcode;

public class HashText {
    public static void main(String[] args) {
        String key = "帅丙";
        String key1 = "帅丙";
        Object o1 = new Object();
        Object o2 = new Object();
        Integer code = key.hashCode();
        int code1 = key1.hashCode();
        System.out.println(o1 == o2);
        System.out.println(o1.equals(o2));
        System.out.println(code);
        byte codeb = code.byteValue();
        System.out.println(codeb);
        int index = ((1<<4) - 1)&code;
        System.out.println(index);
    }
}
