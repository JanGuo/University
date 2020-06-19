package com.janguo.javabasic.concurrent.threadpool.diythreadpool;

import lombok.SneakyThrows;

import java.util.*;

/**
 * 1. 任务队列 -> 用于存放等待执行的任务
 * 2. 拒绝策略 -> 拒绝自己不想接受的任务（抛出异常，直接丢弃，阻塞，临时队列）
 * 3. Init
 * 4. Active
 * 5. Max
 * <p>
 * Min <= Active <= Max
 * <p>
 * 编写步骤
 * 1. 定义和初始化线程队列的大小 （如果未提供线程池大小，则默认使用 10 ）
 * 2. 创建SimplePool的时候初始化 线程池 init 方法
 * init  -  创建Size个自己封装的WorkThread线程
 * -  启动创建的WorkThread线程  ----如果有任务， 执行任务中的任务
 * -  添加到线程队列当中
 * 3. 编写WorkThread类
 * 定义了一个stats枚举，用于标识线程状态
 * 编写构造方法，参数线程组，线程名
 * 重写Run方法
 * 如果这个线程不是DEAD状态
 * 线程队列中 没有 需要执行的任务 则将线程状态设为BLOCKED状态
 * 如果 有   需要执行的任务 则取出队列中的第一个任务 设置线程状态为RUNNING状态 执行第一个任务，执行完毕后将线程状态设置为FREE状态
 * 4. 编写提交任务方法
 * - 添加任务到队列中
 * - 通知其他处于等待状态的线程 执行任务
 */
public class SimpleThreadPool extends Thread {

    // 线程池当前线程个数
    private int size;

    // 待提交任务队列 大小
    private final int QUEUE_SIZE;

    // 默认线程池大小 废弃
    private final static int DEFAULT_SIZE = 10;

    // 最小线程池大小
    private int min;

    //
    private int active;

    // 最大线程池个数
    private int max;

    // 默认任务队列大小
    private final static int DEFAULT_TASK_QUEUE_SIZE = 200;

    // 线程名 后缀
    private volatile int seq = 0;

    // 线程名前缀
    private final static String THREAD_PREFIX = "Simple_Thread_Pool-";

    // 线程 默认线程组
    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    // 任务队列
    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    // 线程 存放数组
    private final static List<WorKThread> THREAD_QUEUE = new ArrayList<>();

    // 拒绝策略
    private final DiscardPolicy discardPolicy;

    // 是否销毁
    private volatile boolean destroy = false;

    public SimpleThreadPool() {
        this(4, 8, 12, DEFAULT_TASK_QUEUE_SIZE, () -> {
            throw new DiscardException("Discard this task");
        });
    }

    public SimpleThreadPool(int min, int active, int max, int queueSize, DiscardPolicy discardPolicy) {
        this.discardPolicy = discardPolicy;
        this.min = min;
        this.active = active;
        this.max = max;
        this.QUEUE_SIZE = queueSize;
        init();
    }

    @Override
    public void run() {
        while (!destroy) {
            System.out.printf("Pool#MIN: [%d] ,Active: [%d] ,MAX: [%d] ,此线程池线程个数: [%d] ,当前QueueSize中: [%d] \n",
                    this.min, this.active, this.max, this.size, TASK_QUEUE.size());
            try {
                Thread.sleep(10_000);
                if (TASK_QUEUE.size() > active && size < active) {
                    for (int i = size; i < active; i++) {
                        creatWorkThread();
                    }
                    size = active;
                    System.out.println("以扩充线程池大小到" + size);
                } else if (TASK_QUEUE.size() > max && size < max) {
                    for (int i = size; i < max; i++) {
                        creatWorkThread();
                    }
                    size = max;
                    System.out.println("以扩充线程池大小到" + size);
                }
                if (TASK_QUEUE.isEmpty() && size > active) {
                     synchronized (THREAD_QUEUE) {
                        int releaseSize = size - active;

                        for (Iterator<WorKThread> iterator = THREAD_QUEUE.iterator(); iterator.hasNext(); ) {
                            if (releaseSize <= 0) break;
                            WorKThread worKThread = iterator.next();

                            if (worKThread.taskState != TaskState.RUNNING) {
                                worKThread.close();
                                worKThread.interrupt();
                                iterator.remove();
                                releaseSize--;
                            }// 如果是运行状态 什么都不做 那么THREAD_QUEUE中 还是会有未关闭的线程
                            // 可以使用ThreadGroup来处理
                            System.out.println("FOM FOR GROUP中的线程数"+GROUP.activeCount());
                        }
                        size = active;
                        System.out.println("缩小线程池大小到" + size);
                    }
                }
                System.out.println("GROUP中的线程数"+GROUP.activeCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isDestroy() {
        return this.destroy;
    }

    private void init() {
        for (int i = 0; i < this.min; i++) {
            creatWorkThread();
        }

        this.size = this.min;
        this.start();

    }

    public void submit(Runnable runnable) {
        if (destroy) {
            throw new IllegalStateException("The Pool has destroy can't submit");
        }
        synchronized (TASK_QUEUE) {
            if (TASK_QUEUE.size() >= QUEUE_SIZE)
                discardPolicy.discard();
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    private void creatWorkThread() {
        WorKThread worKThread = new WorKThread(GROUP, THREAD_PREFIX + (seq++));
        worKThread.start();
        THREAD_QUEUE.add(worKThread);
    }

    public void shutdown() throws InterruptedException {
        while (!TASK_QUEUE.isEmpty()) {
            Thread.sleep(100);
        }
        synchronized (THREAD_QUEUE){

            int initVal = THREAD_QUEUE.size();
            while (initVal > 0) {
                //synchronized (TASK_QUEUE){
                for (WorKThread task : THREAD_QUEUE) {
                    if (task.getTaskState() == TaskState.BLOCKED) {
                        task.interrupt();
                        task.close();
                        initVal--;
                        System.out.println("FROM SHUTDOWN GROUP中的线程数"+GROUP.activeCount());
                    } else {
                        Thread.sleep(100);
                    }
                }
        }

            //}
        }
        Optional.of("The thread pool disposed!").ifPresent(System.out::println);
        this.destroy = true;
    }


    public int getSize() {
        return size;
    }

    public int getQUEUE_SIZE() {
        return QUEUE_SIZE;
    }

    public int getMin() {
        return min;
    }

    public int getActive() {
        return active;
    }

    public int getMax() {
        return max;
    }

    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    private static class WorKThread extends Thread {


        private volatile TaskState taskState = TaskState.FREE;


        public WorKThread(ThreadGroup group, String threadName) {
            super(group, threadName);
        }

        public TaskState getTaskState() {
            return taskState;
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }
                if (runnable != null) {
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }


        }


    }
}
