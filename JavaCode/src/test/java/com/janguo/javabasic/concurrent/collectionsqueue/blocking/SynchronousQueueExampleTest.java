package com.janguo.javabasic.concurrent.collectionsqueue.blocking;

import com.janguo.javabasic.concurrent.concurrentbook.utils.SleepUtils;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class SynchronousQueueExampleTest {

    @Test
    public void testAdd() throws InterruptedException {
        SynchronousQueue<Object> queue = SynchronousQueueExample.creat();

        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                assertThat(queue.take(), equalTo("Hello"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        TimeUnit.MILLISECONDS.sleep(1);

        assertThat(queue.add("Hello"), equalTo(true));

        // Executors Shutdown
    }

    @Test
    public void testOffer() throws InterruptedException {
        SynchronousQueue<Object> queue = SynchronousQueueExample.creat();

        Executors.newSingleThreadExecutor().submit(() -> {
            try {

                assertThat(queue.take(), equalTo("Hello"));


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        TimeUnit.MILLISECONDS.sleep(1);
        assertThat(queue.offer("Hello"),equalTo(true));


        // Executors Shutdown
    }

    @Test
    public void testPut() throws InterruptedException {
        SynchronousQueue<Object> queue = SynchronousQueueExample.creat();

        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
                assertThat(queue.take(), equalTo("Hello"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        queue.put("Hello");
        // Executors Shutdown
    }
}