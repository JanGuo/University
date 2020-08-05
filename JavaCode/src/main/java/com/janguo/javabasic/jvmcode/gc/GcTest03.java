package com.janguo.javabasic.jvmcode.gc;

/**
 * -XX:+PrintCommandLineFlags
 * -XX:MaxTenuringThreshold=5
 *  默认值15，CMS中默认为6，G1中默认15（JVM中，该数值是由4个bit来表示，最大值为1111 => 15)
 *  设置晋升（Promote）到老年代阈值的GC中，设置该阈值打最大值
 * -XX:+PrintTenuringDistribution
 */
public class GcTest03 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] b1 = new byte[2 * size];
        byte[] b2 = new byte[2 * size];
        byte[] b3 = new byte[2 * size];
        byte[] b4 = new byte[2 * size];
        System.out.println("Hello GC! ! !");
    }
}
