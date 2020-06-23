package com.janguo.javabasic.concurrent.atomic.atomicintegerr;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicIntegerConcurrent {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static List<Thread> threadList = new ArrayList<>();

    private volatile static int value = 0;
    public static void main(String[] args) {
        IntStream.rangeClosed(1,10).forEach(i->{
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
//                    while (true){
//                        int i1 = atomicInteger.get();
//                        boolean result = atomicInteger.compareAndSet(i1, ++i1);
//                        if (result) break;
//                    }
                    atomicInteger.getAndIncrement();
                }
            });
            threadList.add(thread);
        });
        threadList.forEach(Thread::start);
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(atomicInteger.get());
    }
}
