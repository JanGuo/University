package com.janguo.javabasic.concurrent.atomic.fieldupdater;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 可以修改其他对象的某个字段的值
 * 字段必须是volatile修饰的 并且不是被private修饰（但是如果是当前类可以是Private/protected）
 */
public class AtomicIntegerFieldUpdaterTest {


    public static void main(String[] args) {

        AtomicIntegerFieldUpdater<TestMe> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(TestMe.class, "i");

        List<Thread> threads = new ArrayList<>();
        TestMe me = new TestMe();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    int noIncrement = fieldUpdater.getAndIncrement(me);
                    System.out.println(noIncrement);
                }
            });
            threads.add(thread);
            thread.start();
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Main" + me.getI());


    }

    static class TestMe {
        volatile int i;

        public TestMe() {
        }

        public int getI() {
            return i;
        }
    }
}
