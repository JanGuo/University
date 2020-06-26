package com.janguo.javabasic.concurrent.concurrentbook.chapter4;

import com.janguo.javabasic.concurrent.concurrentbook.utils.SleepUtils;

public class Profiler {
    private final static ThreadLocal<Long> TIME_THREAD_LOCAL = new ThreadLocal<Long>(){
        // 第一次get()方法调用时会进行初始化(如果set方法没有调用)，每个线程会调用一次
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };


    public static void begin(){
        TIME_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    public static long end(){
        return System.currentTimeMillis() - TIME_THREAD_LOCAL.get();
    }

    public static void main(String[] args) {
        Profiler.begin();
        SleepUtils.sleep(1);

        System.out.println("Cost: " + Profiler.end() + " mills");
    }
}
