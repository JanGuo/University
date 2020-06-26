package com.janguo.javabasic.concurrent.jucutils.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 动态增加
 */
public class PhaserExample1 {
    private static final Random r = new Random(System.currentTimeMillis());
    public static void main(String[] args) {

        final Phaser phaser= new Phaser();
        IntStream.rangeClosed(1,5).boxed().map(integer -> phaser).forEach(Task::new);

        phaser.register();
        phaser.arriveAndAwaitAdvance();

        System.out.println("ALL Work is Finished!");

    }
    static class Task extends Thread{
        private final Phaser phaser;

        Task(Phaser phaser) {
            this.phaser = phaser;
            phaser.register();
            start();
        }

        @Override
        public void run() {
            System.out.println(getName() + "： is Working!");
            try {
                TimeUnit.SECONDS.sleep(r.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "： Worked!");
            phaser.arriveAndAwaitAdvance();
        }
    }
}
