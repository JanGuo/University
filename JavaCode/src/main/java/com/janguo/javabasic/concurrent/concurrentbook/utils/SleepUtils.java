package com.janguo.javabasic.concurrent.concurrentbook.utils;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    public static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
