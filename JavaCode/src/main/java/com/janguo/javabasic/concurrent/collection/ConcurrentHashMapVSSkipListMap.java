package com.janguo.javabasic.concurrent.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentHashMapVSSkipListMap {


    static class Entry {
        int threadCount;
        long time;

        public Entry(int threadCount, long time) {
            this.threadCount = threadCount;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "count=" + threadCount +
                    ", time=" + time +
                    '}';
        }
    }

    private final static Map<Class<?>, List<Entry>> summary = new HashMap<Class<?>, List<Entry>>() {
        {
            put(ConcurrentHashMap.class, new ArrayList<>());
            put(ConcurrentSkipListMap.class, new ArrayList<>());
        }

    };

    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> hashMap = new ConcurrentHashMap<>();
        Map<String, Integer> skipListMap = new ConcurrentSkipListMap<>();
        for (int i = 10; i <= 100; ) {
            pressureTest(hashMap, i);

            pressureTest(skipListMap, i);

            i += 10;
        }


        summary.forEach((k, v) -> {
            System.out.println(k.getSimpleName());
            v.forEach(System.out::println);
        });
    }

    private static void pressureTest(final Map<String, Integer> map, int threadNumber) throws InterruptedException {
        long totalTime = 0L;
        final int MAX_THRESHOLD = 500_000;
        final AtomicInteger counter = new AtomicInteger(0);

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            map.clear();
            counter.set(0);
            ExecutorService executorService = Executors.newFixedThreadPool(threadNumber);
            for (int j = 0; j < threadNumber; j++) {
                executorService.execute(() -> {
                    for (int x = 0; x < MAX_THRESHOLD && counter.getAndIncrement() < MAX_THRESHOLD; x++) {
                        Integer randomNumber = (int) Math.ceil(Math.random() * 600_000);
                        map.get(String.valueOf(randomNumber));
                        map.put(String.valueOf(randomNumber), randomNumber);
                        // counter.get();
                    }
                });
            }

            executorService.shutdown();

            executorService.awaitTermination(2, TimeUnit.HOURS);

            long endTime = System.nanoTime();

            long period = (endTime - startTime) / 1_000_000;

            System.out.println("[" + MAX_THRESHOLD + "]" + "Insert/Retrieved SPEND ==== " + period + "ms");

            totalTime += period;



        }
        summary.get(map.getClass()).add(new Entry(threadNumber, totalTime / 5));
        System.out.println("[" + "FOR FIVE" + "]" + "   AVERAGE SPEND ====  " + totalTime / 5 + "ms");
        System.out.println(counter.get());
    }


}
