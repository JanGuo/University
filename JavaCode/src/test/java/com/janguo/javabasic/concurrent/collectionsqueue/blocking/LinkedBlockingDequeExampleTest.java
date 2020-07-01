package com.janguo.javabasic.concurrent.collectionsqueue.blocking;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class LinkedBlockingDequeExampleTest {

    private LinkedBlockingDequeExample example;
    @Before
    public void setUp() throws Exception {
        example = new LinkedBlockingDequeExample();
    }

    @After
    public void tearDown() throws Exception {
        example = null;
    }


    @Test
    public void testAdd() {
        LinkedBlockingDeque<String> deque = example.creat();
        // add 方法默认使用的是尾插
        assertThat(deque.add("Hello1"),equalTo(true));
        assertThat(deque.add("Hello2"),equalTo(true));
        assertThat(deque.add("Hello3"),equalTo(true));
        assertThat(deque.add("Hello4"),equalTo(true));
        assertThat(deque.add("Hello5"),equalTo(true));

        IntStream.rangeClosed(1,deque.size()).boxed().forEach(integer -> {
            // 头取
            assertThat(deque.poll(),equalTo("Hello"+integer));
        });
    }

    @Test
    public void testAddFirst() {
        LinkedBlockingDeque<String> deque = example.creat();
        // add 方法默认使用的是尾插
        deque.addFirst("Hello1");
        deque.addFirst("Hello2");
        deque.addFirst("Hello3");
        deque.addFirst("Hello4");
        deque.addFirst("Hello5");

        IntStream.rangeClosed(1,deque.size()).boxed().forEach(integer -> {
            // 头取
            assertThat(deque.poll(),equalTo("Hello"+(deque.size()+1)));
        });
    }
}