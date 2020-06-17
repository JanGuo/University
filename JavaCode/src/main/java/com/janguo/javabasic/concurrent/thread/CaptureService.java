package com.janguo.javabasic.concurrent.thread;

import java.util.*;
import java.util.stream.Stream;

public class CaptureService {
    final static private LinkedList<Count> COUNTS = new LinkedList<>();
    private static final int MAC_WORKED = 5;
    public static void main(String[] args) {
        List<Thread> worker = new ArrayList<>();
        Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10")
                .stream().map(CaptureService::creatThread)
                .forEach(n->{
                    n.start();
                    worker.add(n);
                });
        worker.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Optional.of("All of Capture work is Finished").ifPresent(System.out::println);

    }

    private static Thread creatThread(String name){
        return new Thread(()->{
            Optional.of("The Worker --"+Thread.currentThread().getName()+" --   BEGIN Capture data").ifPresent(System.out::println);
            synchronized (COUNTS) {
                while (COUNTS.size() > MAC_WORKED) {
                    try {
                        COUNTS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
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
                COUNTS.removeFirst();
                COUNTS.notifyAll();
            }
        },name);
    }

    static class Count{}
}
