package com.janguo.javabasic.concurrent.atomic.unsafe;

public class StupidCount implements Count{
    long count = 0;
    @Override
    public void increment() {
        count++;
    }

    @Override
    public long getCount() {
        return count;
    }
}
