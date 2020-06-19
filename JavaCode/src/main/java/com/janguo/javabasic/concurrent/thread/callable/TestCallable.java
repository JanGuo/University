package com.janguo.javabasic.concurrent.thread.callable;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) {

        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> result = new FutureTask<>(callableDemo);
        new Thread(result).start();
        try {
            Integer sum = result.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallableDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0;i<=100;i++){
            sum += i;
        }
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5_000);
        return sum;
    }
}
