package com.janguo.javabasic.concurrent.threadpool;

import com.janguo.javabasic.concurrent.concurrentbook.utils.SleepUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

public class NewFixedTreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        IntStream.rangeClosed(0, 99).boxed().forEach(integer -> fixedThreadPool.execute(
                () -> {
                    SleepUtils.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "[" + integer + "]");
                }
        ));
        System.out.println("激活的线程总数：--- "+fixedThreadPool.getActiveCount());

        SleepUtils.sleep(3);
        System.out.println("Completed Task numbers --- " + fixedThreadPool.getCompletedTaskCount());

//        for (int i = 0; i < 10; i++) {
//            fixedThreadPool.execute(()->{
//                System.out.println(Thread.currentThread().getName()+"---Running!");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
        fixedThreadPool.shutdown();
    }
}
