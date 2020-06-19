package com.janguo.javabasic.concurrent.thread.synchroniz;

public class MainExecute {
    public static void main(String[] args) {
//        MyJobBlockRunner runner = new MyJobBlockRunner();
//        MyJobMethodRunner runner = new MyJobMethodRunner();

        MyJobMethodRunnerComplete runner = new MyJobMethodRunnerComplete();
        Thread thread1 = new Thread(runner);
        Thread thread2 = new Thread(runner);
        Thread thread3 = new Thread(runner);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
