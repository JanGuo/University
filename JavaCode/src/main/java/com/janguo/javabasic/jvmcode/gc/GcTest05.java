package com.janguo.javabasic.jvmcode.gc;

/**
 * 指定CMS收集器，因为只能用于老年代，所以无需指定
 *
 * 老年代使用CMS收集器，则新生代默认使用 par new
 *
 *
 *
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M                  新生代大小
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:+UseConcMarkSweepGC
 */
public class GcTest05 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] b1 = new byte[4 * size];
        System.out.println("11111111111");

        byte[] b2 = new byte[4 * size];
        System.out.println("22222222222");

        byte[] b3 = new byte[4 * size];
        System.out.println("33333333333");

        byte[] b4 = new byte[2 * size];
        System.out.println("44444444444");
    }
}
