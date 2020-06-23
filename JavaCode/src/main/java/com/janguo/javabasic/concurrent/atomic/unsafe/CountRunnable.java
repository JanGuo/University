package com.janguo.javabasic.concurrent.atomic.unsafe;

public class CountRunnable implements Runnable{

    private final Count count;


    private final int num;

    public CountRunnable(Count count, int num) {
        this.count = count;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            count.increment();
        }
    }
}
