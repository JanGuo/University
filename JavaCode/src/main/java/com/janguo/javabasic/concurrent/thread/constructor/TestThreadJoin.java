package com.janguo.javabasic.concurrent.thread.constructor;

import java.util.Optional;
import java.util.stream.IntStream;

public class TestThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            IntStream.range(1, 1000).forEach(i -> {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            });
        });
        thread.start();
//        thread.join(); //启动此线程的线程，会等待此线程执行结束后，继续执行。
        thread.join(10); // 等待 10ms 之后就执行主线程
        Optional.of("Main Start Running").ifPresent(System.out::println);
        Optional.of("Main is Ending").ifPresent(System.out::println);
    }
}
