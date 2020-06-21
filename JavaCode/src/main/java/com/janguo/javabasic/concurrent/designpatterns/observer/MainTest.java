package com.janguo.javabasic.concurrent.designpatterns.observer;

import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) {
        ThreadLifeCycleObserver observer = new ThreadLifeCycleObserver();
        observer.concurrentQuery(Arrays.asList("1","2"));
    }
}
