package com.janguo.javabasic.lambda.streamtest;

public class LambdaTest {
    Runnable r1 = ()-> System.out.println(this);
    Runnable r2 = new Runnable(){

        @Override
        public void run() {
            System.out.println(this);
        }
    };

    public static void main(String[] args) throws InterruptedException {
        LambdaTest lambdaTest = new LambdaTest();

        Thread thread = new Thread(lambdaTest.r1);
        thread.start();

        Thread.sleep(100);
        Thread thread1 = new Thread(lambdaTest.r2);

        thread1.start();
    }
}
