package com.janguo.javabasic.concurrent.atomic.atomicboolean;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanFlag {

    private final static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (flag.get()){
                try {
                    Thread.sleep(200);
                    System.out.println("I'm WORKING!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread will EXIT!");
        }).start();
        Thread.sleep(5000);
        flag.set(false);
    }

}
