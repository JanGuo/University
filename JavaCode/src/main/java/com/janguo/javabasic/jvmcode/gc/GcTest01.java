package com.janguo.javabasic.jvmcode.gc;

/**
 * 使用JVM 参数
 * -verbose:gc          输出GC详细信息
 * -Xms20M              堆空间初始大小
 * -Xmx20M              堆空间最大大小
 * -Xmn10M              新生代大小
 * -XX:+PrintGCDetails  GC详细信息
 * -XX:SurvivorRatio=8  End Survivor 比例 8 ：1
 */
public class GcTest01 {
    public static void main(String[] args) throws InterruptedException {
        int size = 1024 * 1024;
        byte[] b1 = new byte[2 * size];
        byte[] b2 = new byte[2 * size];
        byte[] b3 = new byte[2 * size];
        byte[] b4 = new byte[2 * size];
/**
 * [GC (Allocation Failure 【分配失败】) [PSYoungGen【Parallel Scavenge收集器 新生代】: 6816K【执行垃圾回收之前，存活对象所占用的空间】->480K(9216K【新生代总的空间大小，其中一个survivor不使用所以是 10M*（8+1）/（8+1+1）】)] 6816K【执行GC之前总的堆空间大小】->6632K(19456K【总的堆的可用容量】), 0.0068111 secs]
 * [Times【单位秒】: user=0.03【用户空间所用时间】 sys=0.01【内核空间】, real=0.01【真正使用的时间】 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 480K->0K(9216K)] [ParOldGen【Parallel Old收集器】: 6152K->6428K(10240K)] 6632K->6428K(19456K), [Metaspace: 2649K->2649K(1056768K)], 0.0051586 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
 * Hello JVM ! ! !
 * Heap
 *  PSYoungGen      total 9216K, used 2290K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 *   eden space 8192K, 27% used [0x00000007bf600000,0x00000007bf83c8d0,0x00000007bfe00000)
 *   from space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
 *   to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
 *  ParOldGen       total 10240K, used 6428K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 *   object space 10240K, 62% used [0x00000007bec00000,0x00000007bf247100,0x00000007bf600000)
 *  Metaspace       used 2657K, capacity 4486K, committed 4864K, reserved 1056768K
 *   class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
 */
        System.out.println("Hello JVM ! ! !");
    }
}
