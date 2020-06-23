package com.janguo.javabasic.concurrent.atomic.unsafe;

public class SynCount implements Count{

    long count = 0;
    @Override
    public synchronized void increment() {
        count++;
    }

    @Override
    public long getCount() {
        return count;
    }
}
