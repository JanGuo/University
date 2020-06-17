package com.janguo.javabasic.concurrent.thread;

import java.util.*;
import java.util.stream.Stream;

/**
 * 该类实现了一批任务，由是个并发线程工作，同时运行的线程为5个  全部任务执行完毕后由主线程将所得数据提交数据库（代码中未完善）
 * 当其中有一个线程结束后，另外一个线程开始工作
 * 使用了一些基本的方法实现的此功能
 * 1. join 等待创建的线程结束后，主线程提交数据库
 * 2. wait 释放CPU资源 等待其他线程唤醒
 * 3. notifyAll 唤醒其他的等待线程
 */
public class CaptureService {
    // 用于统计存在线程个数的数组 使用LinkedList 为了移除已执行完毕的线程个数方便一些
    final static private LinkedList<Count> COUNTS = new LinkedList<>();
    // 同时工作的线程个数
    private static final int MAC_WORKED = 5;
    public static void main(String[] args) {
        // 用于存储由Java8中流式编程产生的线程
        List<Thread> worker = new ArrayList<>();
        // 使用流式编程 创建和启动线程 并将创建出的线程 春放到List当中
        Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10")
                .stream().map(CaptureService::creatThread)
                .forEach(n->{
                    n.start();
                    worker.add(n);
                });
        // 遍历List中的线程，并将其join到Main线程中，是Main等待所有线程完成后继续执行
        worker.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Optional.of("All of Capture work is Finished").ifPresent(System.out::println);

    }

    /**
     * 用于创建线程的方法 一个输入一个输出 --> 用于Stream中的Map 映射
     * @param name 需要创建的线程的名字
     * @return 所创建的线程对象
     */
    private static Thread creatThread(String name){
        return new Thread(()->{
            Optional.of("The Worker --"+Thread.currentThread().getName()+" --   BEGIN Capture data").ifPresent(System.out::println);
            synchronized (COUNTS) {
                // 如果用于统计个数的LinkList的个数达到所要求的个数，那么进入等待状态
                while (COUNTS.size() > MAC_WORKED) {
                    try {
                        COUNTS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 如果没有到达上限 创建线程后，将统计个数加一
                COUNTS.add(new Count());
            }
            Optional.of("The Worker --"+Thread.currentThread().getName()+" --   WORKING!!!!").ifPresent(System.out::println);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (COUNTS){
                Optional.of("The Worker --"+Thread.currentThread().getName()+" --   END Capture data").ifPresent(System.out::println);
                // 线程执行完毕后 统计个数减一
                COUNTS.removeFirst();
                // 通知其他线程执行任务
                COUNTS.notifyAll();
            }
        },name);
    }

    static class Count{}
}
