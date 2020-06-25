package com.janguo.javabasic.concurrent.jucutils.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore 信号灯  信号量
 *
 * 使用{@link Semaphore} 里面维护了一个类似于许可证的变量
 * 实现一个锁的功能
 */
public class SemaphoreExample1 {
    public static void main(String[] args) {

        final SemaphoreLock lock = new SemaphoreLock();
        for (int i = 0; i < 5; i++) {

            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+"is Runnable!");
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "Having this LOCK");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                System.out.println(Thread.currentThread().getName() + "Release this LOCK");

            }).start();
        }


    }

    /**
     * 通过{@link Semaphore}  的构造函数，可以实现多个线程同时获得一把锁来进行处理
     */
    static class SemaphoreLock {
        private final Semaphore semaphore = new Semaphore(2);

        public void lock() throws InterruptedException {
            semaphore.acquire();
        }

        public void unlock() {
            semaphore.release();
        }
    }
}
