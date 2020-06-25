package com.janguo.javabasic.concurrent.concurrentbook.chapter4;

import com.janguo.javabasic.concurrent.concurrentbook.utils.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 等待方
 * 1. 获取对象锁
 * 2. 如果条件不满足，那么调用对象的wait（）方法，被通知后仍要检查条件
 * 3. 条件满足则执行对应的逻辑
 * 伪代码：
 * synchronized(LOCK){
 *     while(条件不满足){
 *         LOCK.wait():
 *     }
 *     条件满足的对应处理逻辑
 * }
 *
 * 通知方
 * 1. 获得对象锁
 * 2. 改变条件
 * 3. 通知所有等待的对象上的线程
 *
 * 伪代码：
 * synchronized(LOCK){
 *     改变条件
 *     LOCK.notifyAll();
 * }
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        SleepUtils.sleep(1);

        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized(lock){
                // 当条件不满足时，继续wait，同时释放了lock的锁
                while (flag){
                    try {
                        System.out.println(Thread.currentThread()+"Flag is true. wait @"
                                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 条件满足时，完成工作
                System.out.println(Thread.currentThread()+"Flag is false . wait @"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized(lock){
                // 获取到lock的锁，然后进行通知，通知时不会释放lock的锁
                // 知道当前线程释放了lock的锁之后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread()+"Hold lock. notify @"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.sleep(5);
            }
//            SleepUtils.sleep(10);
            // 再次加锁
            synchronized(lock){
                System.out.println(Thread.currentThread()+"Hold lock again. sleep @"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.sleep(5);
            }
        }
    }
}
