package com.janguo.javabasic.concurrent.thread.synchroniz;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class MarkWord {

    static final Lock LOCK = new Lock();

    public static void main(String[] args) throws InterruptedException {


//        TimeUnit.SECONDS.sleep(5); // 现在没啥作用了

        // System.out.println(Integer.toHexString(LOCK.hashCode()));

        // System.out.println(LOCK.hashCode());

        // 查看对象头信息
        synchronized (LOCK) {
            System.out.println(ClassLayout.parseInstance(LOCK).toPrintable());
        }
    }
}
