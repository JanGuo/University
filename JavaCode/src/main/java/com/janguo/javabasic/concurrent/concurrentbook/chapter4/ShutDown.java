package com.janguo.javabasic.concurrent.concurrentbook.chapter4;

import com.janguo.javabasic.concurrent.concurrentbook.utils.SleepUtils;

/**
 * main线程通过中断操作和cancel()方法均可使CountThread得以终止。
 * 这种通过标识位或者中断操作的方式能够使线程在终止时有机会去清理资源，
 * 而不是武断地将线程停止，因此这种终止线程的做法显得更加安全和优雅。
 */
public class ShutDown {
    public static void main(String[] args) {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();

        SleepUtils.sleep(2);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();

        SleepUtils.sleep(2);
        two.cancel();

    }

    private static class Runner implements Runnable {
        private long i = 0;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);

        }

        public void cancel() {
            on = false;
        }
    }
}