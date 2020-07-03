package com.janguo.javabasic.java8.date;

import java.time.Clock;

public class Java8ClockTest03 {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());
    }
}
