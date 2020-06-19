package com.janguo.javabasic.concurrent.thread.constructor;

import java.util.Optional;

public class TestThreadDefaultParameter {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        // Lambda 判断时候出现空指针的问题
        Optional.ofNullable(thread.getName()).ifPresent(System.out::println);
        Optional.of(thread.getId()).ifPresent(System.out::println);
        Optional.of(thread.getPriority()).ifPresent(System.out::println);

    }
}
