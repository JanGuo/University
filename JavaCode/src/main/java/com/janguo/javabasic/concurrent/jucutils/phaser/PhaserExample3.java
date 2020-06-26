package com.janguo.javabasic.concurrent.jucutils.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 *  arriveAndDeregister(); 方法取消注册
 */
public class PhaserExample3 {
    private final static Random r = new Random(System.currentTimeMillis());

    public static void main(String[] args) {

        Phaser phaser = new Phaser(5);
        for (int i = 1; i < 5; i++) {
            new PhaserExample3.Athletes(i, phaser).start();
        }
        new InjuredAthletes(5,phaser).start();

    }

    static class InjuredAthletes extends Thread{
        private final int number;
        private final Phaser phaser;

        public InjuredAthletes(int number, Phaser phaser) {
            this.number = number;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                sport(number, phaser, "] is Start Running ！", "] is End Running ！");

                sport(number, phaser, "] is Start Bicycle ！", "] is End Bicycle ！");

//                System.out.println("Oh , Shit ,I am injured!");
                System.out.println("Oh , Shit ,I am injured!, I will be Exit!");
                phaser.arriveAndDeregister();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Athletes extends Thread {
        private final int number;
        private final Phaser phaser;

        public Athletes(int number, Phaser phaser) {
            this.number = number;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                sport(number, phaser, "] is Start Running ！", "] is End Running ！");

                sport(number, phaser, "] is Start Bicycle ！", "] is End Bicycle ！");

                sport(number, phaser, "] is Start Long Jump ！", "] is End Long Jump ！");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void sport(int number, Phaser phaser, String s, String s2) throws InterruptedException {
        System.out.println("[" + number + s);
        TimeUnit.SECONDS.sleep(r.nextInt(5));
        System.out.println("[" + number + s2);
        phaser.arriveAndAwaitAdvance();
    }
}
