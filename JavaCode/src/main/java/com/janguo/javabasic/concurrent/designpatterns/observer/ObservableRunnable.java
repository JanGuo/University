package com.janguo.javabasic.concurrent.designpatterns.observer;

public abstract class ObservableRunnable implements Runnable {
    final protected LifeCycleListener listener;

    public ObservableRunnable(LifeCycleListener listener) {
        this.listener = listener;
    }

    public void notifyChange(RunnableEvent runnableEvent) {
        listener.onEvent(runnableEvent);
    }

    public enum RunnableState {
        RUNNING, ERROR, DONE;
    }

    public static class RunnableEvent {
        private final RunnableState state;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }
}
