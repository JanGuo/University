package com.janguo.javabasic.concurrent.jucutils.condition;

import com.janguo.javabasic.concurrent.concurrentbook.utils.SleepUtils;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ConditionExample1 {
    private static final Lock LOCK = new ReentrantLock();

    private static final Condition PRODUCE_COND = LOCK.newCondition();

    private static final Condition CONSUMER_COND = LOCK.newCondition();

    private static final LinkedList<Long> TIMESTAMP_POOL = new LinkedList<>();

    private static final int MAX_CAPACITY = 10;


    private static long countProduce;
    private static long countConsumer;

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5).forEach(ConditionExample1::beginProduce);

        IntStream.rangeClosed(1, 12).forEach(ConditionExample1::beginConsumer);

        while (true) {
            SleepUtils.sleep(1);
            System.out.println("CountProduce: " + countProduce);
            System.out.println("CountConsumer: " + countConsumer);
            System.out.println("PoolSize: " +TIMESTAMP_POOL.size());
        }
    }

    private static void beginProduce(int i) {
        new Thread(() -> {
            for (; ; ) {
                produce();
                SleepUtils.sleep(2);
            }
        }, "P-" + i).start();
    }

    private static void beginConsumer(int i) {
        new Thread(() -> {
            for (; ; ) {
                consumer();
                SleepUtils.sleep(2);
            }
        }, "C-" + i).start();
    }

    public static void produce() {
        try {
            LOCK.lock();
            while (!(TIMESTAMP_POOL.size() < MAX_CAPACITY)) {
                PRODUCE_COND.await();
            }
            long value = System.currentTimeMillis();
            System.out.println("Produce:" + Thread.currentThread().getName() + "---" + value);
            TIMESTAMP_POOL.addLast(value);
            countProduce++;
            CONSUMER_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    public static void consumer() {
        try {
            LOCK.lock();
            while (TIMESTAMP_POOL.isEmpty()) {
                CONSUMER_COND.await();
            }
            Long value = TIMESTAMP_POOL.removeFirst();
            countConsumer++;
            System.out.println("Consumer: " + Thread.currentThread().getName() + "---" + value);
            PRODUCE_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }
}
