package com.janguo.javabasic.concurrent.concurrentbook.chapter4;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Job priority: 1, Count: 2729191
 * Job priority: 1, Count: 2791720
 * Job priority: 1, Count: 2808965
 * Job priority: 1, Count: 2739110
 * Job priority: 1, Count: 2752568
 * Job priority: 10, Count: 2909391
 * Job priority: 10, Count: 2813709
 * Job priority: 10, Count: 2746462
 * Job priority: 10, Count: 2792195
 * Job priority: 10, Count: 2928988
 * 从输出可以看到线程优先级没有生效，优先级1和优先级10的Job计数的结果非常相近，
 * 没有明显差距。这表示程序正确性不能依赖线程的优先级高低。
 *
 *
 *
 *  线程优先级不能作为程序正确性的依赖，因为操作系统可以完全不用理会Java 线程对于优先级的设定。
 *  该环境下所有Java线程优先级均为5(通过jstack查看)，对线程优先级的设置会被忽略。
 *  另外， 尝试在Ubuntu 14.04环境下运行该示例，输出结果也表示该环境忽略了线程优先级的设置。
 */
public class PriorityTest {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }

        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;
        for (Job job : jobs) {
            System.out.println("Job priority: "+job.priority+", Count: "+job.jobCount);
        }

    }

    static class Job implements Runnable {

        private int priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }
}
