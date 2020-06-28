package com.janguo.javabasic.concurrent.concurrentbook.chapter5;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 深入了解Condition的使用方式
 */
public class BoundedQueue<T> {
    private final Object[] items;
    // 添加的下标，删除的下标和数组当前数量
    private int addIndex, removeIndex, count;
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public BoundedQueue(Object[] items) {
        this.items = items;
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[addIndex] = t;
            if (++addIndex == items.length)
                addIndex = 0;
            ++count;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[removeIndex];
            if (++removeIndex == items.length)
                removeIndex = 0;
            --count;
            //相当于对等待队列中的每个节点均执行一次signal()方法， 果就是将等待队列中所有节点全部移动到同步队列中，并唤醒每个节点的线程。
//            notFull.signalAll();
            // 将会唤醒在等待队列中等待时间最长的节点(首节点)，在唤醒节点（LockSupport）之前，会将节点移到同步队列中。
            notFull.signal();
            return (T) x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Integer[] integers = new Integer[10];
        BoundedQueue<Integer> queue = new BoundedQueue<Integer>(integers);

        IntStream.rangeClosed(1, 10).boxed().forEach(integer -> {
            new Thread(() -> {
               while (true){
                   try {
                       TimeUnit.SECONDS.sleep(2);
                       queue.add(integer);
                       System.out.println(Thread.currentThread().getName()+"--ADD--"+integer+"To Integer[]");
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }).start();
        });
        TimeUnit.SECONDS.sleep(5);

        new Thread(()->{
            while (true){
                try {
                    System.out.println("IN TO Remove!");
                    for (int i = 0; i < 3; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("From Integer[] --Remove--第"+i+"个 ---- "+queue.remove());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
