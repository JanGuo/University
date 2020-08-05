package com.janguo.javabasic.jvmcode.gc;

/**
 * -XX:PretenureSizeThreshold=4194304 设置对象超过多大时候，直接进入老年代
 * 参数必须在串行的垃圾收集器，才能生效
 */
public class GcTest02 {
    public static void main(String[] args){
        int size = 1024 * 1024;
        byte[] b1 = new byte[5 * size];
        try {
            Thread.sleep(1_000_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
