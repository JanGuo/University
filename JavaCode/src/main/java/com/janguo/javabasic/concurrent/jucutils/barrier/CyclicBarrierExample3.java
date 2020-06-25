package com.janguo.javabasic.concurrent.jucutils.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier API -- reset()
 */
public class CyclicBarrierExample3 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"Will Await");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(5);
            cyclicBarrier.reset();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
