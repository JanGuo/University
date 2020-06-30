package com.janguo.javabasic.concurrent.collectionsqueue.blocking;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 *  * A {@linkplain BlockingQueue blocking queue} in which each insert
 *  * operation must wait for a corresponding remove operation by another
 *  * thread, and vice versa.
 *
 *  需要学  Transferer<E>
 */
public class SynchronousQueueExample {

    public static <T> SynchronousQueue<T> creat() {
        return new SynchronousQueue<T>();
    }
}
