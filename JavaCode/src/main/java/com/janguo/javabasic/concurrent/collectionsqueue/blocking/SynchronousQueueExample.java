package com.janguo.javabasic.concurrent.collectionsqueue.blocking;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 *  * A {@linkplain BlockingQueue blocking queue} in which each insert
 *  * operation must wait for a corresponding remove operation by another
 *  * thread, and vice versa.
 */
public class SynchronousQueueExample {

    public <T> SynchronousQueue<T> creat() {
        return new SynchronousQueue<T>();
    }
}
