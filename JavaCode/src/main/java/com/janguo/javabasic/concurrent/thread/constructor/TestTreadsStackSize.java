package com.janguo.javabasic.concurrent.thread.constructor;

public class TestTreadsStackSize {
    private static int count = 0;

    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    add(1);
//                } catch (Error error) {
////                    error.printStackTrace();
//                    System.out.println(count);
//                }
//
//            }
//
//            public void add(int i) {
//                add(i + 1);
//                count++;
//            }
//        });
//        thread.start();

        new Thread(Thread.currentThread().getThreadGroup(),()->{
            System.out.println(Thread.currentThread().getName());
        },"MyThread",111).start();
    }
}
