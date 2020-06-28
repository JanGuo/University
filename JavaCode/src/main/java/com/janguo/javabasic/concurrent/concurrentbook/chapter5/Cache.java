package com.janguo.javabasic.concurrent.concurrentbook.chapter5;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * 读写锁
 */
public class Cache {
    static Map<String,Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();


    public static void main(String[] args) throws InterruptedException {
        map.put("A", 5);
        IntStream.rangeClosed(1,10).boxed().forEach(integer -> {
            new Thread(()->{
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.print(Thread.currentThread().getName()+"A --- Value；["+get("A")+"]");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });

        TimeUnit.SECONDS.sleep(10);
        IntStream.rangeClosed(1,2).boxed().forEach(integer -> {
            new Thread(()->{
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println(put("A", 10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });

        TimeUnit.SECONDS.sleep(5);

        clear();
        System.out.println("----Clear-----");
        System.out.println(get("A"));
    }
    public static final Object get(String key){
        r.lock();
        try {
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    public static final Object put(String key,Object value){
        w.lock();
        try{
           return map.put(key, value);
        }finally {
            w.unlock();
        }
    }

    public static final void clear(){
        w.lock();
        try{
            map.clear();
        }finally {
            w.lock();
        }
    }

}
