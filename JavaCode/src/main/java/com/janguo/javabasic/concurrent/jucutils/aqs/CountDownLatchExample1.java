package com.janguo.javabasic.concurrent.jucutils.aqs;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLarch的第一个用法：
 * 用于中间需要多个线程来执行任务
 * 最后主线程收到所有任务执行完毕后进行后续任务
 */
public class CountDownLatchExample1 {

    private static Random random = new Random(System.currentTimeMillis());

    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    private static final CountDownLatch latch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        // 获取任务内容
        int[] data = getDateSource();

        // 执行任务逻辑
        for (int i = 0; i < data.length; i++) {
            executor.execute(new DataDealRunnable(data, i, latch));
        }
        // 任务执行结束后 继续进行
        latch.await();
        System.out.println("主线程：" + Thread.currentThread().getName() + "ShutDown!");
        // 手到所有任务执行结束后的指令，进行后续操作
        executor.shutdown();

    }


    static class DataDealRunnable implements Runnable {

        private final int[] data;
        private final int index;
        private final CountDownLatch latch;

        DataDealRunnable(int[] data, int index, CountDownLatch latch) {
            this.data = data;
            this.index = index;
            this.latch = latch;
        }

        @Override
        public void run() {

            try {
                TimeUnit.SECONDS.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int value = data[index];
            if (data[index] % 2 == 0) {
                data[index] = value * 2;
            } else {
                data[index] = value + 10;
            }
            latch.countDown();
            System.out.println("执行线程：" + Thread.currentThread().getName() + "---ShutDown!");
        }
    }

    public static int[] getDateSource() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }
}
