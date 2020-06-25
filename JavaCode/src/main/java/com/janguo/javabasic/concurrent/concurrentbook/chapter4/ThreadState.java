package com.janguo.javabasic.concurrent.concurrentbook.chapter4;

import com.janguo.javabasic.concurrent.concurrentbook.utils.SleepUtils;

/**
 * // BlockedThread-2线程阻塞在获取Blocked.class示例的锁上
 * "BlockedThread-2" #13 prio=5 os_prio=31 tid=0x00007fb73d059800 nid=0x5803 waiting for monitor entry [0x0000700003995000]
 *    java.lang.Thread.State: BLOCKED (on object monitor)
 * 	at com.janguo.javabasic.concurrent.concurrentbook.chapter4.ThreadState$Blocked.run(ThreadState.java:49)
 * 	- waiting to lock <0x000000076ab7f6d8> (a java.lang.Class for com.janguo.javabasic.concurrent.concurrentbook.chapter4.ThreadState$Blocked)
 * 	at java.lang.Thread.run(Thread.java:748)
 *
 * // BlockedThread-1线程获取到了Blocked.class的锁
 * "BlockedThread-1" #12 prio=5 os_prio=31 tid=0x00007fb73d059000 nid=0xa703 waiting on condition [0x0000700003892000]
 *    java.lang.Thread.State: TIMED_WAITING (sleeping)
 * 	at java.lang.Thread.sleep(Native Method)
 * 	at java.lang.Thread.sleep(Thread.java:340)
 * 	at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
 * 	at com.janguo.javabasic.concurrent.concurrentbook.utils.SleepUtils.sleep(SleepUtils.java:8)
 * 	at com.janguo.javabasic.concurrent.concurrentbook.chapter4.ThreadState$Blocked.run(ThreadState.java:49)
 * 	- locked <0x000000076ab7f6d8> (a java.lang.Class for com.janguo.javabasic.concurrent.concurrentbook.chapter4.ThreadState$Blocked)
 * 	at java.lang.Thread.run(Thread.java:748)
 *
 * // WaitingThread线程在Waiting实例上等待
 * "WaitingThread" #11 prio=5 os_prio=31 tid=0x00007fb73d058000 nid=0x5603 in Object.wait() [0x000070000378f000]
 *    java.lang.Thread.State: WAITING (on object monitor)
 * 	at java.lang.Object.wait(Native Method)
 * 	- waiting on <0x000000076ab7c570> (a java.lang.Class for com.janguo.javabasic.concurrent.concurrentbook.chapter4.ThreadState$Waiting)
 * 	at java.lang.Object.wait(Object.java:502)
 * 	at com.janguo.javabasic.concurrent.concurrentbook.chapter4.ThreadState$Waiting.run(ThreadState.java:34)
 * 	- locked <0x000000076ab7c570> (a java.lang.Class for com.janguo.javabasic.concurrent.concurrentbook.chapter4.ThreadState$Waiting)
 * 	at java.lang.Thread.run(Thread.java:748)
 * // TimeWaitingThread线程处于超时等待
 * "TimeWaitingThread" #10 prio=5 os_prio=31 tid=0x00007fb73d057800 nid=0x5503 waiting on condition [0x000070000368c000]
 *    java.lang.Thread.State: TIMED_WAITING (sleeping)
 * 	at java.lang.Thread.sleep(Native Method)
 * 	at java.lang.Thread.sleep(Thread.java:340)
 * 	at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
 * 	at com.janguo.javabasic.concurrent.concurrentbook.utils.SleepUtils.sleep(SleepUtils.java:8)
 * 	at com.janguo.javabasic.concurrent.concurrentbook.chapter4.ThreadState$TimeWaiting.run(ThreadState.java:21)
 * 	at java.lang.Thread.run(Thread.java:748)
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waiting(),"WaitingThread").start();
        // 使用两个Bocked线程，一个获取锁成功，另外一个被阻塞
        new Thread(new Blocked(),"BlockedThread-1").start();
        new Thread(new Blocked(),"BlockedThread-2").start();

    }

    // 该线程不断地进行休眠
    static class TimeWaiting implements Runnable{
        @Override
        public void run() {
            while (true){
                    SleepUtils.sleep(100);
            }
        }
    }

    // 该线程在Waiting.class实例上等待
    static class Waiting implements Runnable{

        @Override
        public void run() {
            while(true){
                synchronized(Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 该线程在 Blocked.class实例上加锁后，不会释放该锁
    static class Blocked implements Runnable{

        @Override
        public void run() {
            synchronized(Blocked.class){
                SleepUtils.sleep(100);
            }
        }
    }
}
