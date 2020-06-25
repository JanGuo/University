package com.janguo.javabasic.concurrent.jucutils.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExample2 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("Find All Parts is Finished!");
            }
        });

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(20);
                System.out.println(Thread.currentThread().getName() + " --- Job Finished --- Wait Other!");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " --- Finished!");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println(Thread.currentThread().getName() + " --- Job Finished --- Wait Other!");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " --- Finished!");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
