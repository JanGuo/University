package com.janguo.javabasic.jvmcode;

import java.util.UUID;

public class Heloworld {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        System.out.println(Text.a);
        System.out.println(Prent3.str);
    }
}

class Text{
    static final String a = "importence";
        }

class Prent3{
    public static String str = UUID.randomUUID().toString();
    static {
        System.out.println("jvmcode.Prent3 static code");
    }
}