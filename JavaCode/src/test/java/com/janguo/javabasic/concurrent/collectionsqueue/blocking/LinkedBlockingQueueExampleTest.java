package com.janguo.javabasic.concurrent.collectionsqueue.blocking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class LinkedBlockingQueueExampleTest {


    private LinkedBlockingQueueExample example;

    @Before
    public void setUp() {
        example = new LinkedBlockingQueueExample();
    }

    @After
    public void setDown() {
        example = null;
    }


    @Test(expected = IllegalStateException.class)
    public void testAdd() {
        LinkedBlockingQueue<String> queue = example.creat(2);
        assertThat(queue.add("Hello"),equalTo(true));
        assertThat(queue.add("Hello"),equalTo(true));
        assertThat(queue.add("Hello"),equalTo(false));

    }
    @Test
    public void testOffer() {
        LinkedBlockingQueue<String> queue = example.creat(2);
        assertThat(queue.offer("Hello"),equalTo(true));
        assertThat(queue.offer("Hello"),equalTo(true));
        assertThat(queue.offer("Hello"),equalTo(false));

    }

    @Test
    public void test() {
        // last = last.next = node;  尾插
        int a = 1;
        int b = 2;
        int c = 3;
        a = b = c;
        System.out.println("a" + a + " ; " + "b" + b + " ； " + "c" + c);

    }
}