package com.janguo.javabasic.concurrent.collections.blocking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Struct;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class ArrayBockingQueueTest1Test {


    private ArrayBockingQueueExample1 example;

    @Before
    public void setUp() {
        example = new ArrayBockingQueueExample1();
    }

    @After
    public void setDown() {
        example = null;
    }

    /*--------------------------IN----------------------------*/
    @Test
    public void testAddMethodNotExceedCapacity() {
        ArrayBlockingQueue<Object> queue = example.creat(5);

        assertThat(queue.add("Hello1"), equalTo(true));
        assertThat(queue.add("Hello2"), equalTo(true));
        assertThat(queue.add("Hello3"), equalTo(true));
        assertThat(queue.add("Hello4"), equalTo(true));
        assertThat(queue.add("Hello5"), equalTo(true));
        assertThat(queue.size(), equalTo(5));

    }

    @Test(expected = IllegalStateException.class)
    public void testAddMethodExceedCapacity() {
        ArrayBlockingQueue<Object> queue = example.creat(5);

        // @throws IllegalStateException if this queue is full
        assertThat(queue.add("Hello1"), equalTo(true));
        assertThat(queue.add("Hello2"), equalTo(true));
        assertThat(queue.add("Hello3"), equalTo(true));
        assertThat(queue.add("Hello4"), equalTo(true));
        assertThat(queue.add("Hello5"), equalTo(true));
        assertThat(queue.add("Hello6"), equalTo(false));
        fail("Should Not Process to here.");
        assertThat(queue.size(), equalTo(5));
    }

    @Test
    public void testOfferMethodNotExceedCapacity() {
        ArrayBlockingQueue<Object> queue = example.creat(5);

        //  When using a capacity-restricted queue,
        //  this method is generally preferable to add,
        //  which can fail to insert an element only by throwing an exception.
        // 不会抛出异常 返回False
        assertThat(queue.offer("Hello1"), equalTo(true));
        assertThat(queue.offer("Hello2"), equalTo(true));
        assertThat(queue.offer("Hello3"), equalTo(true));
        assertThat(queue.offer("Hello4"), equalTo(true));
        assertThat(queue.offer("Hello5"), equalTo(true));
        assertThat(queue.offer("Hello6"), equalTo(false));

        assertThat(queue.size(), equalTo(5));
    }

    @Test
    public void testPutMethodNotExceedCapacity() throws InterruptedException {
        ArrayBlockingQueue<Object> queue = example.creat(5);

        // 阻塞 可以被打断抛出 InterruptedException
        queue.put("Hello1");
        queue.put("Hello2");
        queue.put("Hello3");
        queue.put("Hello4");
        queue.put("Hello5");

        assertThat(queue.size(), equalTo(5));
    }

    @Test
    public void testPutMethodExceedCapacity() throws InterruptedException {
        ArrayBlockingQueue<Object> queue = example.creat(5);
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(() -> {
            try {
                assertThat(queue.take(), equalTo("Hello1"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2, TimeUnit.SECONDS);
        // 阻塞 可以被打断抛出 InterruptedException
        queue.put("Hello1");
        queue.put("Hello2");
        queue.put("Hello3");
        queue.put("Hello4");
        queue.put("Hello5");
        queue.put("Hello6");
        service.shutdown();
        assertThat(queue.size(), equalTo(5));
    }

    /*--------------------------OUT----------------------------*/
    @Test
    public void testElementMethodExceedCapacity() {
        ArrayBlockingQueue<Object> queue = example.creat(5);

        assertThat(queue.add("Hello1"), equalTo(true));
        assertThat(queue.add("Hello2"), equalTo(true));
        assertThat(queue.add("Hello3"), equalTo(true));
        assertThat(queue.add("Hello4"), equalTo(true));
        assertThat(queue.add("Hello5"), equalTo(true));
        // Retrieves, but does not remove, the head of this queue.
        // @throws NoSuchElementException if this queue is empty
        assertThat(queue.element(), equalTo("Hello1"));
        assertThat(queue.size(), equalTo(5));

        assertThat(queue.element(), equalTo("Hello1"));

    }

    @Test(expected = NoSuchElementException.class)
    public void testElementMethodQueueEmpty() {
        ArrayBlockingQueue<Object> queue = example.creat(5);

        // @throws NoSuchElementException if this queue is empty
        assertThat(queue.element(), equalTo("Hello1"));
        fail("Should Not Process to here.");

    }
    @Test
    public void testElementMethodQueue() {
        ArrayBlockingQueue<Object> queue = example.creat(5);
        assertThat(queue.add("Hello1"), equalTo(true));
        assertThat(queue.add("Hello2"), equalTo(true));
        assertThat(queue.add("Hello3"), equalTo(true));
        // Retrieves, but does not remove, the head of this queue.  This method
        //     * differs from {@link #peek peek} only in that it throws an exception if
        //     * this queue is empty.
        assertThat(queue.element(), equalTo("Hello1"));
        assertThat(queue.size(),equalTo(3));
    }

    @Test
    public void testPeekMethodQueueEmpty() {
        ArrayBlockingQueue<Object> queue = example.creat(5);

        //Retrieves, but does not remove, the head of this queue,
        // or returns null if this queue is empty.
        assertThat(queue.peek(), equalTo(null));
        assertThat(queue.size(), equalTo(0));
    }

    @Test
    public void testPollMethodQueue() {
        ArrayBlockingQueue<Object> queue = example.creat(5);
        assertThat(queue.add("Hello1"), equalTo(true));
        assertThat(queue.add("Hello2"), equalTo(true));
        assertThat(queue.add("Hello3"), equalTo(true));
        assertThat(queue.add("Hello4"), equalTo(true));
        assertThat(queue.add("Hello5"), equalTo(true));
//      * Retrieves and removes the head of this queue,
//      * or returns {@code null} if this queue is empty.
        assertThat(queue.poll(), equalTo("Hello1"));
        assertThat(queue.size(), equalTo(4));
    }

    @Test
    public void testPollMethodQueueEmpty() {
        ArrayBlockingQueue<Object> queue = example.creat(5);

//      * Retrieves and removes the head of this queue,
//      * or returns {@code null} if this queue is empty.
        assertThat(queue.poll(), equalTo(null));
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveMethodQueueEmpty() {
        ArrayBlockingQueue<Object> queue = example.creat(5);

//      * Retrieves and removes the head of this queue,
//      * or returns {@code null} if this queue is empty.
        assertThat(queue.remove(), equalTo(null));
    }

    @Test
    public void testRemoveMethodQueue() {
        ArrayBlockingQueue<Object> queue = example.creat(5);
        assertThat(queue.add("Hello1"), equalTo(true));
        assertThat(queue.add("Hello2"), equalTo(true));
        assertThat(queue.add("Hello3"), equalTo(true));
        assertThat(queue.add("Hello4"), equalTo(true));
//      * Retrieves and removes the head of this queue,
//      * or returns {@code null} if this queue is empty.
        assertThat(queue.remove(), equalTo("Hello1"));
        assertThat(queue.size(), equalTo(3));

    }

    @Test
    public void testClearMethodQueue() {
        ArrayBlockingQueue<Object> queue = example.creat(5);
        assertThat(queue.add("Hello1"), equalTo(true));
        assertThat(queue.add("Hello2"), equalTo(true));
        assertThat(queue.add("Hello3"), equalTo(true));
        assertThat(queue.add("Hello4"), equalTo(true));

        queue.clear();
        assertThat(queue.size(), equalTo(0));

    }

}