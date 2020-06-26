package com.janguo.javabasic.concurrent.jucutils.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinRecursiveTest1 {
    private final static int MAX_THRESHOLD = 200;

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> future = forkJoinPool.submit(new CalculateRecursiveTask(1, 1000));

        try {
            Integer result = future.get();
            System.out.println("计算结果： " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    static class CalculateRecursiveTask extends RecursiveTask<Integer> {

        private final int start;
        private final int end;

        CalculateRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= MAX_THRESHOLD) {
                return IntStream.rangeClosed(start, end).sum();
            } else {
                int middle = (start + end) / 2;
                CalculateRecursiveTask leftTask = new CalculateRecursiveTask(start, middle);
                CalculateRecursiveTask rightTask = new CalculateRecursiveTask(middle + 1, end);

                leftTask.fork();
                rightTask.fork();
                return leftTask.join() + rightTask.join();

            }
        }
    }
}
