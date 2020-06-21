package com.janguo.javabasic.concurrent.designpatterns.observer;

public interface LifeCycleListener {
    public void onEvent(ObservableRunnable.RunnableEvent runnableEvent) ;
}
