package com.janguo.javabasic.concurrent.thread.waitset;

import java.util.stream.IntStream;

/**
 * 测试LOCK进入等待状态后是不是以FIFO或者是其他的方式唤醒的
 * 显然不是；
 * 这个内容JVM没有提出设计原则，不同的设计JVM的厂商有不同的实现
 * 1，Sun Classic VM
 *    世界上第一款商用的java虚拟机，弱点：只能使用纯解释器的方式运行代码，所以执行效率比较慢。
 * 2，Exact VM
 *   只存在了一段时间，后被HotSpot  VM的替代
 * 3，HotSpot VM（现在基本最常用）
 *   现在的openJava  或者 Oracle 的java  都通过这个版本虚拟机执行代码。
 */
public class WaitSet {
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            new Thread(String.valueOf(i)) {
                @Override
                public void run() {
                    synchronized (LOCK) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "---In Wait");
                            LOCK.wait();
                            System.out.println(Thread.currentThread().getName() + "---Out Wait");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        });


        IntStream.rangeClosed(1, 10).forEach(i -> {
                    synchronized (LOCK) {
                        LOCK.notify();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }
}
