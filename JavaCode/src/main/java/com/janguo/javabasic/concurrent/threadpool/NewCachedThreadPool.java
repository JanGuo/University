package com.janguo.javabasic.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPool {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"Running！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println(Thread.currentThread().getName());
        cachedThreadPool.shutdown();
        System.out.println("Main Thread Down!");
    }
}
