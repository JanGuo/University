package com.janguo.javabasic.concurrent.thread.synchroniz;

public class MyJobMethodRunner implements Runnable{

    private int index = 1;
    @Override
    public synchronized void run() {
        int MAX = 500;
        while (true){

            if (index>500){
                break;
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "第"+(index++) +"票");
        }
    }
}
