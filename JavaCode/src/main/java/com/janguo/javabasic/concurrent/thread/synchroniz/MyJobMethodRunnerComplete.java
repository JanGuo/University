package com.janguo.javabasic.concurrent.thread.synchroniz;

public class MyJobMethodRunnerComplete implements Runnable{
    private int index = 1;
    private final int MAX = 500;

    @Override
    public void run() {
        while (true){
            if (!do0()){
                break;
            }

        }
    }

    public synchronized boolean do0(){
        if (index>MAX){
            return false;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "第"+(index++) +"票");
        return true;
    }
}
