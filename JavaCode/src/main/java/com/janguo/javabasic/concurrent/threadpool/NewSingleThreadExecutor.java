package com.janguo.javabasic.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class NewSingleThreadExecutor {
    public static void main(String[] args) {
        /**
         * 相比于自己创建的线程的优点
         * 1. 它是一只存活的
         * 2. 它可以使用队列来存储任务
         * 3. 当线程错误终止的时候它会创建一个新的线程来执行剩下的任务
         */

        // FinalizableDelegatedExecutorService --- 可终结 代理
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        singleThreadExecutor.execute(()->{
            System.out.println(Thread.currentThread().getName() + "Running!");
            int a = 10/0;
            System.out.println(Thread.currentThread().getName()+"Error!");
        });

        IntStream.range(0,10).boxed().forEach(integer -> singleThreadExecutor.execute(()->{
            System.out.println(Thread.currentThread().getName()+ "Running!");
        }));
//        for (int i = 0; i < 10; i++) {
//            singleThreadExecutor.execute(()->{
//                System.out.println(Thread.currentThread().getName()+"----Running!");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }

        singleThreadExecutor.shutdown();
    }
}
