package com.janguo.javabasic.concurrent.thread.productconsume;

import java.util.stream.Stream;

public class Test {

    private int i = 0;
    private boolean isProduced = false;
    private final Object LOCK = new Object();

    public void product() throws InterruptedException {
        synchronized (LOCK) {
            if (!isProduced) {
                i++;
                System.out.println("Produce: " + i);
                LOCK.notify();
                isProduced = true;
            } else {
                LOCK.wait();
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (LOCK) {
            if (isProduced){
                System.out.println("Consumer : " +i);
                isProduced = false;
                LOCK.notify();
            }else {
                LOCK.wait();
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        Stream.of("P1","P2").forEach(n->{
            new Thread(){
                @Override
                public void run() {
                    while (true) {
                        try {
                            test.product();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        });

        Stream.of("T1","T2").forEach(n->{
            new Thread(){
                @Override
                public void run() {
                    while (true) {
                        try {
                            test.consumer();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        });
    }
}
