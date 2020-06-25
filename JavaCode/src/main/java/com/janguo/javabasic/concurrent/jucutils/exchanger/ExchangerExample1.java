package com.janguo.javabasic.concurrent.jucutils.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerExample1 {
    public static void main(String[] args) {

        // 两个线程之间相互交换数据
        /**
        Note: 1. 使用带超时事件的exchanger方法的时候，注意与他配对的线程可能会阻塞住
              2. 使用{@link Exchanger}的时候必须成对出现
         */
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"Staring!");
            String result = null;
            try {
                result = exchanger.exchange("Date: I form T-A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"Get:「"+result+"」");
        },"--A--").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"Staring!");
            String result = null;
            try {
                TimeUnit.SECONDS.sleep(20);
                result = exchanger.exchange("Date: I form T-B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"Get:「"+result+"」");
        },"--B--").start();
    }

}
