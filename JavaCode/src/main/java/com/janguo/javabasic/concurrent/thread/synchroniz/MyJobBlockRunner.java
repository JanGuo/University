package com.janguo.javabasic.concurrent.thread.synchroniz;

public class MyJobBlockRunner implements Runnable{

    private static int index  = 1;
    private final Object object = new Object();
    @Override
    public void run() {
        synchronized (object){
            int MAX = 500;
            while (index< MAX){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "第"+(++index) +"票");
            }
        }
    }


}
