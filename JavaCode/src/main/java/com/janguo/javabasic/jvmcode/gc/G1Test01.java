package com.janguo.javabasic.jvmcode.gc;

/**
 *
 * -verbose:gc
 * -Xms10m
 * -Xmx10m
 * -XX:+UseG1GC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:MaxGCPauseMillis=200m
 *
 * > Task :G1Test01.main()
 * 2020-08-08T15:23:01.974-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark), 0.0022800 secs]
 *    [Parallel Time: 1.4 ms, GC Workers: 8]
 *       [GC Worker Start (ms): Min: 84.9, Avg: 85.0, Max: 85.1, Diff: 0.2]
 *       [Ext Root Scanning (ms): Min: 0.3, Avg: 0.4, Max: 1.1, Diff: 0.8, Sum: 3.4]
 *       [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
 *          [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
 *       [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
 *       [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
 *       [Object Copy (ms): Min: 0.0, Avg: 0.2, Max: 0.6, Diff: 0.6, Sum: 1.6]
 *       [Termination (ms): Min: 0.0, Avg: 0.5, Max: 0.6, Diff: 0.6, Sum: 3.8]
 *          [Termination Attempts: Min: 1, Avg: 2.5, Max: 5, Diff: 4, Sum: 20]
 *       [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
 *       [GC Worker Total (ms): Min: 0.9, Avg: 1.1, Max: 1.3, Diff: 0.4, Sum: 8.9]
 *       [GC Worker End (ms): Min: 86.1, Avg: 86.1, Max: 86.3, Diff: 0.2]
 *    [Code Root Fixup: 0.0 ms]
 *    [Code Root Purge: 0.0 ms]
 *    [Clear CT: 0.3 ms]
 *    [Other: 0.6 ms]
 *       [Choose CSet: 0.0 ms]
 *       [Ref Proc: 0.2 ms]
 *       [Ref Enq: 0.0 ms]
 *       [Redirty Cards: 0.3 ms]
 *       [Humongous Register: 0.0 ms]
 *       [Humongous Reclaim: 0.0 ms]
 *       [Free CSet: 0.0 ms]
 *    [Eden: 1024.0K(6144.0K)->0.0B(2048.0K) Survivors: 0.0B->1024.0K Heap: 2662.7K(10.0M)->2480.1K(10.0M)]
 *  [Times: user=0.01 sys=0.00, real=0.00 secs]
 * 2020-08-08T15:23:01.977-0800: [GC concurrent-root-region-scan-start]
 * 2020-08-08T15:23:01.977-0800: [GC concurrent-root-region-scan-end, 0.0003057 secs]
 * 2020-08-08T15:23:01.977-0800: [GC concurrent-mark-start]
 * 2020-08-08T15:23:01.977-0800: [GC concurrent-mark-end, 0.0000522 secs]
 * 2020-08-08T15:23:01.977-0800: [GC remark 2020-08-08T15:23:01.977-0800: [Finalize Marking, 0.0008349 secs] 2020-08-08T15:23:01.978-0800: [GC ref-proc, 0.0000473 secs] 2020-08-08T15:23:01.978-0800: [Unloading, 0.0004398 secs], 0.0016228 secs]
 *  [Times: user=0.01 sys=0.00, real=0.00 secs]
 * 2020-08-08T15:23:01.980-0800: [GC cleanup 4528K->4528K(10M), 0.0008021 secs]
 *  [Times: user=0.00 sys=0.00, real=0.00 secs]
 * Hello G1 ! ! !
 * Heap
 *  garbage-first heap   total 10240K, used 4528K [0x00000007bf600000, 0x00000007bf700050, 0x00000007c0000000)
 *   region size 1024K, 2 young (2048K), 1 survivors (1024K)
 *  Metaspace       used 2657K, capacity 4486K, committed 4864K, reserved 1056768K
 *   class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
 *
 */
public class G1Test01 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] b1 = new byte[size];
        byte[] b2 = new byte[size];
        byte[] b3 = new byte[size];
        byte[] b4 = new byte[size];
        System.out.println("Hello G1 ! ! !");
    }
}
