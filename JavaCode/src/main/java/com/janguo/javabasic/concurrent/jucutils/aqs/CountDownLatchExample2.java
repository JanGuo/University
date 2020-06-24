package com.janguo.javabasic.concurrent.jucutils.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/**
 * 第一个线程需要执行部分操作后，
 * 需要另外一个线程执行某部分操作后才能继续执行。
 * name就可以使用CountDownLatch。
 *
 * 这是CountDownLatch的另外一个应用场景
 */
public class CountDownLatchExample2 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"---Doing Something!");
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"---Down 「One」 Part Mission! ");
                System.out.println(Thread.currentThread().getName()+"---Wait Other Thread Execute Finnish! ");
                latch.await();
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"---Down 「Two」 Part Mission! ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"---Doing Something!");
            try {
                TimeUnit.SECONDS.sleep(4);
                System.out.println(Thread.currentThread().getName()+"---Down All Mission! For Other Thread!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                latch.countDown();
            }

        }).start();
    }
}
