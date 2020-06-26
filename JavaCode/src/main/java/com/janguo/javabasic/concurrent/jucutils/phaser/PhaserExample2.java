package com.janguo.javabasic.concurrent.jucutils.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserExample2 {
    private final static Random r = new Random(System.currentTimeMillis());
    public static void main(String[] args) {

        Phaser phaser = new Phaser(5);
        for (int i = 1; i < 6; i++) {
            new Athletes(i,phaser).start();
        }
    }

    static class Athletes extends Thread{
        private final int number;
        private final Phaser phaser;

        public Athletes(int number, Phaser phaser) {
            this.number = number;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                System.out.println("["+number+"] is Start Running ！");
                TimeUnit.SECONDS.sleep(r.nextInt(5));
                System.out.println("["+number+"] is End Running ！");
                System.out.println("phaser.getPhase()=>"+phaser.getPhase());
                phaser.arriveAndAwaitAdvance();

                System.out.println("["+number+"] is Start Bicycle ！");
                TimeUnit.SECONDS.sleep(r.nextInt(5));
                System.out.println("["+number+"] is End Bicycle ！");
                System.out.println("phaser.getPhase()=>"+phaser.getPhase());
                phaser.arriveAndAwaitAdvance();

                System.out.println("["+number+"] is Start Long Jump ！");
                TimeUnit.SECONDS.sleep(r.nextInt(5));
                System.out.println("["+number+"] is End Long Jump ！");
                System.out.println("phaser.getPhase()=>"+phaser.getPhase());
                phaser.arriveAndAwaitAdvance();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
