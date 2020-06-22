package com.janguo.javabasic.concurrent.thread.threadlocal;

import java.util.stream.IntStream;

/**
 * 使用ThreadLocal 封装Context 某个线程其他方法调用，不需要专递参数   实现了线程间的数据共享；
 */
public class MainTest {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5).forEach(i ->
                new Thread(new ExecutionTask()).start()
        );
    }
}
