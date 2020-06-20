package com.janguo.javabasic.concurrent.designpatterns.single;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * JDK 版本：JDK1.5 起
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 *
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */
public class LazySingle04 {
    private static volatile LazySingle04 instance;

    private LazySingle04(){
        // Empty
    }

    public static LazySingle04 getInstance(){
        if (null == instance){
            synchronized (LazySingle04.class){
                if (null == instance){
                    instance = new LazySingle04();
                }
            }
        }
        return instance;
    }
}
