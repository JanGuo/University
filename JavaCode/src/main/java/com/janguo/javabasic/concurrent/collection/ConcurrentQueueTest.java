package com.janguo.javabasic.concurrent.collection;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueTest {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Long> queue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 100_000; i++) {
            queue.offer(System.nanoTime());
        }

        System.out.println("------END------");

        long startTIme = System.currentTimeMillis();
//        while (queue.size() > 0){
//            Long poll = queue.poll();
//        }

        /**
         *   size()方法，比较低效 底层不断循环浪费时间
         *   isEmpty()方法，高效判断 对于队列来说 判断头元素是不是为空
         *
         *   对于其他 比如字符串
         *   "".equals(s)  方法， 比较低效
         *   s.size == 0  方法， 比较高效
         *   s.isEmpty()  方法， 也比较高效
         */
        while (!queue.isEmpty()){
            Long poll = queue.poll();
        }

        System.out.println(System.currentTimeMillis() - startTIme);
    }

}
