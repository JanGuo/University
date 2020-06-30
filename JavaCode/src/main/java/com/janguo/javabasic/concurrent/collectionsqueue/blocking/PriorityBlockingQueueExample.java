package com.janguo.javabasic.concurrent.collectionsqueue.blocking;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 底层数组 无边界
 */
public class PriorityBlockingQueueExample {
    public <T> PriorityBlockingQueue<T> creat() {
        return new PriorityBlockingQueue<T>();
    }
    public <T> PriorityBlockingQueue<T> creat(int size,Comparator<? super T> comparable) {
        return new PriorityBlockingQueue<T>(size, comparable);
    }
}
