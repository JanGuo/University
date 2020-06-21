package com.janguo.javabasic.concurrent.designpatterns.observer;

import java.util.List;

public class ThreadLifeCycleObserver implements LifeCycleListener {

    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return;
        }

        ids.stream().forEach(id -> {
            new Thread(new ObservableRunnable(this) {
                @Override
                public void run() {
                    try {
                        notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                        System.out.println("Query form Database by " + id);
                        Thread.sleep(200);
//                        int a = 10/0;
                        notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                    } catch (Exception e) {
                        notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                    }
                }
            }, ("Thread-" + id)).start();
        });
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent runnableEvent) {
        synchronized (LOCK) {
            if (runnableEvent.getState() == ObservableRunnable.RunnableState.RUNNING) {
                System.out.println("Listener Find: Thread" + runnableEvent.getThread().getName() + "正在运行！");
            }
            if (runnableEvent.getState() == ObservableRunnable.RunnableState.DONE) {
                System.out.println("Listener Find: Thread" + runnableEvent.getThread().getName() + "运行结束！");
                System.out.println("准备向数据库中\r上传数据");
                System.out.println("Running--------Update To Database!");
            }
            if (runnableEvent.getState() == ObservableRunnable.RunnableState.ERROR) {
                System.out.println("Listener Find: Thread" + runnableEvent.getThread().getName() + "出现异常，而终止");
            }

        }
    }
}
