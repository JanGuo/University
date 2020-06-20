package com.janguo.javabasic.concurrent.concurrentbook;


/**
 * 测试串行与并发执行累加操作时间
 */
public class ConcurrentTest01 {
        private final static long COUNT = 2_000_000_000;
//    private final static long COUNT = Long.MAX_VALUE/2000000;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    public static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread thread = new Thread(() -> {
            long a = 0;
            for (long i = 0; i < COUNT; i++) {
                a += 5;
            }
        });
        thread.start();

        long b = 0;
        for (long j = 0; j < COUNT; j++) {
            b++;
        }

        thread.join();
        System.out.println("并行：  " + (System.currentTimeMillis() - start));
    }

    public static void serial() {
        long start = System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += 5;
        }
        long b = 0;
        for (long j = 0; j < COUNT; j++) {
            b++;
        }
        System.out.println("串行：" + (System.currentTimeMillis() - start));
    }
}
