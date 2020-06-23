package com.janguo.javabasic.concurrent.atomic.field;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdaterTest {
    public static void main(String[] args) {
        AtomicReferenceFieldUpdater<TestMe2, Integer> fieldUpdater = AtomicReferenceFieldUpdater.newUpdater(TestMe2.class,Integer.class,"i");

        List<Thread> threads = new ArrayList<>();
        TestMe2 me2 = new TestMe2();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j <= 10; j++) {
                    Integer noUpdate = fieldUpdater.getAndSet(me2, j);
                    System.out.println(noUpdate);
                }
            });

            thread.start();
            threads.add(thread);

        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(Thread.currentThread().getName()+"---"+me2.getI());
    }

    static class TestMe2{
        volatile Integer i;

        public Integer getI() {
            return i;
        }
    }
}
