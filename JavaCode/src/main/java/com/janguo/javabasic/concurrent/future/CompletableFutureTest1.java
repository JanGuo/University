package com.janguo.javabasic.concurrent.future;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureTest1 {
    public static void main(String[] args) throws InterruptedException {
//        CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).whenComplete((aVoid, throwable) -> {
//            System.out.println("----GET Result!---");
//        });
//        Thread.currentThread().join();
/*
        ExecutorService service = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> tasks = IntStream.rangeClosed(0, 10).boxed()
                .map(integer -> (Callable<Integer>) CompletableFutureTest1::get)
                .collect(Collectors.toList());
        List<Future<Integer>> futureList = service.invokeAll(tasks);

        futureList.stream().map(integerFuture -> {
            try {
                return integerFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                throw  new RuntimeException(e);
            }
        }).parallel().forEach(CompletableFutureTest1::display);
*/

        IntStream.rangeClosed(0, 9).boxed()
                .forEach(integer -> CompletableFuture.supplyAsync(CompletableFutureTest1::get)
                        .thenAccept(CompletableFutureTest1::display)
                        .whenComplete((aVoid, throwable) ->  System.out.println(integer + " --- DOWN!")));

        Thread.currentThread().join();
    }

    private static void display(int data) {
        int value = ThreadLocalRandom.current().nextInt(20);
        try {
            System.out.println(Thread.currentThread().getName() + "Display Will Sleeping!" + value);
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "Will END! GET DATA --- " + data);
    }

    private static int get() {
        int value = ThreadLocalRandom.current().nextInt(20);
        try {
            System.out.println(Thread.currentThread().getName() + "Will Sleeping!" + value);
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "Will END!");
        return value;

    }
}
