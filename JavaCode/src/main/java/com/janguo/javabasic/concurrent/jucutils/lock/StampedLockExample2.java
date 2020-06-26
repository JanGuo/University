package com.janguo.javabasic.concurrent.jucutils.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StampedLockExample2 {
    private static final StampedLock LOCK = new StampedLock();
    private static final List<Long> DATE = new ArrayList<>();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Runnable readRunnable = () -> {
            for (; ; ) {
                read();
            }
        };

        Runnable writeRunnable = () -> {
            for (; ; ) {
                write();
            }
        };


        IntStream.rangeClosed(1, 9).forEach(i -> service.submit(readRunnable));
        service.submit(writeRunnable);


    }

    private static void read() {
        long stamp = LOCK.tryOptimisticRead();
        if (LOCK.validate(stamp)) {
            try {
                stamp = LOCK.readLock();
                Optional.of(DATE.stream().map(String::valueOf).collect(Collectors.joining("-", "R-", ""))).ifPresent(System.out::println);
                TimeUnit.MICROSECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock(stamp);
            }
        }
    }

    private static void write() {
        long stamp = -1;
        try {
            stamp = LOCK.readLock();
            DATE.add(System.currentTimeMillis());
            System.out.println("---W---");
            TimeUnit.MICROSECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock(stamp);
        }
    }
}
