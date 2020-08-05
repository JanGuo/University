package com.janguo.javabasic.jvmcode.gc;

/**
 * -XX:TargetSurvivorRatio=60  当Survivor区中有60%的数据是没有被晋升到老年代的时候，就会重新计算晋升阈值
 * -XX:+PrintGCDateStamps       打印执行GC的时间戳 UTC 格式
 *
 * -XX:+UseConcMarkSweepGC     老年代使用CMS垃圾回收算法
 * -XX:+UseParNewGC              新生代使用 ParNewGC
 *
 *
 *
 * -verbose:gc
 * -Xms100M
 * -Xmn50M
 * -XX:TargetSurvivorRatio=60
 * -XX:+PrintTenuringDistribution
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseParNewGC
 * -XX:MaxTenuringThreshold=3
 */
public class GcTest04 {
    /**
     *2020-08-05T22:26:39.228-0800: [GC (Allocation Failure) 2020-08-05T22:26:39.228-0800: [ParNew
     * Desired survivor size 3145728 bytes, new threshold 3 (max 3)                                                                 3145728 == 3M    50 * 1/(8 + 1 + 1) * 60% = 3M 当survivor中的数据总量超过3M 则会触发 重新计算阈值的算法
     * - age   1:    1341472 bytes,    1341472 total                                                                                前几次在方法（局部变量中定义变量，在执行GC算法之后空间会被清除， 但是当执行输出55555555555 的时候会出现无法被回收的
     * : 40551K->1343K(46080K), 0.0014369 secs] 40551K->1343K(97280K), 0.0015332 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]  大于3M的空间（及出超过了survivor的60%）则会修改阈值为 当前年龄的阈值（这个程序阈值为 1 ） 所以在输出666666666666之前
     * 111111111                                                                                                                    所有的为年龄（包括年龄为1、2、3）的所有空间的数据晋升为老年代
     * 2020-08-05T22:26:40.237-0800: [GC (Allocation Failure) 2020-08-05T22:26:40.237-0800: [ParNew
     * Desired survivor size 3145728 bytes, new threshold 3 (max 3)
     * - age   1:        576 bytes,        576 total
     * - age   2:    1339720 bytes,    1340296 total
     * : 42082K->1433K(46080K), 0.0024048 secs] 42082K->1433K(97280K), 0.0024363 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     * 222222222
     * 2020-08-05T22:26:41.248-0800: [GC (Allocation Failure) 2020-08-05T22:26:41.248-0800: [ParNew
     * Desired survivor size 3145728 bytes, new threshold 3 (max 3)
     * - age   1:         64 bytes,         64 total
     * - age   2:        576 bytes,        640 total
     * - age   3:    1339512 bytes,    1340152 total
     * : 41964K->1360K(46080K), 0.0011505 secs] 41964K->1360K(97280K), 0.0011856 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     * 3333333333
     * 2020-08-05T22:26:42.256-0800: [GC (Allocation Failure) 2020-08-05T22:26:42.256-0800: [ParNew
     * Desired survivor size 3145728 bytes, new threshold 3 (max 3)
     * - age   1:         64 bytes,         64 total
     * - age   2:         64 bytes,        128 total
     * - age   3:        576 bytes,        704 total
     * : 42091K->80K(46080K), 0.0024966 secs] 42091K->1408K(97280K), 0.0025461 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     * 4444444444
     * 2020-08-05T22:26:43.265-0800: [GC (Allocation Failure) 2020-08-05T22:26:43.265-0800: [ParNew
     * Desired survivor size 3145728 bytes, new threshold 1 (max 3)
     * - age   1:    3145840 bytes,    3145840 total
     * - age   2:         64 bytes,    3145904 total
     * - age   3:         64 bytes,    3145968 total
     * : 40814K->3098K(46080K), 0.0018239 secs] 42142K->4427K(97280K), 0.0019023 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     * 55555555555
     * 2020-08-05T22:26:44.275-0800: [GC (Allocation Failure) 2020-08-05T22:26:44.275-0800: [ParNew
     * Desired survivor size 3145728 bytes, new threshold 3 (max 3)
     * - age   1:         64 bytes,         64 total
     * : 43834K->2K(46080K), 0.0022969 secs] 45163K->4402K(97280K), 0.0023414 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
     * 666666666666
     * Hello GC END ! ! !
     * Heap
     *  par new generation   total 46080K, used 13910K [0x00000006c0000000, 0x00000006c3200000, 0x00000006c3200000)
     *   eden space 40960K,  33% used [0x00000006c0000000, 0x00000006c0d95238, 0x00000006c2800000)
     *   from space 5120K,   0% used [0x00000006c2800000, 0x00000006c2800810, 0x00000006c2d00000)
     *   to   space 5120K,   0% used [0x00000006c2d00000, 0x00000006c2d00000, 0x00000006c3200000)
     *  concurrent mark-sweep generation total 51200K, used 4400K [0x00000006c3200000, 0x00000006c6400000, 0x00000007c0000000)
     *  Metaspace       used 2658K, capacity 4486K, committed 4864K, reserved 1056768K
     *   class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
     *
     * Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
     * Use '--warning-mode all' to show the individual deprecation warnings.
     * See https://docs.gradle.org/6.3/userguide/command_line_interface.html#sec:command_line_warnings
     *
     * BUILD SUCCESSFUL in 6s
     * 2 actionable tasks: 2 executed
     * 10:26:45 下午: Task execution finished 'GcTest04.main()'.
     */
    public static void main(String[] args) throws InterruptedException {
        byte[] byte_1 = new byte[512 * 1024];
        byte[] bytes_2 = new byte[512 * 1024];

        myGc();
        Thread.sleep(1000);
        System.out.println("111111111");

        myGc();
        Thread.sleep(1000);
        System.out.println("222222222");

        myGc();
        Thread.sleep(1000);
        System.out.println("3333333333");

        myGc();
        Thread.sleep(1000);
        System.out.println("4444444444");

        byte[] bytes_3 = new byte[1024 * 1024];
        byte[] bytes_4 = new byte[1024 * 1024];
        byte[] bytes_5 = new byte[1024 * 1024];

        myGc();
        Thread.sleep(1000);
        System.out.println("55555555555");

        myGc();
        Thread.sleep(1000);
        System.out.println("666666666666");


        System.out.println("Hello GC END ! ! !");
    }

    private static void myGc(){
        for (int i = 0; i < 40; i++) {
            byte[] bytes = new byte[1024*1024];
        }
    }
}
