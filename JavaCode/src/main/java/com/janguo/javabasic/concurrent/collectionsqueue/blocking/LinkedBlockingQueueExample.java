package com.janguo.javabasic.concurrent.collectionsqueue.blocking;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample {

    public <T> LinkedBlockingQueue<T> creat() {
        return new LinkedBlockingQueue<T>();
    }

    public <T> LinkedBlockingQueue<T> creat(int size) {
        return new LinkedBlockingQueue<T>(size);
    }
}
