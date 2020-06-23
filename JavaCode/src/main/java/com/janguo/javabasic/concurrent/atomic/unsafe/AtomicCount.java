package com.janguo.javabasic.concurrent.atomic.unsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicCount implements Count {
    private AtomicLong count = new AtomicLong();

    @Override
    public void increment() {
        count.incrementAndGet();
    }

    @Override
    public long getCount() {
        return count.get();
    }
}
