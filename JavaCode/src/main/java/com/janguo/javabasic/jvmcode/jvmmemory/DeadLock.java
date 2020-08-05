package com.janguo.javabasic.jvmcode.jvmmemory;

public class DeadLock {
    public static void main(String[] args) {
        new Thread(() -> A.method()).start();
        new Thread(() -> B.method()).start();
    }
}

class A{
    public static synchronized void method(){
        System.out.println("A  Method ");
        try {
            Thread.sleep(5000);
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class B{
    public static synchronized void method(){
        System.out.println("B Method ");
        try {
            Thread.sleep(5000);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
