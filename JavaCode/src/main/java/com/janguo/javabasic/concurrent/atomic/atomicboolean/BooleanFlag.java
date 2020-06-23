package com.janguo.javabasic.concurrent.atomic.atomicboolean;

public class BooleanFlag {
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        /**
         * public void println(String x) {
         *         synchronized (this) {
         *             print(x);
         *             newLine();
         *         }
         *     }
         *
         * Thread.sleep(2000);
         * JVN会尽可能的确保变量的可见性
         * 只要有时间就会去刷新缓存的变量
         * 调用sleep是cpu有空余时间，JVM会利用来刷新变量
         */
        new Thread(()->{
            while (flag){
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                // System.out.println("WORKING!");
            }
        }).start();

        Thread.sleep(2000);
        System.out.println("-------");
        flag = false;
    }
}
