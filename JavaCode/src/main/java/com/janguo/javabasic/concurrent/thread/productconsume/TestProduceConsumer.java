package com.janguo.javabasic.concurrent.thread.productconsume;

import java.util.stream.Stream;

public class TestProduceConsumer {

    private int i = 0;
    private boolean isProduced = false;
    private final Object LOCK = new Object();

    public void product() throws InterruptedException {
        synchronized (LOCK) {
            while (isProduced) {
                LOCK.wait();
            }
            i++;
            System.out.println("Produce: " + i);
            LOCK.notifyAll();
            isProduced = true;
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (LOCK) {
            while (!isProduced) {
                LOCK.wait();
            }
            System.out.println("Consumer : " + i);
            isProduced = false;
            LOCK.notifyAll();
        }
    }

    public static void main(String[] args) {
        TestProduceConsumer test = new TestProduceConsumer();

        Stream.of("P1", "P2","P3","P4").forEach(n -> {
            new Thread(n) {
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

        Stream.of("T1", "T2","T3","T4").forEach(n -> {
            new Thread(n) {
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
