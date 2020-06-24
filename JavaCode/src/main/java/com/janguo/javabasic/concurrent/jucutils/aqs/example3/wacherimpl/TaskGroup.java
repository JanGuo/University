package com.janguo.javabasic.concurrent.jucutils.aqs.example3.wacherimpl;

import com.janguo.javabasic.concurrent.jucutils.aqs.example3.Event;
import com.janguo.javabasic.concurrent.jucutils.aqs.example3.Table;
import com.janguo.javabasic.concurrent.jucutils.aqs.example3.Watcher;

import java.util.concurrent.CountDownLatch;
import java.util.function.DoubleToIntFunction;

public class TaskGroup implements Watcher {

    private CountDownLatch latch;

    private Event event;

    public TaskGroup(int size,Event event) {
        this.event = event;
        this.latch = new CountDownLatch(size);
    }

    @Override
    public void done(Table table) {
        latch.countDown();
        if (latch.getCount() == 0) {
            System.out.println("All Table Chick is Down!!!  Event--" + event.gerId());
        }
    }


    public CountDownLatch getLatch() {
        return latch;
    }
}
