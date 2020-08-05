package com.janguo.javabasic.jvmcode;

import java.util.Random;

public class JvmText01 {
    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}

interface Prent05 {
    Thread thread = new Thread(){
        {
            System.out.println("执行了。。。");
        }
    };
}

class Child implements Prent05{
    public static final int b = new Random().nextInt(5);
}
