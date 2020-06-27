package com.janguo.javabasic.concurrent.executor;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ExecutorExample1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();

        // ExecutorCompletionService 关注的是完成的任务 而不是为完成的
        ExecutorCompletionService<Long> completionService = new ExecutorCompletionService<>(service);

        List<Callable<Long>> tasks = LongStream.rangeClosed(0, 6).boxed().map(MyTest::new).collect(Collectors.toList());
        tasks.forEach(completionService::submit);

        TimeUnit.SECONDS.sleep(20);
//        List<Runnable> runnables = service.shutdownNow();
//        runnables.forEach(System.out::println);
        service.shutdownNow();
        tasks.stream().filter(longCallable -> !((MyTest)longCallable).isSuccess()).forEach(System.out::println);
    }

    private static class MyTest  implements Callable<Long>{

        private final Long value;

        private boolean success = false;
        private MyTest(Long value) {
            this.value = value;
        }

        @Override
        public Long call() throws Exception {
            try {
                System.out.printf("The Task [%d] will be executor!\n", value);
                TimeUnit.SECONDS.sleep(value + 5 + 10);
                success = true;
                System.out.printf("The Task [%d] executor end!\n", value);
            } catch (InterruptedException e) {
                System.out.printf("The Task [%d] executor interrupted!\n", value);
            }
            return value;
        }

        public boolean isSuccess() {
            return success;
        }
    }

}
