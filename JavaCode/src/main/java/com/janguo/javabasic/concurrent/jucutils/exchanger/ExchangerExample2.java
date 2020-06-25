package com.janguo.javabasic.concurrent.jucutils.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerExample2 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * exchanger 中传递的是同一个对象并不是Cope的
         */
        // 我的写法
        /*
        Exchanger<String> exchanger = new Exchanger<>();
        final String[] value1 = new String[1];
        String value2 = "Hello2";
        new Thread(()->{
            try {
                value1[0] = exchanger.exchange("Hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                String result = exchanger.exchange(value2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(5);
        if (value1[0].equals(value2)){
            System.out.println("is one!");
        }
        */

        // 视频中的写法
        Exchanger<Object> exchanger = new Exchanger<>();

        new Thread(() -> {
            Object aObj = new Object();
            try {
                System.out.println("A Send    Obj -- " + aObj);
                Object r = exchanger.exchange(aObj);
                System.out.println("A Receive Obj -- " + r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            Object bObj = new Object();
            try {
                System.out.println("B Send Obj -- " + bObj);
                Object r = exchanger.exchange(bObj);
                System.out.println("B Receive Obj -- " + r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
