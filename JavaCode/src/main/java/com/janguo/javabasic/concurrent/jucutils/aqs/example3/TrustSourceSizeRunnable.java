package com.janguo.javabasic.concurrent.jucutils.aqs.example3;

import com.janguo.javabasic.concurrent.jucutils.aqs.example3.wacherimpl.TaskBatch;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TrustSourceSizeRunnable implements Runnable{
    private static Random random = new Random(System.currentTimeMillis());

    private final Table table;

    private TaskBatch taskBatch;

    public TrustSourceSizeRunnable(Table table,TaskBatch taskBatch) {
        this.taskBatch = taskBatch;
        this.table = table;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        table.targetCount = chickTargetCount();
        taskBatch.done(table);
    }


    public long chickTargetCount(){
        return 10000L;
    }
}
