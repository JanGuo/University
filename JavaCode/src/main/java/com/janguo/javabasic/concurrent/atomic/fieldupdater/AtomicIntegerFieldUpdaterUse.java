package com.janguo.javabasic.concurrent.atomic.fieldupdater;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 这种设计模式在Netty中有应用
 */
public class AtomicIntegerFieldUpdaterUse {
    private volatile int i;
    private AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterUse> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterUse.class,"i");

    public void update(int newValue){
        fieldUpdater.compareAndSet(this,i,newValue);
    }

    public int getI(){
        return i;
    }

    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterUse use = new AtomicIntegerFieldUpdaterUse();
        use.update(10);
        System.out.println(use.getI());
    }
}
