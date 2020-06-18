package com.janguo.javabasic.concurrent.threadpool.diythreadpool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 编写步骤
 * 1. 定义和初始化线程队列的大小 （如果未提供线程池大小，则默认使用 10 ）
 * 2. 创建SimplePool的时候初始化 线程池 init 方法
 *     init  -  创建Size个自己封装的WorkThread线程
 *           -  启动创建的WorkThread线程  ----如果有任务， 执行任务中的任务
 *           -  添加到线程集合当中
 *     3. 编写WorkThread类
 *          定义了一个stats枚举，用于标识线程状态
 *          编写构造方法，参数线程组，线程名
 *          重写Run方法
 *              如果这个线程不是DEAD状态
 *                  线程队列中 没有 需要执行的任务 则将线程状态设为BLOCKED状态
 *                       如果 有   需要执行的任务 则取出队列中的第一个任务 设置线程状态为RUNNING状态 执行第一个任务，执行完毕后将线程状态设置为FREE状态
 * 4. 编写提交任务方法
 *          - 添加任务到队列中
 *          - 通知其他处于等待状态的线程 执行任务
 */
public class MySelfPool {
    private final static int SIZE = 10;
    private int poolSize;
    private volatile int number = 0;
    private final String THREAD_NAME = "MySelfPool-";
    private final ThreadGroup threadGroup = new ThreadGroup("SelfPoolGroup");

    private final LinkedList<Runnable> QUEUE= new LinkedList<>();

    private List<SelfTread> treadList = new ArrayList<>();

    public MySelfPool() {
        this(SIZE);
    }

    public MySelfPool(int poolSize) {
        this.poolSize = poolSize;
        init();
    }

    private void init() {
        for (int i = 0; i < poolSize; i++) {
            SelfTread selfTread = new SelfTread(threadGroup, THREAD_NAME + (number++));
            selfTread.start();
            treadList.add(selfTread);
        }

    }

    public void submit(Runnable runnable){
        synchronized (QUEUE){
            QUEUE.addLast(runnable);
            QUEUE.notifyAll();
        }
    }

    private enum ThreadState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    private class SelfTread extends Thread {
        private ThreadState threadState = ThreadState.FREE;


        protected SelfTread(ThreadGroup threadGroup, String name) {
            super(threadGroup, name);
        }

        @Override
        public void run() {
            OUTER:
            while (this.threadState != ThreadState.DEAD){
                Runnable runnable;
                synchronized (QUEUE){
                    if (QUEUE.isEmpty()){
                        this.threadState = ThreadState.BLOCKED;
                        try {
                            QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    runnable = QUEUE.removeFirst();
                }

                if (runnable != null){
                    threadState = ThreadState.RUNNING;
                    runnable.run();
                    threadState = ThreadState.FREE;
                }
            }
        }
    }
}
