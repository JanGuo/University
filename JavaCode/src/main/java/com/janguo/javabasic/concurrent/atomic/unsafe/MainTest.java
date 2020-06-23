package com.janguo.javabasic.concurrent.atomic.unsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(1000);

        /**
         * 计数器的值为：---998428
         * 执行总耗时  ：---182
         */
//        Count count = new StupidCount();
        /**
         * 计数器的值为：---1000000
         * 执行总耗时  ：---207
         */
//        Count count = new SynCount();
        /**
         * 计数器的值为：---1000000
         * 执行总耗时  ：---164
         */
//        Count count = new LockCount();
        /**
         * 计数器的值为：---1000000
         * 执行总耗时  ：---189
         */
        Count count = new AtomicCount();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            threadPool.submit(new CountRunnable(count, 1000));
        }

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
        long endTime = System.currentTimeMillis();

        System.out.println("计数器的值为：---" + count.getCount());
        System.out.println("执行总耗时  ：--" + (startTime - endTime));
    }
}
