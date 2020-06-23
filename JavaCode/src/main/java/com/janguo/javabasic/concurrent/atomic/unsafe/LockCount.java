package com.janguo.javabasic.concurrent.atomic.unsafe;

import com.janguo.javabasic.concurrent.thread.synchroniz.Lock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockCount implements Count {
    private long count = 0;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void increment() {
        try {
            lock.lock();
            count++;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public long getCount() {
        return count;
    }
}
