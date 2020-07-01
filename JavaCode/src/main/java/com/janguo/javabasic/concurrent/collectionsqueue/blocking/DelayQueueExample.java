package com.janguo.javabasic.concurrent.collectionsqueue.blocking;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

public class DelayQueueExample {
    public static <T extends Delayed> DelayQueue<T> creat() {
        return new DelayQueue<T>();
    }
}
