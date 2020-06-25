package com.janguo.javabasic.concurrent.concurrentbook.chapter4;

import com.janguo.javabasic.concurrent.concurrentbook.utils.SleepUtils;

public class Interrupted {

    public static void main(String[] args) {
        // sleepThread 不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunnable(), "SleepThread");
        sleepThread.setDaemon(true);
        // busyThread 不停的运行
        Thread busyThread = new Thread(new BusyRunnable(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();
        // 休眠5秒，是sleepThread和busyThread充分运行
        SleepUtils.sleep(5);

        busyThread.interrupt();
        sleepThread.interrupt();


        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread  interrupted is " + sleepThread.isInterrupted());
        // 防止sleepThread和busyThread立刻退出
        SleepUtils.sleep(2);
    }


    static class SleepRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.sleep(10);
            }
        }
    }

    static class BusyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }
}
