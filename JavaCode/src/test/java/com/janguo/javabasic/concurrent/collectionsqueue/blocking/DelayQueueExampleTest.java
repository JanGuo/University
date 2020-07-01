package com.janguo.javabasic.concurrent.collectionsqueue.blocking;

import org.junit.Test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DelayQueueExampleTest {

    @Test
    public void testAdd() {
        DelayQueue<DelayElement<String>> queue = DelayQueueExample.creat();
        DelayElement<String> delay1 = DelayElement.of("Delay1", 1000);
        queue.add(delay1);
        assertThat(queue.size(),equalTo(1));
        long startTime = System.currentTimeMillis();
        // 立刻返回不会延时（Delay）
        // 迭代器也不会延时
        assertThat(queue.peek(),is(delay1));
//        assertThat(queue.take(),is(delay1));
        System.out.println(System.currentTimeMillis()-startTime);
    }

    @Test
    public void testComp() throws InterruptedException {
        DelayQueue<DelayElement<String>> queue = DelayQueueExample.creat();
        queue.add(DelayElement.of("Delay1", 1000));
        queue.add(DelayElement.of("Delay2", 800));
        queue.add(DelayElement.of("Delay3", 700));
        queue.add(DelayElement.of("Delay4", 1100));
        queue.add(DelayElement.of("Delay5", 2000));

        assertThat(queue.size(),equalTo(5));
        long startTime = System.currentTimeMillis();
        assertThat(queue.take().getData(),equalTo("Delay3"));
        System.out.println(System.currentTimeMillis()-startTime);
        assertThat(queue.size(),equalTo(4));

    }

    @Test
    public void testPoll() {
        DelayQueue<DelayElement<String>> queue = DelayQueueExample.creat();
        // 1. 没有
        // 2. 没有已经超时的
        assertThat(queue.poll(),equalTo(null));
    }

    static class DelayElement<E> implements Delayed {

        private final E e;
        private final long expireTime;

        DelayElement(E e, long expireTime) {
            this.e = e;
            this.expireTime = expireTime;
        }

        static <T> DelayElement<T> of (T e,long expireTime){
            return new DelayElement<T>(e,expireTime);
        }
        @Override
        public long getDelay(TimeUnit unit) {
            long diff = expireTime - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed delayedObj) {
            DelayElement that = (DelayElement) delayedObj;
            if (this.expireTime < that.getExpireTime()) {
                return -1;
            } else if (this.expireTime > that.getExpireTime()) {
                return 1;
            } else return 0;
        }

        public E getData() {
            return e;
        }

        public long getExpireTime() {
            return expireTime;
        }
    }

}