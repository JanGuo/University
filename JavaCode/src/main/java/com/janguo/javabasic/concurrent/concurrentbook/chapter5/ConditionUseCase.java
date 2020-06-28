package com.janguo.javabasic.concurrent.concurrentbook.chapter5;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * await()signal() 相当于synchronized中的Object.wait() / Object.notifyAll()
 */
public class ConditionUseCase {

    private final static Lock lock = new ReentrantLock();
    private final static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                conditionWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(ConditionUseCase::conditionSignal).start();
    }
    public static void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("----Start Wait----");
            condition.await();
            System.out.println("----END Wait----");
        } finally {
            System.out.println("---Unlock---");
            lock.unlock();
        }
    }

    public static void conditionSignal(){
        lock.lock();
        try {
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
