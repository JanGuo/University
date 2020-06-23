package com.janguo.javabasic.concurrent.atomic.atomicstampedrefrence;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 解决ABA问题的途径 Java中给的默认实现方式 AtomicStampedReference
 * 的使用
 */
public class AtomicStampedReferenceTest {
    private static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100, 0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "---Before Sleep: Stamp is---" + stampedReference.getStamp());
                TimeUnit.SECONDS.sleep(1);
                boolean result1 = stampedReference.compareAndSet(100, 101, stampedReference.getStamp(), stampedReference.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + result1);
                System.out.println(Thread.currentThread().getName() + "---End Sleep: Stamp is---" + (stampedReference.getStamp()));
                System.out.println(Thread.currentThread().getName() + "---Before Sleep: Stamp is---" + stampedReference.getStamp());
                boolean result = stampedReference.compareAndSet(101, 100, stampedReference.getStamp(), stampedReference.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + result);
                System.out.println(Thread.currentThread().getName() + "---End Sleep: Stamp is---" + (stampedReference.getStamp()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                while (true) {
                    int stamp = stampedReference.getStamp();
                    Integer reference = stampedReference.getReference();
                    System.out.println(Thread.currentThread().getName() + "---Before Sleep: Stamp is---" + stamp);
                    TimeUnit.SECONDS.sleep(1);

                    boolean b = stampedReference.compareAndSet(100, 101, stamp, stamp + 1);
                    if (b) {
                        System.out.println(Thread.currentThread().getName() + "---End Sleep: Stamp is---" + (stamp + 1));
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "Fail!");
                    // stampedReference.compareAndSet(101, 100, stamp, stamp + 1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(stampedReference.getStamp());
    }
}
