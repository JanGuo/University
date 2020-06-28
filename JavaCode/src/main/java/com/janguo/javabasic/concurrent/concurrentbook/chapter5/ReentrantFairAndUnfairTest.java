package com.janguo.javabasic.concurrent.concurrentbook.chapter5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 非公平性锁可能使线程“饥饿”，为什么它又被设定成默认的实现呢?再次观察上表的结
 * 果，如果把每次不同线程获取到锁定义为1次切换，公平性锁在测试中进行了10次切换，
 * 而非 公平性锁只有5次切换，这说明非公平性锁的开销更小。
 */
public class ReentrantFairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    public static void main(String[] args) {
        IntStream.rangeClosed(1,5).boxed().forEach(integer -> {
            new Job(unfairLock).start();
//            new Job(fairLock).start();
        });

    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            IntStream.rangeClosed(0, 1).boxed().forEach((integer) -> {
                try {
                    System.out.println("第"+integer+"次"+Thread.currentThread().getName()+" ---Will LOCK---");

                    lock.lock();
                    TimeUnit.SECONDS.sleep(1);

                    ReentrantLock2 lock = (ReentrantLock2) this.lock;

                    System.out.println("LOCK By -- [" + Thread.currentThread().getName() + "] --- Waiting By [" + lock.getQueuedThreads() + "]");

                    System.out.println("第"+integer+"次"+Thread.currentThread().getName()+"-----END LOCK------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            });
        }
    }

    static class ReentrantLock2 extends ReentrantLock {

        // 是否是公平锁的构造函数
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            ArrayList<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);

            return arrayList;
        }



    }
}
