package com.janguo.netty.bytebuf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicUpdateTest {
    public static void main(String[] args) {
//        Person person = new Person();
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(() -> {
//                System.out.println(person.age++);
//            });
//            thread.start();
//        }


        AtomicIntegerFieldUpdater<Person> age = AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");
        Person person = new Person();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(age.getAndIncrement(person));
            });
            thread.start();
        }

    }


}

class Person {
    volatile int age = 1;
}
