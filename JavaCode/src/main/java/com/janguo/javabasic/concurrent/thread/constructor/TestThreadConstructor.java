package com.janguo.javabasic.concurrent.thread.constructor;

import java.util.Arrays;

public class TestThreadConstructor {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(thread.getThreadGroup());
        thread.start();

        // 获取当前线程Main线程的线程组的成员个数
        int count = Thread.currentThread().getThreadGroup().activeCount();
        Thread[] threads = new Thread[count];
        // 将线程组成员添加到数组中
        Thread.currentThread().getThreadGroup().enumerate(threads);

        // Java8 的流式编程
        Arrays.asList(threads).forEach(System.out::println);
//        // 遍历数组中的内容
//        for (Thread thread1 : threads) {
//            // 得到线程的内容
//            System.out.println(thread1);
//        }
        System.out.println();


    }
}
