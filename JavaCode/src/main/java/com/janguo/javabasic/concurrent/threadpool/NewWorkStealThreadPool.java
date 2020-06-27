package com.janguo.javabasic.concurrent.threadpool;

import com.janguo.javabasic.concurrent.concurrentbook.utils.SleepUtils;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewWorkStealThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // ForkJoinPool  执行完所有任务会自动结束
        // SingleThreadPool 不会自动结束
        // FixedThreadPool 也不会自动结束
        // CacheThreadPool 当pool中没有需要执行的任务 之后经过默认时间60S 会自动结束
        ExecutorService workStealingPool = Executors.newWorkStealingPool();
        List<Callable<String>> callableList = IntStream.range(0, 20).boxed().map(integer ->
                (Callable<String>) () -> {
                    System.out.println("Thread: --- " + Thread.currentThread().getName());
                    SleepUtils.sleep(2);
                    return "Task - " + integer;
                }
        ).collect(Collectors.toList());

//        callableList.forEach(workStealingPool::submit);
        List<Future<String>> futures = workStealingPool.invokeAll(callableList);

        futures.stream().map(stringFuture -> {
            try {
                return stringFuture.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).forEach(System.out::println);
    }
}
