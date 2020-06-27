package com.janguo.javabasic.concurrent.executor;

import com.janguo.javabasic.concurrent.concurrentbook.utils.SleepUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ExecutorCompletionService 解决因错误获取较长时间的返回结果而阻塞
 */
public class ComplexExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
/**
        List<Future<?>> futures = new ArrayList<>();
        List<Runnable> tasks = IntStream.rangeClosed(0, 6).boxed().map(ComplexExample::toTask).collect(Collectors.toList());

        tasks.forEach(runnable -> {
            Future<?> future = fixedThreadPool.submit(runnable);
            futures.add(future);
        });

        for (int i = futures.size()-1; i > 0; i--) {
            futures.get(i).get(); // 可能会出现 执行时间长的任务，可能会阻塞其他执行时间短的线程
                                    // 解决方法一 使用ExecutorCompletionService()
            System.out.println("------------");
        }
 */


        ExecutorCompletionService<Object> completionService = new ExecutorCompletionService<Object>(fixedThreadPool);

        List<Runnable> tasks = IntStream.rangeClosed(0, 6).boxed().map(ComplexExample::toTask).collect(Collectors.toList());
        tasks.forEach(runnable -> {
            completionService.submit(Executors.callable(runnable));
        });

        Future<Object> future ;
        while ((future = completionService.take())!= null){
            System.out.println(future.get());
        }


        System.out.println("----------------");

    }

    private static Runnable toTask(int i) {
        return () -> {
            System.out.printf("The Task [%d] will be executor!\n", i);
            SleepUtils.sleep(i * 5 + 10);
            System.out.printf("The Task [%d] executor end!\n", i);
        };
    }
}
