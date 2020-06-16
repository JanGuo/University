package com.janguo.javabasic.concurrent.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class newScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

//        scheduledExecutorService.schedule(()->{
//            System.out.println(Thread.currentThread().getName()+"----Running!");
//        },5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println(Thread.currentThread().getName()+"---Running!");
        },1,3,TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }

}
