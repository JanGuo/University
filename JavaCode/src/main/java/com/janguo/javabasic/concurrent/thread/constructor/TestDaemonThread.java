package com.janguo.javabasic.concurrent.thread.constructor;

public class TestDaemonThread {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

            Thread inDaemonThread = new Thread(() -> {
                while (true)
                System.out.println("inDaemonThread is Running!");
            });
            inDaemonThread.start();
            while (true) {
                System.out.println("Daemon Thread Running!");
            }
        });

        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
