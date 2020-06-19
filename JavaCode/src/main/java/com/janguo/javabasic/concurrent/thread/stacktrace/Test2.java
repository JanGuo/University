package com.janguo.javabasic.concurrent.thread.stacktrace;

import java.util.Arrays;
import java.util.Optional;

public class Test2 {

    public void run() {
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e -> !e.isNativeMethod())
                .forEach(e -> Optional.of(e.getClassName() + "--" + e.getMethodName() + "--" + e.getLineNumber())
                        .ifPresent(System.out::println)
                );
    }
}
