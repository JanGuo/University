package com.janguo.javabasic.concurrent.atomic.array;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
    public static void main(String[] args) {
        // 常用方法
        AtomicIntegerArray integerArray = new AtomicIntegerArray(10);

        System.out.println(integerArray.length());
        System.out.println(integerArray.getAndIncrement(0));
        System.out.println(integerArray.incrementAndGet(9));
        System.out.println("---------------");
        System.out.println(integerArray.compareAndSet(1, 0, 15));
        System.out.println(integerArray.get(1));

    }
}
