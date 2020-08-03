package com.janguo.javabasic.concurrent.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class ConcurrentHashMapVSSkipListMap {

    public static void main(String[] args) throws InterruptedException {
        /**
         * [5000000]Insert/Retrieved SPEND ==== 1215ms
         * [5000000]Insert/Retrieved SPEND ==== 891ms
         * [5000000]Insert/Retrieved SPEND ==== 951ms
         * [5000000]Insert/Retrieved SPEND ==== 949ms
         * [5000000]Insert/Retrieved SPEND ==== 936ms
         * [FOR FIVE]   ALL SPEND ====  4942ms
         */
        ConcurrentHashMapVSSkipListMap.pressureTest(new ConcurrentHashMap<>(),10);
        /**
         * > Task :ConcurrentHashMapVSSkipListMap.main()
         * [5000000]Insert/Retrieved SPEND ==== 2494ms
         * [5000000]Insert/Retrieved SPEND ==== 2297ms
         * [5000000]Insert/Retrieved SPEND ==== 2461ms
         * [5000000]Insert/Retrieved SPEND ==== 2460ms
         * [5000000]Insert/Retrieved SPEND ==== 2363ms
         * [FOR FIVE]   ALL SPEND ====  12075ms
         */
//        ConcurrentHashMapVSSkipListMap.pressureTest(new ConcurrentSkipListMap<>(),10);
    }
    private static void pressureTest(final Map<String, Integer> map, int threadNumber) throws InterruptedException {
        long totalTime = 0L;
        final int MAX_THRESHOLD = 500_000;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            map.clear();
            ExecutorService executorService = Executors.newFixedThreadPool(threadNumber);
            for (int j = 0; j < threadNumber; j++) {
                executorService.execute(() -> {
                    for (int x = 0; x < MAX_THRESHOLD; x++) {
                        Integer randomNumber = (int) Math.ceil(Math.random() * 600_000);
                        map.get(String.valueOf(randomNumber));
                        map.put(String.valueOf(randomNumber), randomNumber);
                    }
                });
            }

            executorService.shutdown();

            executorService.awaitTermination(2, TimeUnit.HOURS);
            long endTime = System.nanoTime();

            long period = (endTime - startTime) / 1_000_000;

            System.out.println("[" + threadNumber * MAX_THRESHOLD + "]" + "Insert/Retrieved SPEND ==== " + period + "ms");

            totalTime += period;

        }
        System.out.println("[" + "FOR FIVE" + "]" + "   ALL SPEND ====  " + totalTime + "ms");
    }
}
