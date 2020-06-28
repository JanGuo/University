package com.janguo.javabasic.concurrent.concurrentbook.chapter5;


import java.util.concurrent.locks.Lock;
import java.util.stream.IntStream;

public class TwinsLockTest {

    private static final Lock LOCK = new TwinsLock();
    private static int count = 0;

    public static void main(String[] args) {
        IntStream.rangeClosed(0, 10).boxed().forEach(integer -> {
            new Thread(() -> {
                while (true) {
                    try {
                        LOCK.lock();
                        count++;
                        System.out.println(count);
                    } finally {
                        LOCK.unlock();
                    }
                }

            }).start();
        });


    }
}
