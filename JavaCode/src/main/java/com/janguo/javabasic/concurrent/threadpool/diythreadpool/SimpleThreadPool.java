package com.janguo.javabasic.concurrent.threadpool.diythreadpool;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
public class SimpleThreadPool {
    private final int SIZE;

    private final int QUEUE_SIZE;

    private final static int DEFAULT_SIZE = 10;

    private final static int DEFAULT_TASK_QUEUE_SIZE = 2000;

    private volatile int seq = 0;

    private final static String THREAD_PREFIX = "Simple_Thread_Pool-";

    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private final static List<WorKThread> THREAD_QUEUE = new ArrayList<>();

    private final DiscardPolicy discardPolicy;

    private volatile boolean destroy = false;

    public SimpleThreadPool() {
        this(DEFAULT_SIZE, DEFAULT_TASK_QUEUE_SIZE, () -> {
            throw new DiscardException("Discard this task");
        });
    }

    public SimpleThreadPool(int size, int queueSize, DiscardPolicy discardPolicy) {
        this.discardPolicy = discardPolicy;
        this.SIZE = size;
        this.QUEUE_SIZE = queueSize;
        init();
    }

    public int getSIZE() {
        return SIZE;
    }

    public int getQUEUE_SIZE() {
        return QUEUE_SIZE;
    }

    public boolean destroy() {
        return this.destroy;
    }

    private void init() {
        for (int i = 0; i < SIZE; i++) {
            creatWorkThread();
        }
    }

    public void submit(Runnable runnable) {
        if (destroy){
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

        int initVal = THREAD_QUEUE.size();
        while (initVal > 0) {
            for (WorKThread task : THREAD_QUEUE) {
                if (task.getTaskState() == TaskState.BLOCKED) {
                    task.interrupt();
                    task.close();
                    initVal--;
                } else {
                    Thread.sleep(100);
                }
            }
        }
        Optional.of("The thread pool disposed!").ifPresent(System.out::println);
        this.destroy = true;
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
