package com.janguo.javabasic.concurrent.thread.waitset;

/**
 * 检测Wait唤醒之后从哪里开始执行，是否需要再次抢锁
 *
 * 结果是从wait代码后面继续执行
 * 程序计数器 起作用--->是线程私有的
 * 程序计数器这块小空间里面记录的是当前线程正在执行的字节码的行号。字节码解释器通过改变计数器的值来获取下一条要执行的字节码。分支、循环、跳转、异常处理、线程恢复等基础功能都需要依赖这个计数器来完成。
 *
 */
public class WaitToRunning {
    private static final Object LOCK = new Object();

    private static void work(){
        synchronized (LOCK){
            System.out.println("Begin....");
            try {
                System.out.println("Thread will wait!");
                LOCK.wait();
                System.out.println("Thread will wack up!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread("Wait"){
            @Override
            public void run() {
                work();
            }
        }.start();

        Thread.sleep(10);

        synchronized (LOCK){
            LOCK.notify();
        }
    }
}
