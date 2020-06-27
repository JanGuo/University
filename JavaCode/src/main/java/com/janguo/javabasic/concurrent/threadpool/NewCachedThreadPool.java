package com.janguo.javabasic.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class NewCachedThreadPool {

    public static void main(String[] args) {
        /**
         * These pools will typically improve the performance
         * of programs that execute many short-lived asynchronous tasks.
         *
         * SynchronousQueue BlockingQueue 只有一个空间
         * cachedThreadPool 中核心线程数是0 当提交100个线程的时候 现在是创建10个线程(以前就会创建100个线程去处理)
         * 所以说不适合去处理占用时间比较长的任务 只适合处理 short-lived 的任务
         *
         * 并且在 60 秒之后会回收 所有的线程
         */
        ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+" --- Running！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println(cachedThreadPool.getActiveCount());
//        System.out.println(Thread.currentThread().getName());
        // cachedThreadPool.shutdown();
        // System.out.println("Main Thread Down!");
    }
}
