package com.janguo.javabasic.concurrent.thread.volatile1;

/**
 * ·可见性。对一个volatile变量的读，总是能看到(任意线程)对这个volatile变量最后的写入。
 *
 * ·原子性:对任意单个volatile变量的读/写具有原子性，但类似于volatile++这种复合操作不 具有原子性。
 */
public class VolatileFeatureExample1 {
    volatile long v1 = 0L;

    public void getAndIncrement() {
        v1++;
    }

    public long getV1() {
        return v1;
    }

    public void setV1(long v1) {
        this.v1 = v1;
    }
}

class VolatileFeatureExample2 {
    long v2 = 0L;

    public void getAndIncrement() {
        long temp = getV2();
        temp += 1L;
        setV2(temp);
    }

    public synchronized long getV2() {
        return v2;
    }

    public synchronized void setV2(long v2) {
        this.v2 = v2;
    }
}