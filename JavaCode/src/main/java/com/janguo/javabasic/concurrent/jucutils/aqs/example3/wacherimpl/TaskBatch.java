package com.janguo.javabasic.concurrent.jucutils.aqs.example3.wacherimpl;

import com.janguo.javabasic.concurrent.jucutils.aqs.example3.Table;
import com.janguo.javabasic.concurrent.jucutils.aqs.example3.Watcher;

import java.util.concurrent.CountDownLatch;

public class TaskBatch implements Watcher {

    private CountDownLatch latch;

    private TaskGroup taskGroup;

    public TaskBatch(int size, TaskGroup taskGroup) {
        this.taskGroup = taskGroup;
        this.latch = new CountDownLatch(size);
    }

    @Override
    public void done(Table table) {
        latch.countDown();
        if (latch.getCount() == 0) {
            System.out.println("The Table -" + table.getTableName() + "Finished Chick!!" + "Result =[" + table + "]");
            taskGroup.done(table);
        }
    }
}
