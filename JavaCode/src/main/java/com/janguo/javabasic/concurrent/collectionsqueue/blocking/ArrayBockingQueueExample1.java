package com.janguo.javabasic.concurrent.collectionsqueue.blocking;


import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBockingQueueExample1 {

        public <T> ArrayBlockingQueue<T> creat(int size){
            // 具有边界的Queue -- bounded
            return new ArrayBlockingQueue<>(size);
        }
}
