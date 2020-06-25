package com.janguo.javabasic.concurrent.jucutils.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DiyCallBackCountDownLatch {

    public static void main(String[] args) {
        DiyCountDownLatch diyCountDownLatch = new DiyCountDownLatch(2,()->{
            System.out.println("All Mission is Finished!");
        });

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                diyCountDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+" -- is Finished!" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
                diyCountDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+" -- is Finished!" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    static class DiyCountDownLatch extends CountDownLatch {
        private Runnable runnable;
        public DiyCountDownLatch(int count , Runnable runnable) {
            super(count);
            this.runnable = runnable;
        }
        public void countDown() {
            super.countDown();
            if (getCount() == 0){
                runnable.run();
            }
        }

    }
}
