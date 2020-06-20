package com.janguo.javabasic.concurrent.thread.volatile1;

public class VolatileTest {
    private volatile static int initValue;

    private static final int MAX_VALUE = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = initValue;
            while (initValue < MAX_VALUE) {
                if (localValue != initValue) {
                    System.out.printf("The value is update to ( %d )\n", initValue);
                    localValue = initValue;
                }
                // System.out.println("initValue: "+initValue + "localValue: "+localValue);

                // READ  线程如果休眠一下（不加volatile）可以也正常执行
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }, "READER").start();


        new Thread(() -> {
            int localValue = initValue;
            while (initValue < MAX_VALUE) {
                System.out.printf("The value will update to ( %d )\n", ++localValue);
                initValue = localValue;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
