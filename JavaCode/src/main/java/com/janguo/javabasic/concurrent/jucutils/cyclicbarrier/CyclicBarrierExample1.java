package com.janguo.javabasic.concurrent.jucutils.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * A synchronization aid that allows a set of threads to all wait for each other
 * to reach a common barrier point.
 * CyclicBarriers are useful in programs involving a fixed sized party of threads
 * that must occasionally wait for each other. The barrier is called cyclic because
 * it can be re-used after the waiting threads are released.
 *
 * 他们会相互监视状态。 CountDownLatch 是一个人监视其他人
 *
 * Cyclic  环的；循环的；周期的
 * Barrier 障碍物 屏障；界限
 *
 *
 * CountDownLatch VS CyclicBarrier
 *
 * 1. CountDownLatch 不能 reset， 二CyclicBarrier是可以循环使用的额
 * 2. CountDownLatch 工作线程之间不会相互关心， CyclicBarrier 工作线程必须等到同一个共同的点才会继续去执行某个动作
 *          见eg2 构造函数中传入了 Runnable任务
 *
 *「1. CountDownLatch的计数器只能使用一次。而CyclicBarrier的计数器可以使用reset() 方法重置。所以CyclicBarrier能处理更为复杂的业务场景，比如如果计算发生错误，可以重置计数器，并让线程们重新执行一次。
 * 2. CyclicBarrier还提供其他有用的方法，比如getNumberWaiting方法可以获得CyclicBarrier阻塞的线程数量。isBroken方法用来知道阻塞的线程是否被中断。比如以下代码执行完之后会返回true。」
 */
public class CyclicBarrierExample1 {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " --- Job Finished --- Wait Other!");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " --- Finished!");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println(Thread.currentThread().getName() + " --- Job Finished --- Wait Other!");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " --- Finished!");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();


        // 可以使用在cyclicBarrier中传入一个Runnable接口的方式实现 见eg 2
//        cyclicBarrier.await();
//        System.out.println("Find All Thread is Finished!");

        // API
        while (true) {
            System.out.println("Waiting Number --- " + cyclicBarrier.getNumberWaiting());
            System.out.println("Parts Size --- " + cyclicBarrier.getParties());
            System.out.println("Broking is or not --- " + cyclicBarrier.isBroken());
            TimeUnit.SECONDS.sleep(5);
        }

    }
}
