package com.janguo.javabasic.concurrent.threadpool.diythreadpool;

import java.util.Optional;
import java.util.stream.IntStream;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool threadPool = new SimpleThreadPool(10,100,() -> {
            throw new DiscardException("Discard this task");
        });
//        MySelfPool threadPool = new MySelfPool();

        IntStream.rangeClosed(0, 40).forEach(i -> {
            threadPool.submit(() -> {
                Optional.of("The Runnable: "+i+Thread.currentThread().getName() + "为你服务！").ifPresent(System.out::println);
                try {
                    Thread.sleep(5_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Optional.of("The Runnable: "+i+Thread.currentThread().getName() + "结束服务！").ifPresent(System.out::println);
            });
        });

        Thread.sleep(30_000);
        threadPool.shutdown();
    }
}
